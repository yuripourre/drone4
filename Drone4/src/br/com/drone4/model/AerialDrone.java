package br.com.drone4.model;


public class AerialDrone extends Drone {
	
	public AerialDrone(double x, double y, double z) {
		super(x, y, z);
	}

	@Override
	public void throttle(double sensitivity) {
		setOffsetY(throttleSpeed*sensitivity);		
		updateSensors();
	}
			
	@Override
	public void goRight(double sensitivity) {
		
		double distance = speed;
		double angle = angleY+90;
		moveByAngle(angle, distance);
		updateSensors();
	}
	
	@Override
	public void goLeft(double sensitivity) {
		double distance = speed;
		double angle = angleY-90;
		moveByAngle(angle, distance);
		updateSensors();
	}
			
}

