package br.com.drone4.drone;

import br.com.drone4.model.TerrestrialDrone;

public class Roomba extends TerrestrialDrone {
	
	private float startAngle = 180;
		
	public Roomba(double x, double y, double z) {
		super(x, y, z);
		
		this.speed = .5;
		
		this.turnSpeed = 10;
				
		this.angleY = startAngle;
		
	}

	@Override
	public void goRight(double sensitivity) {
		
	}
	
	@Override
	public void goLeft(double sensitivity) {
		
	}
	
	@Override
	public void updateSensors() {
			
	}
	
}
