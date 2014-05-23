package br.com.drone4.drone;

import java.awt.Color;

import br.com.drone4.model.AerialDrone;
import br.com.drone4.model.sensor.gps.GPSSensor;
import br.com.drone4.model.sensor.gps.PreciseGPSSensor;
import br.com.luvia.linear.Mesh;
import br.com.luvia.loader.mesh.MeshLoader;
import br.com.luvia.util.CameraGL;

public class PhantomDJI extends AerialDrone {

	private PreciseGPSSensor gps;
	
	private CameraGL camera;
	
	private Mesh model;
		
	public PhantomDJI(double x, double y, double z) {
		super(x, y, z);
		
		this.speed = .5;
		
		this.turnSpeed = 10;
		
		camera = new CameraGL(x, y, z);
		
		gps = new PreciseGPSSensor();
		
		model = MeshLoader.getInstance().loadModel("aerial/quad.obj");
		model.setDrawTexture(false);
		
		model.setColor(Color.DARK_GRAY);
		model.setCoordinates(x, y, z);
		
	}

	public CameraGL getCamera() {
		return camera;
	}
	
	public Mesh getModel() {
		return model;
	}
		
	@Override
	public void updateSensors() {
		
		model.setCoordinates(x, y, z);
		
		model.setAngleY(angleY);//angle in degrees
		
		camera.setCoordinates(x, y, z);
		
		gps.updateSensor(this);
		
	}

	public GPSSensor getGps() {
		return gps;
	}
		
}
