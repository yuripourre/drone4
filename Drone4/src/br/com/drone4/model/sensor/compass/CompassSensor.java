package br.com.drone4.model.sensor.compass;

import br.com.drone4.model.sensor.Sensor;

public interface CompassSensor extends Sensor {
	
	public double getAngle();
	
}
