package examples.drone4.outdoor;

import java.awt.Color;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import br.com.abby.linear.AimPoint;
import br.com.abby.loader.MeshLoader;
import br.com.abby.util.CameraGL;
import br.com.drone4.drone.PhantomDJI;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.graphics.SVGColor;
import br.com.etyllica.util.PathHelper;
import br.com.luvia.core.video.Graphics3D;
import br.com.luvia.grid.GridApplication;
import br.com.luvia.light.LightSource3D;
import br.com.luvia.linear.Mesh;

public class DEMView extends GridApplication {

	protected CameraGL cameraGL;
	protected AimPoint mainView;

	protected PhantomDJI drone;

	protected float mx = 0;

	protected float my = 0;

	protected boolean click = false;

	//private Mesh terrain;
	
	private LightSource3D light;

	public DEMView(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		loadingInfo = "Loading terrain...";
		System.out.println(loadingInfo);

		//String terrainPath = PathHelper.desktopDirectory()+"terrain.obj";
		
		//String terrainPath = PathHelper.desktopDirectory()+"drone4/prainha/prainha_simplified_3d_mesh.obj";

		//terrain = new Mesh(MeshLoader.getInstance().loadModel(terrainPath, true));
		//terrain.setAngleX(90);

		loadingInfo = "Terrain Loaded";
		System.out.println(loadingInfo);
	}

	@Override
	public void init(Graphics3D drawable) {

		GL2 gl = drawable.getGL().getGL2();

		// Size in meters
		drone = new PhantomDJI(1, 8, 0);
		drone.getModel().setColor(Color.RED);

		//droneCamera = drone.getCamera();

		cameraGL = new CameraGL(0, 20, -10);

		mainView = new AimPoint(0,-3220,40);
		mainView.setAngleX(120);
		mainView.setAngleY(90);

		cameraGL.setTarget(drone);

		// Global settings
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glDepthFunc(GL.GL_LEQUAL);
		gl.glShadeModel(GL2.GL_SMOOTH);

		light = new LightSource3D();
		light.setCoordinates(50.0f, 200.0f, 100.0f);
		light.setColor(SVGColor.BLUE);
		
		light.configureLight(gl, GL2.GL_LIGHT0);
		
		//gl.glEnable(GL2.GL_LIGHTING);
		//gl.glEnable(GL2.GL_LIGHT0);
		
		gl.glEnable(GL2.GL_POLYGON_SMOOTH);
		gl.glEnable(GL2.GL_MULTISAMPLE);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
	}

	@Override
	public void reshape(Graphics3D drawable, int x, int y, int width, int height) {

		GL2 gl = drawable.getGL2();
		GLU glu = drawable.getGLU();

		gl.glViewport(x, y, width, height);

		gl.glMatrixMode(GL2.GL_PROJECTION);

		gl.glLoadIdentity();

		float aspect = (float) width / (float) height;

		glu.gluPerspective(60 * zoom, aspect, 1, 100000);
	}

	@Override
	public void display(Graphics3D drawable) {

		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(1f, 1f, 1f, 1);

		gl.glViewport(x, y, w, h);

		// Update Camera View
		//drawable.updateCamera(cameraGL);
		// drawable.aimCamera(followCamera);

		drawable.aimCamera(mainView);
		
		//Draw Light as a Sphere
		drawable.drawSphere(light, 40);

		drawScene(gl);

		//terrain.draw(gl);
	}

	protected void drawScene(GL2 gl) {

		// Draw Scene
		drone.getModel().setScale(200);
		drone.getModel().draw(gl);

		//gl.glFlush();
	}

	@Override
	public void draw(Graphic g) {
		// TODO Auto-generated method stub

	}

	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveLeft = false;
	private boolean moveRight = false;

	private boolean moveForward = false;

	private boolean turnLeft = false;
	private boolean turnRight = false;
	private boolean turnUp = false;
	private boolean turnDown = false;

	private boolean shiftPressed = false;

	public void update(long now) {

		if(moveForward) {
			mainView.moveXZ(offset);
		}

		if(moveUp) {
			mainView.offsetY(-offset);
		}

		if(moveDown) {
			mainView.offsetY(+offset);
		}

		if(moveLeft) {
			mainView.offsetZ(+offset);
		}

		if(moveRight) {
			mainView.offsetZ(-offset);
		}

		if(turnRight) {
			mainView.offsetAngleY(+offsetTurn);
		}

		if(turnLeft) {
			mainView.offsetAngleY(-offsetTurn);	
		}

		if(turnUp) {
			mainView.offsetAngleX(+offsetTurn);
		}

		if(turnDown) {
			mainView.offsetAngleX(-offsetTurn);	
		}

	}

	private int offset = 20;
	private int offsetTurn = 1;

	public GUIEvent updateKeyboard(KeyEvent event) {

		if(event.isAnyKeyDown(KeyEvent.TSK_SHIFT_RIGHT, KeyEvent.TSK_SHIFT_LEFT)) {
			shiftPressed = true;
		} else if(event.isAnyKeyUp(KeyEvent.TSK_SHIFT_RIGHT, KeyEvent.TSK_SHIFT_LEFT)) {
			shiftPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
			//if(shiftPressed) {
			moveUp = true;
			//} else {
			//moveForward = true;
			//}

		} else if(event.isKeyUp(KeyEvent.TSK_UP_ARROW)) {
			moveUp = false;
			moveForward = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
			moveUp = true;
		} else if(event.isKeyUp(KeyEvent.TSK_UP_ARROW)) {
			moveUp = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {
			moveDown = true;
		} else if(event.isKeyUp(KeyEvent.TSK_DOWN_ARROW)) {
			moveDown = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {
			turnLeft = true;
		} else if(event.isKeyUp(KeyEvent.TSK_LEFT_ARROW)) {
			turnLeft = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {
			turnRight = true;
		} else if(event.isKeyUp(KeyEvent.TSK_RIGHT_ARROW)) {
			turnRight = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_D)) {
			moveRight = true;
		} else if(event.isKeyUp(KeyEvent.TSK_D)) {
			moveRight = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_A)) {
			moveLeft = true;
		} else if(event.isKeyUp(KeyEvent.TSK_A)) {
			moveLeft = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_S)) {
			turnDown = true;
		} else if(event.isKeyUp(KeyEvent.TSK_S)) {
			turnDown = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_W)) {
			turnUp = true;
			//moveForward = true;
		} else if(event.isKeyUp(KeyEvent.TSK_W)) {
			turnUp = false;
			//moveForward = false;
		}

		return null;
	}

}
