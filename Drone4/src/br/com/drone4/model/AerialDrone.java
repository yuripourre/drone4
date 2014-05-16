package br.com.drone4.model;


public class AerialDrone extends Drone {
	
	public AerialDrone(double x, double y, double z) {
		super(x, y, z);
	}
		
	public void goUp() {
		
		setOffsetY(speed);
		
		updateSensors();
		
	}
	
	public void goDown() {
		
		setOffsetY(-speed);
		
		updateSensors();
		
	}
		
}

