package br.com.drone4.automated.action;

public class MoveAction {

  protected double x;
  protected double y;
  protected double z;

  protected double angleX;
  protected double angleY;
  protected double angleZ;

  private MoveActionType actionType;

  public MoveAction(MoveActionType actionType) {
    super();
    this.actionType = actionType;		
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getZ() {
    return z;
  }

  public void setZ(double z) {
    this.z = z;
  }

  public double getAngleX() {
    return angleX;
  }

  public void setAngleX(double angleX) {
    this.angleX = angleX;
  }

  public double getAngleY() {
    return angleY;
  }

  public void setAngleY(double angleY) {
    this.angleY = angleY;
  }

  public double getAngleZ() {
    return angleZ;
  }

  public void setAngleZ(double angleZ) {
    this.angleZ = angleZ;
  }

  public MoveActionType getActionType() {
    return actionType;
  }

  public void setActionType(MoveActionType actionType) {
    this.actionType = actionType;
  }

}