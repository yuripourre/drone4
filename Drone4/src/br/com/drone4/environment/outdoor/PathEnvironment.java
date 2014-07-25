package br.com.drone4.environment.outdoor;

import static javax.media.opengl.GL.GL_LINEAR;
import static javax.media.opengl.GL.GL_TEXTURE_2D;
import static javax.media.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static javax.media.opengl.GL.GL_TEXTURE_MIN_FILTER;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import br.com.abby.util.CameraGL;
import br.com.drone4.control.Sensitivity;
import br.com.drone4.drone.PhantomDJI;
import br.com.drone4.model.sensor.camera.StandardCamera;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.luvia.grid.GridApplication;

import com.jogamp.opengl.util.awt.Screenshot;

public class PathEnvironment extends GridApplication {
	protected StandardCamera droneCamera;

	//Scene Stuff
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

	public PathEnvironment(int w, int h) {
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
		drone = new PhantomDJI(3, 8, -2);

		droneCamera = drone.getCamera();				

		drone.updateSensors();

		cameraGL = new CameraGL(0, 20, -10);

		cameraGL.setTarget(drone);

		updateAtFixedRate(300);

	}

	private void drawFloor(GL2 gl) {

		gl.glColor3d(0, 0, 0);

		gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

		drawPath(gl, 200, 120);

	}

	protected void drawPath(GL2 gl, double x, double y) {

		double tileSize = 3;

		double startX = 0;
		for (int i = 0; i < 5; i++) {
			drawTile(gl, startX, i, tileSize);
		}

		for (int i = 0; i < 10; i++) {
			drawTile(gl, i, 5, tileSize);
		}

		for (int i = 0; i < 10; i++) {
			drawTile(gl, 10, 5+i, tileSize);
		}

		for (int i = 0; i < 10; i++) {
			drawTile(gl, 10-i, 15, tileSize);
		}
		
		for (int i = 0; i < 10; i++) {
			drawTile(gl, 0, 15+i, tileSize);
		}

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

		if(event.isKeyUp(KeyEvent.TSK_SPACE)) {

			ajust = !ajust;

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

		camera.setAngleX(-90);

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

	private float calculateCentroidX(BufferedImage buffer) {

		int count = 0;
		int countX = 0;		

		for(int i = 0; i < buffer.getWidth(); i++) {
			Color color = new Color(buffer.getRGB(i, 0));

			if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {

				count++;
				countX += i;

			}

		}

		return (float)countX/(float)count;
	}

	private float calculateCentroidY(int column, BufferedImage buffer) {
		int count = 0;
		int countY = 0;

		for(int j = 0; j < buffer.getHeight(); j++) {
			Color color = new Color(buffer.getRGB(column, j));

			if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {

				count++;
				countY += j;

			}

		}

		return (float)countY/(float)count;

	}

	private boolean checkPixelFirstColumn(BufferedImage buffer) {

		for(int j = 0; j < buffer.getHeight(); j++) {
			Color color = new Color(buffer.getRGB(0, j));

			if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {

				return true;

			}

		}

		return false;

	}

	private boolean checkPixelLastColumn(BufferedImage buffer) {

		int i = buffer.getWidth()-1;

		for(int j = 0; j < buffer.getHeight(); j++) {
			Color color = new Color(buffer.getRGB(i, j));

			if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {

				return true;

			}

		}

		return false;

	}
	private boolean checkPixelFirstLine(BufferedImage buffer) {

		for(int j = 0; j < buffer.getHeight(); j++) {

			for(int i = 0; i < buffer.getWidth(); i++) {

				Color color = new Color(buffer.getRGB(i, j));

				if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {
					return false;
				}

			}

		}

		return true;

	}

	private BufferedImage buffer;

	private boolean ajust = true;

	private boolean leftTendency = false;

	private boolean rightTendency = false;

	@Override
	public void timeUpdate(long now) {

		buffer = drone.getCamera().getBufferedImage();
		manualFlight();

		if (ajust) {

			int margin = 6;

			if(checkPixelFirstColumn(buffer)) {

				if(!rightTendency) {
					leftTendency = true;

					drone.getModel().setColor(Color.RED);
				} else {
					leftTendency = false;	
				}

			} else {

				leftTendency = false;
			}

			if (checkPixelLastColumn(buffer)) {

				if(!leftTendency) {
					rightTendency = true;

					drone.getModel().setColor(Color.BLUE);

				} else {
					rightTendency = false;
				}

			} else {

				rightTendency = false;
			}


			if(leftTendency) {

				float centroidY = calculateCentroidY(0, buffer);
				
				if(centroidY > buffer.getHeight()/2 - margin && centroidY < buffer.getHeight()/2 + margin) {
					drone.goLeft(Sensitivity.FULL_POSITIVE);
				} else {

					drone.goForward(Sensitivity.FULL_POSITIVE);

				}
			}

			if(rightTendency) {
				
				float centroidY = calculateCentroidY(buffer.getWidth()-1, buffer);
			
				if(centroidY > buffer.getHeight()/2 - margin && centroidY < buffer.getHeight()/2 + margin) {
					drone.goRight(Sensitivity.FULL_POSITIVE);
				} else {
					drone.goForward(Sensitivity.FULL_POSITIVE);

				}

			}

			if(!rightTendency && !leftTendency) {
				
				if(checkPixelFirstLine(buffer)) {
					
					drone.getModel().setColor(Color.GREEN);
					
					return;
				}

				drone.getModel().setColor(Color.YELLOW);

				float centroidX = calculateCentroidX(buffer);

				if(centroidX < buffer.getWidth()/2 - margin) {

					drone.goLeft(0.5f);

				} else if(centroidX > buffer.getWidth()/2 + margin) {

					drone.goRight(0.5f);

				} else {

					drone.goForward(Sensitivity.FULL_POSITIVE);
				}

			}

		}

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

		g.setColor(Color.BLACK);
		g.drawRect(0, 60, droneCamera.getBufferedImage().getWidth(), droneCamera.getBufferedImage().getHeight());

		if(ajust)
			g.drawImage(buffer, 0, 60);

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