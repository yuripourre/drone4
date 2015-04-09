package br.com.drone4.drone;

import java.awt.Color;

import br.com.abby.loader.MeshLoader;
import br.com.drone4.model.AerialDrone;
import br.com.drone4.model.accessory.Gimbal;
import br.com.drone4.model.accessory.StandardGimbal;
import br.com.drone4.sensor.battery.BatterySensor;
import br.com.drone4.sensor.battery.dji.DJISmartBattery;
import br.com.drone4.sensor.camera.AngularLensCamera;
import br.com.drone4.sensor.camera.StandardCamera;
import br.com.drone4.sensor.gps.GPSSensor;
import br.com.drone4.sensor.gps.PreciseGPSSensor;
import br.com.luvia.linear.Mesh;

public class PhantomDJI extends AerialDrone {

	//Sensors
	private PreciseGPSSensor gps;
	
	private StandardCamera camera;
	
	private BatterySensor batterySensor;
	
	//Accessories
	private Gimbal gimbal;
	
	private Mesh model;
	
	private double modelAngle = 135;
			
	public PhantomDJI(double x, double y, double z) {
		super(x, y, z);
		
		speed = .5;
		
		startAngle = 180;
		
		yawSpeed = 10;
		
		initSensors(x, y, z);
		
		model = new Mesh(MeshLoader.getInstance().loadModel("aerial/quad.obj"));
		model.setDrawTexture(false);
		
		model.setColor(Color.DARK_GRAY);
		model.setCoordinates(x, y, z);
		model.setAngleY(modelAngle);
	}

	private void initSensors(double x, double y, double z) {
		camera = new AngularLensCamera(x, y, z);
		gps = new PreciseGPSSensor();
		batterySensor = new DJISmartBattery();
		gimbal = new StandardGimbal(camera);
	}
	
	@Override
	public void updateSensors() {
		
		model.setCoordinates(x, y, z);		
		model.setAngleY(-angleY+modelAngle);//angle in degrees

		camera.update(this);
		
		gps.update(this);
		
		batterySensor.update(this);
		
		gimbal.update(this);
	}

	public StandardCamera getCamera() {
		return camera;
	}
	
	public Mesh getModel() {
		return model;
	}
		
	public GPSSensor getGps() {
		return gps;
	}
	
	public BatterySensor getBattery() {
		return batterySensor;
	}

	public Gimbal getGimbal() {
		return gimbal;
	}
	
}
