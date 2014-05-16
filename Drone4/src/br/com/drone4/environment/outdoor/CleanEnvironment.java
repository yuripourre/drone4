package br.com.drone4.environment.outdoor;

import static javax.media.opengl.GL.GL_LINEAR;
import static javax.media.opengl.GL.GL_TEXTURE_2D;
import static javax.media.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static javax.media.opengl.GL.GL_TEXTURE_MIN_FILTER;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import br.com.drone4.drone.PhantomDJI;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.luvia.grid.GridApplication;
import br.com.luvia.loader.TextureLoader;
import br.com.luvia.util.CameraGL;

import com.jogamp.opengl.util.awt.Screenshot;
import com.jogamp.opengl.util.texture.Texture;

public class CleanEnvironment extends GridApplication {

	private CameraGL droneCamera;
	
	//Scene Stuff
	private Texture road;

	protected CameraGL cameraGL;
	
	protected PhantomDJI drone;

	protected float mx = 0;

	protected float my = 0;

	protected boolean click = false;

	protected double angleX = 0;

	protected double angleY = 0;
	
	protected double angleZ = 0;

	protected BufferedImage pipCamera;

	protected Color markerColor = Color.BLACK;
	
	boolean upPressed = false;
	
	boolean downPressed = false;
	
	boolean rightPressed = false;
	
	boolean leftPressed = false;
	
	public CleanEnvironment(int w, int h) {
		super(w, h);
	}

	@Override
	public void init(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();

		// Global settings
		gl.glEnable(GL.GL_DEPTH_TEST);
		
		gl.glDepthFunc(GL.GL_LEQUAL);
		
		gl.glShadeModel(GL2.GL_SMOOTH);
		
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		
	}

	@Override
	public void load() {
		
		//Size in meters		
		drone = new PhantomDJI(0, 10, 1);
		
		drone.setAngleY(-90);
		
		droneCamera = drone.getCamera();
		
		cameraGL = new CameraGL(0, 16, 1);
				
		//cameraGL.setTarget(0, 0, 0);

		//Start PipCamera
		BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();
		
		pipCamera = image;

		//Load Road Texture
		road = TextureLoader.getInstance().loadTexture("road.jpg");
		
		updateAtFixedRate(300);
		
	}

	private void drawFloor(GL2 gl) {

		gl.glColor3d(1, 1, 1);

		gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

		drawRoad(gl, 200, 120);

	}

	private void drawRoad(GL2 gl, double x, double y) {

		double tileSize = 3;

		road.enable(gl);
		road.bind(gl);

		double startX = -.5;
				
		for(int i=0;i<60;i++) {
			
			drawTile(gl, startX, -i, tileSize);

		}

		road.disable(gl);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

		GL2 gl = drawable.getGL().getGL2();

		gl.glViewport (x, y, width, height);

		gl.glMatrixMode(GL2.GL_PROJECTION);

		gl.glLoadIdentity();

		float aspect = (float)width / (float)height; 

		glu.gluPerspective(60, aspect, 1, 100);

	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {

		if(event.isKeyDown(KeyEvent.TSK_W)) {
			upPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_W)) {
			upPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_D)) {
			rightPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_D)) {
			rightPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_A)) {
			leftPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_A)) {
			leftPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_S)) {
			downPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_S)) {
			downPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
			
			angleX += 5;

		} else if(event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {

			angleX -= 5;

		}

		if(event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {

			angleY += 5;

		} else if(event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {

			angleY -= 5;

		}
		
		if(event.isKeyDown(KeyEvent.TSK_M)) {

			angleZ -= 5;

		} else if(event.isKeyDown(KeyEvent.TSK_N)) {

			angleZ += 5;

		}

		return GUIEvent.NONE;
	}

	public GUIEvent updateMouse(PointerEvent event) {

		mx = event.getX();
		
		my = event.getY();

		if(event.onButtonDown(MouseButton.MOUSE_BUTTON_LEFT)) {
			cameraGL.setZ(cameraGL.getZ()+0.1f);
			click = true;
		}

		if(event.onButtonUp(MouseButton.MOUSE_BUTTON_LEFT)) {
			cameraGL.setZ(cameraGL.getZ()-0.1f);
			
			click = false;
		}

		return GUIEvent.NONE;
	}

	@Override
	public void display(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(1f, 1f, 1f, 1);
		
		//Update Camera View
		updateCamera(gl, cameraGL);

		gl.glRotated(angleX, 1, 0, 0);
		gl.glRotated(angleY, 0, 1, 0);
		gl.glRotated(angleZ, 0, 0, 1);
		
		drawScene(gl);
		
		gl.glViewport(0, h-40-h/4, w/4, h/4);
		gl.glLoadIdentity();
		updateCamera(gl, droneCamera);
		
		//Draw Drone Camera
		pipCamera = Screenshot.readToBufferedImage(0, h-40-h/4, w/4, h/4, false);
		
		drawScene(gl);

	}
	
	private void drawScene(GL2 gl) {

		//Draw Scene
		drawFloor(gl);

		drone.getModel().draw(gl);
		
		gl.glFlush();
		
	}

	protected void drawSphere(GL2 gl) {

		final float radius = 1.378f;
		final int slices = 16;
		final int stacks = 16;

		gl.glPushMatrix();

		// Draw sphere (possible styles: FILL, LINE, POINT).
		gl.glColor3f(0.3f, 0.5f, 1f);

		gl.glTranslated(0, radius, 0);

		GLUquadric earth = glu.gluNewQuadric();

		glu.gluQuadricDrawStyle(earth, GLU.GLU_FILL);
		glu.gluQuadricNormals(earth, GLU.GLU_FLAT);
		glu.gluQuadricOrientation(earth, GLU.GLU_OUTSIDE);

		glu.gluSphere(earth, radius, slices, stacks);

		glu.gluDeleteQuadric(earth);

		gl.glPopMatrix();
	}

	protected void drawCube(GL2 gl) {

		float x = 0;

		float y = 0;

		float z = 0;

		gl.glColor3f(0.3f, 0.5f, 1f);

		gl.glPushMatrix();

		gl.glTranslated(0, 0.5, 0);

		gl.glTranslated(x, y, z);

		gl.glPushMatrix();
		drawSquare(gl);        // front face is red
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(180,0,1,0); // rotate square to back face
		drawSquare(gl);        // back face is cyan
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(-90,0,1,0); // rotate square to left face
		drawSquare(gl);       // left face is green
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(90,0,1,0); // rotate square to right face
		drawSquare(gl);       // right face is magenta
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(-90,1,0,0); // rotate square to top face
		drawSquare(gl);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(90,1,0,0); // rotate square to bottom face
		drawSquare(gl);
		gl.glPopMatrix();

		gl.glPopMatrix();

	}

	private void drawSquare(GL2 gl) {

		float size = 1;

		gl.glTranslatef(0,0,size);

		gl.glBegin(GL.GL_TRIANGLE_FAN);
		gl.glVertex2f(-size,-size);    // Draw the square (before the
		gl.glVertex2f(size,-size);     //   the translation is applied)
		gl.glVertex2f(size,size);      //   on the xy-plane, with its
		gl.glVertex2f(-size,size);     //   at (0,0,0).
		gl.glEnd();

	}
		
	public void timeUpdate(long now) {
				
		if(upPressed) {
			drone.goForward();			
		}
		
		if(downPressed) {
			drone.goBackward();			
		}
		
		if(rightPressed) {
			drone.goRight();			
		}
		
		if(leftPressed) {
			drone.goLeft();			
		}
		
	}

	@Override
	public void draw(Graphic g) {

		//Draw Information
		g.setColor(Color.WHITE);
		g.drawShadow(20,20, "Scene",Color.BLACK);

		g.drawShadow(20,40, "AngleX: "+(angleX-5),Color.BLACK);

		g.drawShadow(20,60, "AngleY: "+(angleY),Color.BLACK);

		drawPipCamera(g, pipCamera);

	}

	protected void drawPipCamera(Graphic g, BufferedImage pipCamera) {

		//AffineTransform transform = AffineTransform.getScaleInstance(640/w, 480/h);
		AffineTransform transform = AffineTransform.getScaleInstance(0.2, 0.2);

		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		BufferedImage camera = op.filter(pipCamera, null);

		g.drawImage(camera, 0, 0);

	}

}