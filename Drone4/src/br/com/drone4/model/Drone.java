package br.com.drone4.model;

import br.com.drone4.control.Sensitivity;
import br.com.luvia.linear.AimPoint;

public class Drone extends AimPoint {

	protected double speed = .1;
	
	protected double turnSpeed = 5;
		
	public Drone() {
		super();
	}
	
	public Drone(double x, double y, double z) {
		super(x, y, z);
	}
			
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getTurnSpeed() {
		return turnSpeed;
	}

	public void setTurnSpeed(double turnSpeed) {
		this.turnSpeed = turnSpeed;
	}

	public void goForward(double sensitivity) {
		
		double distance = speed;
		
		moveByAngle(angleY, distance);
						
		updateSensors();
	}
	
	public void goBackward(double sensitivity) {
		
		double distance = speed;
		
		moveByAngle(angleY+180, distance);
	
		updateSensors();		
	}
	
	public void goRight(double sensitivity) {
		
		double distance = speed;
		
		double angle = angleY+90;
		
		moveByAngle(angle, distance);
								
		updateSensors();
	}
	
	public void goLeft(double sensitivity) {
				
		double distance = speed;
		
		double angle = angleY-90;
		
		moveByAngle(angle, distance);
			
		updateSensors();
		
	}
	
	private void moveByAngle(double angle, double distance) {

		setX(x + Math.sin(Math.toRadians(angle)) * distance);		
		
		setZ(z - Math.cos(Math.toRadians(angle)) * distance);
		
	}

	public void turnLeft(double sensitivity) {
		
		roll(sensitivity);
	}
	
	public void turnRight(double sensitivity) {
				
		roll(-sensitivity);
	}
	
	public void turnUp(double sensitivity) {
		
		pitch(Sensitivity.NEUTRAL);
	}
	
	public void turnDown(double sensitivity) {
		
		pitch(Sensitivity.NEUTRAL);
	}
		
	public void roll(double sensitivity) {
		
		angleY += turnSpeed*sensitivity;
		
		updateSensors();
	}
	
	public void pinch(double sensitivity) {
		
		angleX += turnSpeed*sensitivity;
		
		updateSensors();
	}
	
	public void goUp(double sensitivity) {
		throttle(sensitivity);
	}
	
	public void goDown(double sensitivity) {
		throttle(sensitivity);
	}
	
	public void throttle(double sensitivity) {
		
	}
	
	public void updateSensors() {
		
	}
	
	public void pitch(double sensitivity) {
		
	}
			
}
