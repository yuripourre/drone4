package br.com.drone4.model.sensor;

import br.com.drone4.model.Drone;

public class GPSSensor implements Sensor {

	private double x = 0;
	
	private double y = 0;
	
	private double z = 0;
	
	@Override
	public void updateSensor(Drone drone) {
		
		this.x = drone.getX();
		
		this.y = drone.getY();
		
		this.z = drone.getZ();
		
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}	
	
}
