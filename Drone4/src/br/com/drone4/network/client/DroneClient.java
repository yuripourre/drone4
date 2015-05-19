package br.com.drone4.network.client;

import br.com.drone4.network.listener.DroneListener;
import br.com.midnight.client.TCPClient;

public class DroneClient extends TCPClient {

  private DroneProtocol actionProtocol;

  public DroneClient(String ip, int tcpPort, DroneListener listener) {
    super(ip, tcpPort, true);

    actionProtocol = new DroneProtocol(listener);

    addProtocol(actionProtocol);
  }

  public DroneProtocol getActionProtocol() {
    return actionProtocol;
  }

}
