package br.com.drone4.model.accessory;

import br.com.drone4.model.Drone;
import br.com.drone4.model.sensor.camera.Camera;

public class StandardGimbal implements Gimbal {
	
	private int strength = 1;
	
	private Camera camera;
		
	public StandardGimbal(Camera camera) {
		super();
		
		this.camera = camera;
	}
	
	@Override
	public void turnX(double speed) {				
		camera.setOffsetAngleX(speed*strength);
	}

	@Override
	public void turnY(double speed) {
		camera.setOffsetAngleY(speed*strength);
	}

	@Override
	public void turnZ(double speed) {
		camera.setOffsetAngleZ(speed*strength);
	}

	@Override
	public void update(Drone drone) {
		// TODO Auto-generated method stub
	}

	@Override
	public double getWeight() {
		return 0;
	}
}
