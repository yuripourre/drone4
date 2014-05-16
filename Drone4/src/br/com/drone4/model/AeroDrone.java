package br.com.drone4.model;


public class AeroDrone extends Drone {
	
	public AeroDrone() {
		super();
	}
	
	public void goUp() {
		
		setOffsetY(speed);
		
	}
	
	public void goDown() {
		
		setOffsetY(-speed);
		
	}
		
}

