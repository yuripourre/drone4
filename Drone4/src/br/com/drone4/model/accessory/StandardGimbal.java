package br.com.drone4.model.accessory;

import br.com.abby.linear.AimPoint;
import br.com.drone4.model.Drone;
import br.com.drone4.sensor.camera.Camera;

public class StandardGimbal implements Gimbal {

  private int strength = 1;

  private Camera camera;
  private AimPoint point;

  public StandardGimbal(Camera camera) {
    super();

    this.camera = camera;
    this.point = new AimPoint();
  }

  @Override
  public void turnX(double speed) {
    point.offsetAngleX(speed * strength);
    camera.offsetAngleX(speed * strength);
  }

  @Override
  public void turnY(double speed) {
    point.offsetAngleY(speed * strength);
    camera.offsetAngleY(speed * strength);
  }

  @Override
  public void turnZ(double speed) {
    point.offsetAngleZ(speed * strength);
    camera.offsetAngleZ(speed * strength);
  }

  @Override
  public void update(Drone drone) {
    point.setCoordinates(drone.getX(), drone.getY(), drone.getZ());
  }

  @Override
  public double getAngleX() {
    return point.getAngleX();
  }

  @Override
  public double getAngleY() {
    return point.getAngleY();
  }

  @Override
  public double getAngleZ() {
    return point.getAngleZ();
  }

  @Override
  public double getWeight() {
    return 0;
  }
}
