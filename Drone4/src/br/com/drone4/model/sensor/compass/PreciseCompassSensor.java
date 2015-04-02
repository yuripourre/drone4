package br.com.drone4.model.sensor.compass;

import br.com.drone4.model.Drone;

public class PreciseCompassSensor implements CompassSensor {
	
	private double angle = 0;
	
	@Override
	public void update(Drone drone) {
		this.angle = drone.getAngleY();
		
	}

	public double getAngle() {
		return angle;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}
