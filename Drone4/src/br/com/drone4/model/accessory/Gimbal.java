package br.com.drone4.model.accessory;

import br.com.drone4.model.sensor.Sensor;

public interface Gimbal extends Sensor {
	
	public void turnX(double speed);
	
	public void turnY(double speed);
	
	public void turnZ(double speed);
	
}
