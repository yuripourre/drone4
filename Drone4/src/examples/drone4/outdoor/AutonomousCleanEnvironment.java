package examples.drone4.outdoor;

import static javax.media.opengl.GL.GL_LINEAR;
import static javax.media.opengl.GL.GL_TEXTURE_2D;
import static javax.media.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static javax.media.opengl.GL.GL_TEXTURE_MIN_FILTER;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import br.com.abby.loader.MeshLoader;
import br.com.abby.util.CameraGL;
import br.com.drone4.automated.action.GoToAction;
import br.com.drone4.automated.action.MoveAction;
import br.com.drone4.automated.action.TurnAction;
import br.com.drone4.automated.dji.DJIAutonomousFlight;
import br.com.drone4.control.Sensitivity;
import br.com.drone4.drone.PhantomDJI;
import br.com.drone4.model.accessory.Gimbal;
import br.com.drone4.model.control.KeyboardInput;
import br.com.drone4.sensor.camera.StandardCamera;
import br.com.drone4.ui.indicator.BatteryIndicator;
import br.com.etyllica.context.UpdateIntervalListener;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.graphics.SVGColor;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.luvia.core.video.Graphics3D;
import br.com.luvia.grid.GridApplication;
import br.com.luvia.linear.Mesh;
import br.com.luvia.loader.TextureLoader;

import com.jogamp.opengl.util.awt.Screenshot;
import com.jogamp.opengl.util.texture.Texture;

import dji.sdk.api.GroundStation.DJIGroundStationTask;
import dji.sdk.api.GroundStation.DJIGroundStationWaypoint;

public class AutonomousCleanEnvironment extends GridApplication implements UpdateIntervalListener {

	protected StandardCamera droneCamera;

	// Scene Stuff
	private Texture road;

	protected CameraGL cameraGL;

	protected PhantomDJI drone;

	protected float mx = 0;

	protected float my = 0;

	protected boolean click = false;

	private KeyboardInput controller = new KeyboardInput();

	private DJIGroundStationTask task;

	private DJIAutonomousFlight flight;

	// UI
	private BatteryIndicator batteryIndicator;

	private Mesh ring;

	public AutonomousCleanEnvironment(int w, int h) {
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

		// Size in meters
		drone = new PhantomDJI(1, 8, 0);

		droneCamera = drone.getCamera();

		cameraGL = new CameraGL(0, 20, -10);

		cameraGL.setTarget(drone);

		// Load Ring Model
		ring = new Mesh(MeshLoader.getInstance().loadModel("ring/ring.obj"));
		ring.setColor(Color.YELLOW);

		// Load Road Texture
		road = TextureLoader.getInstance().loadTexture("road.jpg");

		batteryIndicator = new BatteryIndicator(w - w / 20, 70, drone.getBattery());

		task = new DJIGroundStationTask();

		//Latitude, Longitude
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 5, drone.getX() + 2));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 8, drone.getX() + 2));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 10, drone.getX() - 2));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 15, drone.getX() - 4));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 22, drone.getX() + 2));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 30, drone.getX() + 3));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 35, drone.getX() + 4));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 42, drone.getX() + 5));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 48, drone.getX() + 8));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 54, drone.getX() + 8));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 60, drone.getX() + 6));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 68, drone.getX() + 2));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 70, drone.getX() - 4));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 74, drone.getX() + 0));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 80, drone.getX() + 5));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 83, drone.getX() + 0));
		task.addWaypoint(new DJIGroundStationWaypoint(drone.getZ() + 90, drone.getX() + 0));

		flight = new DJIAutonomousFlight(drone, task);

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

		controller.updateKeyboard(event);

		if (event.isKeyDown(KeyEvent.TSK_I)) {
			droneCamera.setOffsetX(+1);
		}

		if (event.isKeyDown(KeyEvent.TSK_K)) {
			droneCamera.setOffsetX(-1);
		}

		if (event.isKeyDown(KeyEvent.TSK_L)) {
			droneCamera.setOffsetZ(+1);
		}

		if (event.isKeyDown(KeyEvent.TSK_J)) {
			droneCamera.setOffsetZ(-1);
		}

		return GUIEvent.NONE;
	}

	public GUIEvent updateMouse(PointerEvent event) {

		mx = event.getX();
		my = event.getY();

		if (event.isButtonDown(MouseButton.MOUSE_BUTTON_LEFT)) {
			cameraGL.setZ(cameraGL.getZ() + 0.1f);
			click = true;
		}

		if (event.isButtonUp(MouseButton.MOUSE_BUTTON_LEFT)) {
			cameraGL.setZ(cameraGL.getZ() - 0.1f);
			click = false;
		}

		return GUIEvent.NONE;
	}

	@Override
	public void display(Graphics3D drawable) {

		// Force update by FPS
		timeUpdate(0);

		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(1f, 1f, 1f, 1);

		captureCamera(drawable, drone.getGimbal(), droneCamera);

		gl.glViewport(x, y, w, h);

		// Update Camera View
		drawable.updateCamera(cameraGL);
		// drawable.aimCamera(followCamera);

		drawScene(drawable);

	}

	protected void captureCamera(Graphics3D drawable, Gimbal gimbal, StandardCamera camera) {

		GL2 gl = drawable.getGL2();

		int w = camera.getWidth();

		int h = camera.getHeight();

		gl.glViewport(0, 0, w, h);

		// Update Camera View
		drawable.aimCamera(camera, gimbal.getAngleX(), gimbal.getAngleY(), gimbal.getAngleZ());

		drawScene(drawable);

		// Draw Drone Camera
		camera.setBufferedImage(Screenshot.readToBufferedImage(0, 0, w, h, false));

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(1f, 1f, 1f, 1);

		gl.glLoadIdentity();

	}

	protected void drawScene(Graphics3D g) {

		GL2 gl = g.getGL2();

		gl.glEnable(GL.GL_DEPTH_TEST);

		// Draw Scene
		drawFloor(gl);

		drone.getModel().simpleDraw(gl);

		displayGroundStatonTask(g);

		gl.glDisable(GL.GL_DEPTH_TEST);

		gl.glFlush();

	}

	@Override
	public void timeUpdate(long now) {

		flight.flight();

		manualFlight();

		cameraGL.setX(drone.getX());
		cameraGL.setZ(drone.getZ() - 10);
	}

	private void manualFlight() {

		double level = drone.getBattery().getLevel();
		double inc = -0.01;
		double moveOffset = 0.05;
		double moveGimbal = 0.02;

		if (controller.isUpPressed()) {
			drone.goUp(Sensitivity.FULL_POSITIVE);
			inc -= moveOffset;
		}

		if (controller.isDownPressed()) {
			drone.goDown(Sensitivity.FULL_NEGATIVE);
			inc -= moveOffset;

			// Ground Collision
			if (drone.getY() < 0) {
				drone.setY(0);
			}
		}

		if (controller.isRightPressed()) {
			drone.goRight(Sensitivity.FULL_NEGATIVE);
			inc -= moveOffset;
		}

		if (controller.isLeftPressed()) {
			drone.goLeft(Sensitivity.FULL_POSITIVE);
			inc -= moveOffset;
		}

		if (controller.isForwardPressed()) {
			drone.goForward(Sensitivity.FULL_POSITIVE);
			inc -= moveOffset;
		}

		if (controller.isBackwardPressed()) {
			drone.goBackward(Sensitivity.FULL_NEGATIVE);
			inc -= moveOffset;
		}

		if (controller.isTurnRightPressed()) {
			drone.turnRight(Sensitivity.FULL_POSITIVE);
			inc -= moveOffset;
		}

		if (controller.isTurnLeftPressed()) {
			drone.turnLeft(Sensitivity.FULL_NEGATIVE);
			inc -= moveOffset;
		}

		if (controller.isUpperLeftUpPressed()) {
			drone.getGimbal().turnX(1);
			inc -= moveGimbal;
		}
		if (controller.isUpperLeftDownPressed()) {
			drone.getGimbal().turnX(-1);
			inc -= moveGimbal;
		}

		if (controller.isUpperRightUpPressed()) {
			drone.getGimbal().turnY(1);
			inc -= moveGimbal;
		}
		if (controller.isUpperRightDownPressed()) {
			drone.getGimbal().turnY(-1);
			inc -= moveGimbal;
		}

		drone.getBattery().setLevel(level + inc);

	}

	@Override
	public void draw(Graphic g) {

		// Draw PipCamera
		g.drawImage(droneCamera.getBufferedImage(), 0, 60);

		// Draw Information
		g.setColor(Color.WHITE);
		g.drawShadow(20, 60, "Scene", Color.BLACK);

		g.drawShadow(20, 120, "DroneX: " + (drone.getX()), Color.BLACK);
		g.drawShadow(20, 140, "DroneY: " + (drone.getY()), Color.BLACK);
		g.drawShadow(20, 160, "DroneZ: " + (drone.getZ()), Color.BLACK);

		g.drawShadow(20, 200, "DroneAngleY: " + (drone.getAngleY()), Color.BLACK);

		g.drawShadow(20, 220, "CameraAngleX: " + (droneCamera.getAngleX()), Color.BLACK);
		g.drawShadow(20, 240, "CameraAngleY: " + (droneCamera.getAngleY()), Color.BLACK);
		g.drawShadow(20, 260, "CameraAngleZ: " + (droneCamera.getAngleZ()), Color.BLACK);

		batteryIndicator.draw(g);

	}

	private void displayGroundStatonTask(Graphics3D g) {

		Color rawColor = SVGColor.GOLD;
		Color visitedColor = SVGColor.GRAY;

		int count = 0;

		ring.setColor(visitedColor);

		for (DJIGroundStationWaypoint waypoint : task.getAllWaypoint()) {

			if(count>flight.getCurrentPoint()-1) {
				ring.setColor(rawColor);
			}

			ring.setCoordinates(waypoint.lontitude, drone.getY(), waypoint.latitude);
			ring.simpleDraw(g.getGL2());

			count++;      
		}

	}

}
