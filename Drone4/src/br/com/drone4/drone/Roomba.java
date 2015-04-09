package br.com.drone4.drone;

import java.awt.Color;

import br.com.abby.loader.MeshLoader;
import br.com.drone4.model.TerrestrialDrone;
import br.com.drone4.sensor.camera.StandardCamera;
import br.com.drone4.sensor.compass.CompassSensor;
import br.com.drone4.sensor.compass.PreciseCompassSensor;
import br.com.luvia.linear.Mesh;

public class Roomba extends TerrestrialDrone {
	
	private StandardCamera camera;
	
	private Mesh model;
	
	private float startAngle = 180;
	
	private CompassSensor compass;
		
	public Roomba(double x, double y, double z) {
		super(x, y, z);
		
		this.speed = .5;
		
		this.yawSpeed = 10;
				
		this.angleY = startAngle;
		
		model = new Mesh(MeshLoader.getInstance().loadModel("terrestrial/roomba.obj"));
		model.setDrawTexture(false);
		
		model.setColor(Color.DARK_GRAY);
		model.setCoordinates(x, y, z);
		
		compass = new PreciseCompassSensor();
		camera = new StandardCamera(x, y+0.5, z);
		
	}

	@Override
	public void goRight(double sensitivity) {
		
	}
	
	@Override
	public void goLeft(double sensitivity) {
		
	}
	
	public Mesh getModel() {
		return model;
	}
			
	public StandardCamera getCamera() {
		return camera;
	}
	
	public CompassSensor getCompass() {
		return compass;
	}

	@Override
	public void updateSensors() {
		
		camera.update(this);
		
		compass.update(this);
		
		model.setCoordinates(x, y, z);
		
		model.setAngleY(angleY);//angle in degrees
		
	}
		
}
