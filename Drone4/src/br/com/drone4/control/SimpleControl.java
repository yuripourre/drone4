package br.com.drone4.control;

import br.com.drone4.model.Drone;

public class SimpleControl implements Control {
	
	private Drone drone;
	
	public SimpleControl(Drone drone) {
		super();
		
		this.drone = drone;
	}
	
	public void pressUp() {
		throttle(Sensitivity.FULL_POSITIVE);
	}
	
	public void pressDown(double sensitivity) {
		throttle(Sensitivity.FULL_NEGATIVE);
	}

	public void pressRight(double sensitivity) {
		yaw(Sensitivity.FULL_POSITIVE);
	}
	
	public void pressLeft(double sensitivity) {
		yaw(Sensitivity.FULL_NEGATIVE);
	}
			
	public void pressForward(double sensitivity) {
		pitch(Sensitivity.FULL_POSITIVE);
	}
	
	public void pressBackward(double sensitivity) {
		pitch(Sensitivity.FULL_NEGATIVE);
	}
		
	public void pressTurnRight(double sensitivity) {
		roll(Sensitivity.FULL_POSITIVE);		
	}
	
	public void pressTurnLeft(double sensitivity) {
		roll(Sensitivity.FULL_NEGATIVE);
	}

	@Override
	public void yaw(double sensitivity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void throttle(double sensitivity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pitch(double sensitivity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void roll(double sensitivity) {
		// TODO Auto-generated method stub
		
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}
		
}
