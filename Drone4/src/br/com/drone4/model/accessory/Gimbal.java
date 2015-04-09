package br.com.drone4.model.accessory;

import br.com.drone4.sensor.Sensor;

public interface Gimbal extends Sensor {
	
	public double getAngleX();
	
	public double getAngleY();
	
	public double getAngleZ();
	
	public void turnX(double speed);
	
	public void turnY(double speed);
	
	public void turnZ(double speed);
	
}
