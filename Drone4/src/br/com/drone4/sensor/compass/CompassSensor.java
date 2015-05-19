package br.com.drone4.sensor.compass;

import br.com.drone4.sensor.Sensor;

public interface CompassSensor extends Sensor {
  public double getAngle();
}
