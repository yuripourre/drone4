package br.com.drone4.network.server;

import br.com.drone4.model.control.ControllerInput;
import br.com.midnight.model.Peer;
import br.com.midnight.standard.DefaultServerProtocol;


public class DroneServerProtocol extends DefaultServerProtocol {

  private ControllerInput joystick;

  public DroneServerProtocol(String prefix, ControllerInput joystick) {
    super(prefix);
    this.joystick = joystick;
  }

  @Override
  public void receiveUDP(Peer usuario, String msg) {
    // TODO Auto-generated method stub
  }

  @Override
  public void receiveTCP(Peer peer, String msg) {
    System.out.println(getClass().getSimpleName() + " - Received: " + msg);

    // Split values
    String[] values = msg.split(" ");
    double yaw = Double.parseDouble(values[0]);
    double pitch = Double.parseDouble(values[1]);
    double roll = Double.parseDouble(values[2]);
    double throttle = Double.parseDouble(values[3]);

    joystick.setYaw(-yaw);
    joystick.setPitch(pitch);
    joystick.setRoll(roll);
    joystick.setThrottle(throttle);

  }

  public ControllerInput getInput() {
    return joystick;
  }

}
