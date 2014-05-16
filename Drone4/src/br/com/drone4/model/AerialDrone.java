package br.com.drone4.model;


public class AerialDrone extends Drone {
	
	public AerialDrone() {
		super();
	}
	
	public void goUp() {
		
		setOffsetY(speed);
		
	}
	
	public void goDown() {
		
		setOffsetY(-speed);
		
	}
		
}

