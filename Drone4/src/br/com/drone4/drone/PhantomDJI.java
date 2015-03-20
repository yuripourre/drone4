package br.com.drone4.drone;

import java.awt.Color;

import br.com.abby.loader.MeshLoader;
import br.com.drone4.model.AerialDrone;
import br.com.drone4.model.sensor.camera.StandardCamera;
import br.com.drone4.model.sensor.gps.GPSSensor;
import br.com.drone4.model.sensor.gps.PreciseGPSSensor;
import br.com.luvia.linear.Mesh;

public class PhantomDJI extends AerialDrone {

	private PreciseGPSSensor gps;
	
	private StandardCamera camera;
	
	private Mesh model;
			
	public PhantomDJI(double x, double y, double z) {
		super(x, y, z);
		
		speed = .5;
		
		yawSpeed = 10;
		
		startAngle = 180;
		
		camera = new StandardCamera(x, y, z);
		
		gps = new PreciseGPSSensor();
		
		model = new Mesh(MeshLoader.getInstance().loadModel("aerial/quad.obj"));
		model.setDrawTexture(false);
		
		model.setColor(Color.DARK_GRAY);
		model.setCoordinates(x, y, z);
		
		this.angleY = startAngle;
		
	}

	public StandardCamera getCamera() {
		return camera;
	}
	
	public Mesh getModel() {
		return model;
	}
		
	@Override
	public void updateSensors() {
		
		model.setCoordinates(x, y, z);
		
		model.setAngleY(angleY);//angle in degrees

		camera.updateSensor(this);
		
		gps.updateSensor(this);
		
	}
	
	public GPSSensor getGps() {
		return gps;
	}
		
}
