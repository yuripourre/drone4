package br.com.drone4.model;

import br.com.luvia.linear.Point3D;

public class Drone extends Point3D {

	protected double speed = .1;
	
	protected double angleX = 0;
	
	protected double angleY = 0;
	
	protected double angleZ = 0;
	
	public Drone() {
		super();
	}
	
	public void goForward() {
		
		double distance = speed;
		
		setX(x + Math.cos(angleY) * distance);
		
		setY(y + Math.sin(angleY) * distance);
				
	}
	
	public void goBackward() {
		
		double distance = speed;
		
		setX(x - Math.cos(angleY) * distance);
		
		setY(y - Math.sin(angleY) * distance);
	
	}

	public void turnRight() {
		
		angleY += speed;
		
	}
	
	public void turnLeft() {
		
		angleY -= speed;
		
	}
	
}
