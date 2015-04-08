package br.com.drone4.model.sensor.battery;

import br.com.drone4.model.sensor.Sensor;

public interface BatterySensor extends Sensor {

	public double getLevel();
	
	/*
	 * percentage(0~1) = level / scale
	 */
	public double getScale();
	
	/*
	 * power in watts(W)
	 */
	public double getMaxPower();
		
	/*
	 * max dischargeCurrent in milliampere (mA)
	 */
	public double current();
		
	/*
	 * volts(V)
	 */
	public double getVoltage();
		
	/*
	 * milliampere per hour(mAh)
	 */
	public double getCapacity();
	
	/**
	 * Set Battery Current Level (0~scale)
	 * @param level
	 */
	public void setLevel(double level);
	
}
