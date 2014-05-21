package br.com.drone4.model.sensor.gps;

import br.com.drone4.model.sensor.Sensor;

public interface GPSSensor extends Sensor {
	
	public double getX();
	
	public double getY();
	
	public double getZ();

}
