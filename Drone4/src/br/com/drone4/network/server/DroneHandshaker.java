package br.com.drone4.network.server;

import br.com.drone4.network.client.DroneProtocol;
import br.com.midnight.model.Handshaker;

public class DroneHandshaker implements Handshaker {

	@Override
	public String handshakeMessage(String sessionId) {
		return DroneProtocol.DEFAULT_PREFIX+" Hello, pilot "+sessionId+"!!!";
	}

}
