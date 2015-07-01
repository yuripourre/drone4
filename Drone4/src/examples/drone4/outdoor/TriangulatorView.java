package examples.drone4.outdoor;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import jdt.triangulation.DelaunayTriangulation;
import jdt.triangulation.Triangle;
import br.com.abby.linear.AimPoint;
import br.com.abby.util.CameraGL;
import br.com.abby.vbo.VBO;
import br.com.abby.writer.OBJWriter;
import br.com.drone4.loader.ASCIIDEMLoader;
import br.com.drone4.util.TrianglesToVBOConverter;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.linear.Point3D;
import br.com.etyllica.util.PathHelper;
import br.com.luvia.core.video.Graphics3D;
import br.com.luvia.grid.GridApplication;

public class TriangulatorView extends GridApplication {

	protected CameraGL cameraGL;
	protected AimPoint mainView;

	protected float mx = 0;

	protected float my = 0;

	protected boolean click = false;

	private List<Point3D> terrain;
	
	private List<Triangle> triangles;

	public TriangulatorView(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		String path = PathHelper.desktopDirectory();
		
		loadingInfo = "Loading terrain...";
		System.out.println(loadingInfo);
		
		terrain = ASCIIDEMLoader.loadDEM(path+"/MDE_26124se_v1.XYZ");
		
		loadingInfo = "Terrain Loaded";
		System.out.println(loadingInfo);
		
		DelaunayTriangulation triangulator = new DelaunayTriangulation();
		
		loadingInfo = "Triangulating...";
		System.out.println(loadingInfo);
		long now = System.currentTimeMillis();
		triangles = triangulator.triangulate(terrain);
		long after = System.currentTimeMillis();
		loadingInfo = "Terrain Triangulated in: "+(after-now)+"ms";
		System.out.println(loadingInfo);
		
		System.out.println("Writing: "+path+"terrain.obj");
		
		//Export vbo to obj
		VBO vbo = TrianglesToVBOConverter.convert(triangles, triangles.get(0).getA());
		try {
			new OBJWriter().writeVBO(vbo, path+"terrain.obj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Wrote: "+path+"terrain.obj");
	}

	@Override
	public void init(Graphics3D drawable) {

		GL2 gl = drawable.getGL().getGL2();
		
		mainView = new AimPoint(0,-3220,40);
		mainView.setAngleX(120);
		mainView.setAngleY(90);

		//cameraGL.setTarget(drone);

		// Load Road Texture
		//road = TextureLoader.getInstance().loadTexture("road.jpg");

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
		
		drawable.setColor(Color.BLACK);
		//gl.glPolygonMode( GL2.GL_FRONT_AND_BACK, GL2.GL_POLYGON );
		gl.glPolygonMode( GL2.GL_FRONT_AND_BACK, GL2.GL_LINE );
		
		Point3D reference = terrain.get(0);
				
		gl.glBegin(GL2.GL_TRIANGLES);
				
		for(Triangle tri: triangles) {
			drawPoint(gl, reference, tri.getA());
			drawPoint(gl, reference, tri.getB());
			drawPoint(gl, reference, tri.getC());
		}
		
		gl.glEnd();
		
	}

	private void drawPoint(GL2 gl, Point3D reference, Point3D point) {
		//DEM is Z up
		gl.glVertex3d(point.getX()-reference.getX(), point.getZ()-reference.getZ(), point.getY()-reference.getY());
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
			mainView.setOffsetY(-offset);
		}
		
		if(moveDown) {
			mainView.setOffsetY(+offset);
		}
		
		if(moveLeft) {
			mainView.setOffsetZ(+offset);
		}
		
		if(moveRight) {
			mainView.setOffsetZ(-offset);
		}
		
		if(turnRight) {
			mainView.setOffsetAngleY(+offsetTurn);
		}
		
		if(turnLeft) {
			mainView.setOffsetAngleY(-offsetTurn);	
		}
		
		if(turnUp) {
			mainView.setOffsetAngleX(+offsetTurn);
		}
		
		if(turnDown) {
			mainView.setOffsetAngleX(-offsetTurn);	
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
