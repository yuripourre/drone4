package br.com.drone4.model.sensor.battery;

import br.com.drone4.model.sensor.Sensor;

public interface BatterySensor extends Sensor {

	public double getVoltage();
	
	public double getCapacity();
			
}
