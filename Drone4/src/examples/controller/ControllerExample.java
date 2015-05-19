package examples.controller;

import java.awt.Color;

import br.com.drone4.network.ControllerClient;
import br.com.drone4.network.listener.DroneListener;
import br.com.etyllica.context.Application;
import br.com.etyllica.context.UpdateIntervalListener;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.ImageLayer;
import examples.controller.model.JoystickRadius;

public class ControllerExample extends Application implements DroneListener, UpdateIntervalListener {

	// View
	private ImageLayer background;

	private JoystickRadius leftJoystick;
	private JoystickRadius rightJoystick;

	private static final int UPDATE_DELAY = 100;

	// Network
	private ControllerClient client;

	public ControllerExample(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		background = new ImageLayer("control/controller_cut.jpg");

		leftJoystick = new JoystickRadius(36, 110);
		rightJoystick = new JoystickRadius(282, 110);

		client = new ControllerClient("127.0.0.1", this);
		client.start(UPDATE_DELAY);

		updateAtFixedRate(UPDATE_DELAY, this);

		loading = 100;
	}

	@Override
	public void timeUpdate(long now) {

		client.getProtocol().sendJoystick(leftJoystick.getSensitivityX(),
				rightJoystick.getSensitivityY(), rightJoystick.getSensitivityX(),
				leftJoystick.getSensitivityY());
	}

	@Override
	public void draw(Graphic g) {
		background.draw(g);

		leftJoystick.draw(g);
		rightJoystick.draw(g);

		g.setColor(Color.WHITE);
		g.drawShadow(40, 40, Float.toString(leftJoystick.getSensitivityX()));
		g.drawShadow(40, 80, Float.toString(leftJoystick.getSensitivityY()));

		g.drawShadow(240, 40, Float.toString(rightJoystick.getSensitivityX()));
		g.drawShadow(240, 80, Float.toString(rightJoystick.getSensitivityY()));
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {

		leftJoystick.updateMouse(event);
		rightJoystick.updateMouse(event);

		return null;
	}

	@Override
	public void receiveHandShake(String message) {
		System.out.println(message);
	}

}
