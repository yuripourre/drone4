package br.com.drone4.model.sensor.camera;

import java.awt.image.BufferedImage;

import br.com.drone4.model.sensor.Sensor;

public interface Camera extends Sensor {
		
	public BufferedImage getBufferedImage();
	
	public void setOffsetAngleX(double offsetAngleX);
	
	public void setOffsetAngleY(double offsetAngleY);
	
	public void setOffsetAngleZ(double offsetAngleZ);
	
}
