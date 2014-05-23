package br.com.drone4.model;

import br.com.luvia.linear.Point3D;

public class Drone extends Point3D {

	protected double speed = .1;
	
	protected double turnSpeed = 5;//in angles
	
	protected double angleX = 0;
	
	protected double angleY = 0;
	
	protected double angleZ = 0;
	
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

	public double getAngleX() {
		return angleX;
	}

	public void setAngleX(double angleX) {
		this.angleX = angleX;
	}

	public double getAngleY() {
		return angleY;
	}

	public void setAngleY(double angleY) {
		this.angleY = angleY;
	}

	public double getAngleZ() {
		return angleZ;
	}

	public void setAngleZ(double angleZ) {
		this.angleZ = angleZ;
	}

	public void goForward() {
		
		double distance = speed;
		
		moveByAngle(angleY, distance);
						
		updateSensors();
	}
	
	public void goBackward() {
		
		double distance = speed;
		
		moveByAngle(angleY+180, distance);
	
		updateSensors();		
	}
	
	public void goRight() {
		
		double distance = speed;
		
		double angle = -angleY+90;
		
		moveByAngle(angle, distance);
								
		updateSensors();
	}
	
	public void goLeft() {
				
		double distance = speed;
		
		double angle = -angleY-90;
		
		moveByAngle(angle, distance);
			
		updateSensors();
		
	}
	
	private void moveByAngle(double angle, double distance) {

		setX(x + Math.sin(Math.toRadians(angle)) * distance);		
		
		setZ(z - Math.cos(Math.toRadians(angle)) * distance);
		
	}

	public void turnRight() {
		
		angleY -= turnSpeed;
		
		updateSensors();
		
	}
	
	public void turnLeft() {
		
		angleY += turnSpeed;
		
		updateSensors();
	}
	
	public void goUp() {
		
	}
	
	public void goDown() {
		
	}
	
	public void updateSensors() {
		
	}
		
}
