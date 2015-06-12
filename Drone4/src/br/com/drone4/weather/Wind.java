package br.com.drone4.weather;

import br.com.drone4.model.Drone;
import br.com.etyllica.linear.vector.Vec3D;

public class Wind {

	private Vec3D direction;
	private double strength;
	
	public Wind(Vec3D direction, double strength) {
		this.direction = direction;
		this.strength = strength;
	}
	
	public Vec3D getDirection() {
		return direction;
	}
	
	public void setDirection(Vec3D direction) {
		this.direction = direction;
	}
	
	public double getStrength() {
		return strength;
	}
	
	public void setStrength(double strength) {
		this.strength = strength;
	}
	
	public void moveDrone(Drone drone) {
		drone.offsetX(direction.getX()*strength);
		drone.offsetY(direction.getY()*strength);
		drone.offsetZ(direction.getZ()*strength);
		drone.updateSensors();
	}
}
