package br.com.drone4.sensor.gps;

import br.com.drone4.sensor.Sensor;

public interface GPSSensor extends Sensor {
	
	public double getX();
	
	public double getY();
	
	public double getZ();

}
