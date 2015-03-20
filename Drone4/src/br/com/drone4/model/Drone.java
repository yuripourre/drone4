package br.com.drone4.model;

import br.com.abby.linear.AimPoint;

public class Drone extends AimPoint {

	protected double speed = .1;
	
	/**
	 * Throttle Speed (speed to go Up/Down)
	 */
	protected double throttleSpeed = speed;
	
	/**
	 * Roll Speed (speed to go Forward/Backward)
	 */
	protected double rollSpeed = speed;
	
	/**
	 * Pitch Speed (speed to go Left/Right)
	 */
	protected double pitchSpeed = speed;
	
	/**
	 * Yaw Speed (turn speed in Y(aw) axis)
	 */
	protected double yawSpeed = 5;
	
	protected float startAngle = 0;
	
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
		return yawSpeed;
	}

	public void setTurnSpeed(double turnSpeed) {
		this.yawSpeed = turnSpeed;
	}

	public void goForward(double sensitivity) {
		
		double distance = speed*sensitivity;
		
		moveByAngle(angleY-startAngle, distance);
		
		updateSensors();
	}
	
	public void goBackward(double sensitivity) {
		
		double distance = speed*sensitivity;
		
		moveByAngle(angleY-startAngle, distance);
	
		updateSensors();
	}
	
	public void goRight(double sensitivity) {
		
		double distance = speed*sensitivity;
		
		double angle = angleY+90;
		
		moveByAngle(angle, distance);
		
		updateSensors();
	}
	
	public void goLeft(double sensitivity) {
				
		double distance = speed*sensitivity;
		
		double angle = angleY-90;
		
		moveByAngle(angle, distance);
			
		updateSensors();
		
	}
	
	protected void moveByAngle(double angle, double distance) {

		setX(x + Math.sin(Math.toRadians(angle)) * distance);
		
		setZ(z - Math.cos(Math.toRadians(angle)) * distance);
		
	}

	public void turnLeft(double sensitivity) {
		yaw(sensitivity);
	}
	
	public void turnRight(double sensitivity) {
		yaw(sensitivity);
	}
	
	public void turnUp(double sensitivity) {
		pitch(sensitivity);
	}
	
	public void turnDown(double sensitivity) {
		pitch(sensitivity);
	}
		
	public void yaw(double sensitivity) {
		angleY += yawSpeed*sensitivity;
		updateSensors();
	}
	
	public void pitch(double sensitivity) {
		angleX += pitchSpeed*sensitivity;
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
				
}
