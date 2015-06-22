package examples.drone4.outdoor;

import static javax.media.opengl.GL.GL_LINEAR;
import static javax.media.opengl.GL.GL_TEXTURE_2D;
import static javax.media.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static javax.media.opengl.GL.GL_TEXTURE_MIN_FILTER;

import java.awt.Color;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import br.com.abby.util.CameraGL;
import br.com.drone4.drone.PhantomDJI;
import br.com.drone4.loader.ASCIIDEMLoader;
import br.com.drone4.sensor.camera.StandardCamera;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.linear.Point3D;
import br.com.etyllica.util.PathHelper;
import br.com.luvia.core.video.Graphics3D;
import br.com.luvia.grid.GridApplication;
import br.com.luvia.loader.TextureLoader;

import com.jogamp.opengl.util.texture.Texture;

public class DEMView extends GridApplication {

	protected StandardCamera droneCamera;

	// Scene Stuff
	private Texture road;

	protected CameraGL cameraGL;

	protected PhantomDJI drone;

	protected float mx = 0;

	protected float my = 0;

	protected boolean click = false;

	private List<Point3D> terrain;

	public DEMView(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		String path = PathHelper.desktopDirectory();
		
		terrain = ASCIIDEMLoader.loadDEM(path+"/MDE_26124se_v1.XYZ");

		loadingInfo = "Terrain Loaded";

		System.out.println(loadingInfo);
	}

	@Override
	public void init(Graphics3D drawable) {

		GL2 gl = drawable.getGL().getGL2();

		// Size in meters
		drone = new PhantomDJI(1, 8, 0);

		droneCamera = drone.getCamera();

		cameraGL = new CameraGL(0, 20, -10);

		cameraGL.setTarget(drone);

		// Load Road Texture
		road = TextureLoader.getInstance().loadTexture("road.jpg");

		// Global settings
		gl.glEnable(GL.GL_DEPTH_TEST);

		gl.glDepthFunc(GL.GL_LEQUAL);

		gl.glShadeModel(GL2.GL_SMOOTH);

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

		glu.gluPerspective(60 * zoom, aspect, 1, 100);

	}

	@Override
	public void display(Graphics3D drawable) {

		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(1f, 1f, 1f, 1);

		gl.glViewport(x, y, w, h);

		// Update Camera View
		drawable.updateCamera(cameraGL);
		// drawable.aimCamera(followCamera);

		drawScene(gl);

		
		drawable.setColor(Color.BLACK);
		gl.glPolygonMode( GL2.GL_FRONT_AND_BACK, GL2.GL_LINE );
		
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);

		Point3D reference = terrain.get(0);
		
		for(Point3D point:terrain) {
			//DEM is Z up
			gl.glVertex3d(point.getX()-reference.getX(), point.getZ()-reference.getZ(), point.getY()-reference.getY());
		}
		gl.glEnd();

		gl.glPolygonMode( GL2.GL_FRONT_AND_BACK, GL2.GL_POLYGON );

	}

	protected void drawScene(GL2 gl) {

		// Draw Scene
		drawFloor(gl);

		drone.getModel().draw(gl);

		gl.glFlush();

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
	public void draw(Graphic g) {
		// TODO Auto-generated method stub

	}

}
