package br.com.drone4.environment.outdoor;

import static javax.media.opengl.GL.GL_LINEAR;
import static javax.media.opengl.GL.GL_TEXTURE_2D;
import static javax.media.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static javax.media.opengl.GL.GL_TEXTURE_MIN_FILTER;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import br.com.abby.util.CameraGL;
import br.com.drone4.automated.AutonomousFlight;
import br.com.drone4.automated.action.GoToAction;
import br.com.drone4.automated.action.MoveAction;
import br.com.drone4.automated.action.TurnAction;
import br.com.drone4.control.Sensitivity;
import br.com.drone4.drone.PhantomDJI;
import br.com.drone4.model.sensor.camera.StandardCamera;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.luvia.grid.GridApplication;
import br.com.luvia.loader.TextureLoader;

import com.jogamp.opengl.util.awt.Screenshot;
import com.jogamp.opengl.util.texture.Texture;

public class CleanEnvironment extends GridApplication {

	private AutonomousFlight flight;
	
	protected StandardCamera droneCamera;

	//Scene Stuff
	private Texture road;

	protected CameraGL cameraGL;

	protected PhantomDJI drone;

	protected float mx = 0;

	protected float my = 0;

	protected boolean click = false;

	private boolean forwardPressed = false;

	private boolean backwardPressed = false;

	private boolean turnLeftPressed = false;

	private boolean turnRightPressed = false;

	private boolean upPressed = false;

	private boolean downPressed = false;

	private boolean rightPressed = false;

	private boolean leftPressed = false;

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
		drone = new PhantomDJI(1, 8, 0);

		droneCamera = drone.getCamera();

		cameraGL = new CameraGL(0, 20, -10);

		cameraGL.setTarget(drone);

		//Load Road Texture
		road = TextureLoader.getInstance().loadTexture("road.jpg");

		//Configure Autonomous Flight
		List<MoveAction> actionList = new ArrayList<MoveAction>();

		actionList.add(new GoToAction(0, 8, 5));
		
		actionList.add(new TurnAction(0, 540, 0));
		
		actionList.add(new GoToAction(0, 5, 7));
		actionList.add(new GoToAction(0, 10, 10));
		actionList.add(new GoToAction(0, 5, 20));
		
		flight = new AutonomousFlight(drone, actionList);
		
		updateAtFixedRate(300);

	}
	
	private void drawFloor(GL2 gl) {

		gl.glColor3d(1, 1, 1);

		gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

		drawRoad(gl, 200, 120);

	}

	protected void drawRoad(GL2 gl, double x, double y) {

		double tileSize = 3;

		road.enable(gl);
		road.bind(gl);

		double startX = 0;

		for(int i=0;i<60;i++) {

			drawTile(gl, startX, i, tileSize);

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
		
		glu.gluPerspective(60*zoom, aspect, 1, 100);
		
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

			forwardPressed = true;
			//angleX += 5;

		} else if(event.isKeyUp(KeyEvent.TSK_UP_ARROW)) {
			forwardPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {

			backwardPressed = true;
			//angleY += 5;

		} else if(event.isKeyUp(KeyEvent.TSK_DOWN_ARROW)) {

			backwardPressed = false;
			//angleY -= 5;

		}

		if(event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {

			turnLeftPressed = true;
			//angleY += 5;

		} else if(event.isKeyUp(KeyEvent.TSK_LEFT_ARROW)) {

			turnLeftPressed = false;

		}

		if(event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {

			turnRightPressed = true;
			//angleY -= 5;
		} else if(event.isKeyUp(KeyEvent.TSK_RIGHT_ARROW)) {
			turnRightPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_I)) {
			
			//droneCamera.getTarget().setOffsetX(+1);			
			droneCamera.setOffsetX(+1);
		}
		
		if(event.isKeyDown(KeyEvent.TSK_K)) {
			
			//droneCamera.getTarget().setOffsetX(-1);			
			droneCamera.setOffsetX(-1);
		}
		
		if(event.isKeyDown(KeyEvent.TSK_L)) {
			
			//droneCamera.getTarget().setOffsetZ(+1);	
			droneCamera.setOffsetZ(+1);
		}
		
		if(event.isKeyDown(KeyEvent.TSK_J)) {
			
			//droneCamera.getTarget().setOffsetZ(-1);
			droneCamera.setOffsetZ(-1);
		}
		
		return GUIEvent.NONE;
	}

	public GUIEvent updateMouse(PointerEvent event) {

		mx = event.getX();

		my = event.getY();

		if(event.isButtonDown(MouseButton.MOUSE_BUTTON_LEFT)) {
			cameraGL.setZ(cameraGL.getZ()+0.1f);
			click = true;
		}

		if(event.isButtonUp(MouseButton.MOUSE_BUTTON_LEFT)) {
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

		captureCamera(gl, droneCamera);
		
		gl.glViewport(x, y, w, h);
				
		//Update Camera View
		updateCamera(gl, cameraGL);
		
		drawScene(gl);
				
	}
	
	protected void captureCamera(GL2 gl, StandardCamera camera) {
		
		int w = camera.getWidth();
		
		int h = camera.getHeight();
				
		gl.glViewport(0, 0, w, h);
		
		//Update Camera View
		aimCamera(gl, camera);

		//gl.glRotated(angleX, 1, 0, 0);
		
		//gl.glRotated(camera.getAngleY(), 0, 1, 0);
		//gl.glTranslated(camera.getX(), camera.getY(), camera.getZ());
		
		//gl.glRotated(angleZ, 0, 0, 1);
		
		drawScene(gl);
		
		//Draw Drone Camera
		camera.setBufferedImage(Screenshot.readToBufferedImage(0, 0, w, h, false));
		
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(1f, 1f, 1f, 1);
		
		gl.glLoadIdentity();
		
	}

	protected void drawScene(GL2 gl) {

		//Draw Scene
		drawFloor(gl);

		drone.getModel().draw(gl);

		gl.glFlush();

	}
	
	@Override
	public void timeUpdate(long now) {

		flight.flight();

		manualFlight();

	}
	
	private void manualFlight() {
		
		if(upPressed) {
			drone.goUp(Sensitivity.FULL_POSITIVE);
		}

		if(downPressed) {
			drone.goDown(Sensitivity.FULL_NEGATIVE);
		}

		if(rightPressed) {
			drone.goRight(Sensitivity.FULL_POSITIVE);
		}

		if(leftPressed) {
			drone.goLeft(Sensitivity.FULL_NEGATIVE);
		}

		if(forwardPressed) {
			drone.goForward(Sensitivity.FULL_POSITIVE);
		}

		if(backwardPressed) {
			drone.goBackward(Sensitivity.FULL_NEGATIVE);
		}

		if(turnRightPressed) {
			drone.turnRight(Sensitivity.FULL_POSITIVE);
		}

		if(turnLeftPressed) {
			drone.turnLeft(Sensitivity.FULL_NEGATIVE);
		}
		
	}

	@Override
	public void draw(Graphic g) {

		//Draw PipCamera
		g.drawImage(droneCamera.getBufferedImage(), 0, 60);
		
		//Draw Information
		g.setColor(Color.WHITE);
		g.drawShadow(20,60, "Scene",Color.BLACK);

		g.drawShadow(20,120, "DroneX: "+(drone.getX()),Color.BLACK);
		g.drawShadow(20,140, "DroneY: "+(drone.getY()),Color.BLACK);
		g.drawShadow(20,160, "DroneZ: "+(drone.getZ()),Color.BLACK);
		
		g.drawShadow(20,200, "DroneAngleY: "+(drone.getAngleY()),Color.BLACK);
		
		g.drawShadow(20,220, "CameraAngleX: "+(droneCamera.getAngleX()),Color.BLACK);
		g.drawShadow(20,240, "CameraAngleY: "+(droneCamera.getAngleY()),Color.BLACK);
		g.drawShadow(20,260, "CameraAngleZ: "+(droneCamera.getAngleZ()),Color.BLACK);

	}

}