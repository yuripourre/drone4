package br.com.drone4.model.sensor.gps;

import br.com.drone4.model.Drone;

public class PreciseGPSSensor implements GPSSensor {

	private double x = 0;
	
	private double y = 0;
	
	private double z = 0;
	
	@Override
	public void update(Drone drone) {
		
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

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}	
	
}
