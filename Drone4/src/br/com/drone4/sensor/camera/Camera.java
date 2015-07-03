package br.com.drone4.sensor.camera;

import java.awt.image.BufferedImage;

import br.com.drone4.sensor.Sensor;

public interface Camera extends Sensor {

  public BufferedImage getBufferedImage();

  public void offsetAngleX(double offsetAngleX);
  public void offsetAngleY(double offsetAngleY);
  public void offsetAngleZ(double offsetAngleZ);

}
