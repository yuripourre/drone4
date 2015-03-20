package br.com.drone4.network;

import br.com.drone4.network.client.DroneClient;
import br.com.drone4.network.client.DroneProtocol;
import br.com.drone4.network.listener.DroneListener;

public class ControllerClient {

	private DroneClient client;
	
	private DroneProtocol protocol;
	
	public static final int PORT = 9906;
	
	private static final String LOCAL_IP = "127.0.0.1";
		
	private String lastMessage = "No messages!";
		
	public ControllerClient(String ip, DroneListener listener) {
		super();
		
		client = new DroneClient(ip, PORT, listener);
		
		protocol = client.getActionProtocol();
	}
	
	public void start(int delay) {
		client.start(delay);
	}

	public DroneProtocol getProtocol() {
		return protocol;
	}
}
