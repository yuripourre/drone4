package br.com.drone4.control;

public interface Control {

	public void yaw(double sensitivity);
	
	public void throttle(double sensitivity);
	
	public void pitch(double sensitivity);
	
	public void roll(double sensitivity);
	
}
