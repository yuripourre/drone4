package br.com.drone4.model.sensor.battery.dji;

import br.com.drone4.model.Drone;
import br.com.drone4.model.sensor.battery.BatterySensor;

public class DJISmartBattery implements BatterySensor {

	private double scale = 100;
	
	private double level = 100;
	
	private double weight = 400; //400g
	
	private double voltage = 11.1;
	
	private double maxPower = 100; //Dont know
	
	private double maxCurrent = 5000; //Dont know
	
	private double capacity = 5200; //mAh
		
	@Override
	public void update(Drone drone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public double getLevel() {
		return level;
	}

	@Override
	public double getScale() {
		return scale;
	}

	@Override
	public double getVoltage() {
		return voltage;
	}

	@Override
	public double getCapacity() {
		return capacity;
	}

	@Override
	public double getMaxPower() {
		return maxPower;
	}

	@Override
	public double current() {
		return maxCurrent;
	}

	@Override
	public void setLevel(double level) {
		this.level = level;
	}

}
