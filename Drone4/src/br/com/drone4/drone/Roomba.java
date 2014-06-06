package br.com.drone4.drone;

import java.awt.Color;

import br.com.drone4.model.TerrestrialDrone;
import br.com.luvia.linear.Mesh;
import br.com.luvia.loader.mesh.MeshLoader;

public class Roomba extends TerrestrialDrone {
	
	private Mesh model;
	
	private float startAngle = 180;
		
	public Roomba(double x, double y, double z) {
		super(x, y, z);
		
		this.speed = .5;
		
		this.turnSpeed = 10;
				
		this.angleY = startAngle;
		
		model = MeshLoader.getInstance().loadModel("terrestrial/roomba.obj");
		model.setDrawTexture(false);
		
		model.setColor(Color.DARK_GRAY);
		model.setCoordinates(x, y, z);
		
	}

	@Override
	public void goRight(double sensitivity) {
		
	}
	
	@Override
	public void goLeft(double sensitivity) {
		
	}
	
	public Mesh getModel() {
		return model;
	}
		
	@Override
	public void updateSensors() {
		
		model.setCoordinates(x, y, z);
		
		model.setAngleY(angleY);//angle in degrees
		
	}
		
}
