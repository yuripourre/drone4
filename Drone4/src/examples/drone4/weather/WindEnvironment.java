package examples.drone4.weather;

import static javax.media.opengl.GL.GL_LINEAR;
import static javax.media.opengl.GL.GL_TEXTURE_2D;
import static javax.media.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static javax.media.opengl.GL.GL_TEXTURE_MIN_FILTER;

import java.awt.Color;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import br.com.abby.util.CameraGL;
import br.com.drone4.control.Sensitivity;
import br.com.drone4.drone.PhantomDJI;
import br.com.drone4.model.control.KeyboardInput;
import br.com.drone4.sensor.camera.StandardCamera;
import br.com.drone4.ui.indicator.BatteryIndicator;
import br.com.drone4.weather.Wind;
import br.com.etyllica.context.UpdateIntervalListener;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.linear.vector.Vec3D;
import br.com.luvia.core.video.Graphics3D;
import br.com.luvia.grid.GridApplication;
import br.com.luvia.loader.TextureLoader;

import com.jogamp.opengl.util.awt.Screenshot;
import com.jogamp.opengl.util.texture.Texture;

public class WindEnvironment extends GridApplication implements UpdateIntervalListener {

	protected StandardCamera droneCamera1;

	// Scene Stuff
	private Texture road;

	protected PhantomDJI drone1;
	
	protected CameraGL cameraGL1;

	protected float mx = 0;

	protected float my = 0;

	protected boolean click = false;

	private KeyboardInput controller1 = new KeyboardInput(1);

	// UI
	private BatteryIndicator batteryIndicator1;

	//Weather
	private Wind wind;
	
	public WindEnvironment(int w, int h) {
		super(w, h);
	}

	@Override
	public void init(Graphics3D drawable) {

		GL2 gl = drawable.getGL().getGL2();

		// Global settings
		gl.glEnable(GL.GL_DEPTH_TEST);

		gl.glDepthFunc(GL.GL_LEQUAL);

		gl.glShadeModel(GL2.GL_SMOOTH);

		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

	}

	@Override
	public void load() {
		
		Vec3D windDirection = new Vec3D(50, 0, 10);
		windDirection.normalize();
		
		wind = new Wind(windDirection, 0.02);
		
		// Size in meters
		drone1 = new PhantomDJI(1, 8, 0);
		cameraGL1 = new CameraGL(0, 20, -10);
		cameraGL1.setTarget(drone1);
		droneCamera1 = drone1.getCamera();
				
		// Load Road Texture
		road = TextureLoader.getInstance().loadTexture("road.jpg");

		batteryIndicator1 = new BatteryIndicator(w - w / 20, 70, drone1.getBattery());		

		// updateAtFixedRate(300, this);
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

		for (int i = 0; i < 60; i++) {

			drawTile(gl, startX, i, tileSize);

		}

		road.disable(gl);
	}

	@Override
	public void reshape(Graphics3D drawable, int x, int y, int width, int height) {

		GL2 gl = drawable.getGL2();
		GLU glu = drawable.getGLU();

		gl.glViewport(x, y, width, height);

		gl.glMatrixMode(GL2.GL_PROJECTION);

		gl.glLoadIdentity();

		float aspect = (float) width / (float) height;

		glu.gluPerspective(60 * zoom, aspect, 1, 100);

	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {

		controller1.updateKeyboard(event);

		if (event.isKeyDown(KeyEvent.TSK_I)) {
			droneCamera1.offsetX(+1);
		}

		if (event.isKeyDown(KeyEvent.TSK_K)) {
			droneCamera1.offsetX(-1);
		}

		if (event.isKeyDown(KeyEvent.TSK_L)) {
			droneCamera1.offsetZ(+1);
		}

		if (event.isKeyDown(KeyEvent.TSK_J)) {
			droneCamera1.offsetZ(-1);
		}

		return GUIEvent.NONE;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {

		mx = event.getX();
		my = event.getY();

		return GUIEvent.NONE;
	}

	@Override
	public void display(Graphics3D drawable) {

		// Force update by FPS
		timeUpdate(0);

		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(1f, 1f, 1f, 1);

		captureCamera(drawable, droneCamera1);

		gl.glViewport(x, y, w, h);

		// Update Camera View
		drawable.updateCamera(cameraGL1);
		// drawable.aimCamera(followCamera);

		drawScene(gl);

	}

	protected void captureCamera(Graphics3D drawable, StandardCamera camera) {

		GL2 gl = drawable.getGL2();

		int w = camera.getWidth();

		int h = camera.getHeight();

		gl.glViewport(0, 0, w, h);

		// Update Camera View
		drawable.aimCamera(camera);

		drawScene(gl);

		// Draw Drone Camera
		camera.setBufferedImage(Screenshot.readToBufferedImage(0, 0, w, h, false));

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(1f, 1f, 1f, 1);

		gl.glLoadIdentity();

	}

	protected void drawScene(GL2 gl) {

		// Draw Scene
		drawFloor(gl);

		drone1.getModel().draw(gl);
		
		gl.glFlush();

	}

	@Override
	public void timeUpdate(long now) {

		manualFlight(controller1, drone1);

		cameraGL1.setX(drone1.getX());
		cameraGL1.setZ(drone1.getZ() - 10);
		
		//wind.moveDrone(drone1);
	}

	private void manualFlight(KeyboardInput controller, PhantomDJI drone) {

		double level = drone.getBattery().getLevel();

		double offsetMove = 0.1;
		double offsetTurn = 0.1;

		if (controller.isUpPressed()) {
			drone.goUp(Sensitivity.FULL_POSITIVE);
			drone.getBattery().setLevel(level - offsetMove);
		}

		if (controller.isDownPressed()) {
			drone.goDown(Sensitivity.FULL_NEGATIVE);
			drone.getBattery().setLevel(level - offsetMove);
		}

		if (controller.isRightPressed()) {
			drone.goRight(Sensitivity.FULL_POSITIVE);
			drone.getBattery().setLevel(level - offsetMove);
		}

		if (controller.isLeftPressed()) {
			drone.goLeft(Sensitivity.FULL_NEGATIVE);
			drone.getBattery().setLevel(level - offsetMove);
		}

		if (controller.isForwardPressed()) {
			drone.goForward(Sensitivity.FULL_POSITIVE);
			drone.getBattery().setLevel(level - offsetMove);
		}

		if (controller.isBackwardPressed()) {
			drone.goBackward(Sensitivity.FULL_NEGATIVE);
			drone.getBattery().setLevel(level - offsetMove);
		}

		if (controller.isTurnRightPressed()) {
			drone.turnRight(Sensitivity.FULL_POSITIVE);
			drone.getBattery().setLevel(level - offsetMove);
		}

		if (controller.isTurnLeftPressed()) {
			drone.turnLeft(Sensitivity.FULL_NEGATIVE);
			drone.getBattery().setLevel(level - offsetMove);
		}

	}

	@Override
	public void draw(Graphic g) {

		// Draw PipCamera
		g.drawImage(droneCamera1.getBufferedImage(), 0, 60);

		// Draw Information
		g.setColor(Color.WHITE);
		g.drawShadow(20, 60, "Scene", Color.BLACK);

		g.drawShadow(20, 120, "DroneX: " + (drone1.getX()), Color.BLACK);
		g.drawShadow(20, 140, "DroneY: " + (drone1.getY()), Color.BLACK);
		g.drawShadow(20, 160, "DroneZ: " + (drone1.getZ()), Color.BLACK);

		g.drawShadow(20, 200, "DroneAngleY: " + (drone1.getAngleY()), Color.BLACK);

		g.drawShadow(20, 220, "CameraAngleX: " + (droneCamera1.getAngleX()), Color.BLACK);
		g.drawShadow(20, 240, "CameraAngleY: " + (droneCamera1.getAngleY()), Color.BLACK);
		g.drawShadow(20, 260, "CameraAngleZ: " + (droneCamera1.getAngleZ()), Color.BLACK);

		batteryIndicator1.draw(g);
	}

}
