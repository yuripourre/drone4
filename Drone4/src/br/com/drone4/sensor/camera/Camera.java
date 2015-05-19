package br.com.drone4.sensor.camera;

import java.awt.image.BufferedImage;

import br.com.drone4.sensor.Sensor;

public interface Camera extends Sensor {

  public BufferedImage getBufferedImage();

  public void setOffsetAngleX(double offsetAngleX);
  public void setOffsetAngleY(double offsetAngleY);
  public void setOffsetAngleZ(double offsetAngleZ);

}
