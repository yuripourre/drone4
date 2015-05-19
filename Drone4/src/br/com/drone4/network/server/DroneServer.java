package br.com.drone4.network.server;

import br.com.drone4.model.control.ControllerInput;
import br.com.drone4.network.client.DroneProtocol;
import br.com.midnight.model.Peer;
import br.com.midnight.server.TCPServer;

public class DroneServer extends TCPServer {

  private DroneServerProtocol listener;

  public DroneServer(int port, ControllerInput joystick) {
    super(port);

    name = "Drone Server";

    handshaker = new DroneHandshaker();

    listener = new DroneServerProtocol(DroneProtocol.DEFAULT_PREFIX, joystick);

    addProtocol(DroneProtocol.DEFAULT_PREFIX, listener);
  }

  @Override
  public void start() {
    super.start();
  }

  @Override
  public void joinPeer(Peer peer) {
    System.out.println("ActionPeer " + peer.getSessionID() + " connected.");

    listener.addPeer(peer);
  }

  public ControllerInput getInput() {
    return listener.getInput();
  }

}
