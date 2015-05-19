package br.com.drone4.network.client;

import br.com.drone4.network.listener.DroneListener;
import br.com.midnight.standard.DefaultClientProtocol;

public class DroneProtocol extends DefaultClientProtocol {

  private DroneListener listener;

  public static final String DEFAULT_PREFIX = "/d";

  public DroneProtocol(DroneListener listener) {
    super(DEFAULT_PREFIX);
    this.listener = listener;
  }

  public void sendJoystick(double yaw, double pitch, double roll, double throttle) {
    sendTCP(Double.toString(yaw) + " " + Double.toString(pitch) + " " + Double.toString(roll) + " "
        + Double.toString(throttle));
  }

  @Override
  public void receiveTCP(String msg) {
    listener.receiveHandShake(msg);
  }

  @Override
  public void receiveUDP(String msg) {
    // TODO Auto-generated method stub
  }

}
