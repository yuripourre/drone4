package br.com.drone4.model.compass;

import br.com.drone4.model.Drone;

public class PreciseCompassSensor implements CompassSensor {
	private double y = 0;
	
	@Override
	public void updateSensor(Drone drone) {
		this.y = drone.getY();
		
	}

	public double getY() {
		return y;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}
