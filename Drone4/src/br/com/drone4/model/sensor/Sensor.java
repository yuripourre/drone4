package br.com.drone4.model.sensor;

import br.com.drone4.model.Drone;

public interface Sensor {

	public void update(Drone drone);
	
	/*
	 * Weight in grams(g)
	 */
	public double getWeight();
	
}
