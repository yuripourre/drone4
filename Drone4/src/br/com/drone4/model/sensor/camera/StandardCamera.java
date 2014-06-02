package br.com.drone4.model.sensor.camera;

import java.awt.image.BufferedImage;

import br.com.drone4.model.Drone;
import br.com.luvia.util.CameraGL;

public class StandardCamera extends CameraGL implements Camera {

	private int width = 160;
	
	private int height = 90;
		
	protected double angleX = 0;
	
	protected double angleY = 0;
	
	protected double angleZ = 0;
	
	private BufferedImage bufferedImage;
	
	public StandardCamera(double x, double y, double z) {
		super(x, y, z);

		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		bufferedImage.createGraphics();
		
	}
	
	@Override
	public void updateSensor(Drone drone) {
		
		setCoordinates(drone.getX(), drone.getY(), drone.getZ());
		
		this.angleX = drone.getAngleX();
		
		this.angleY = drone.getAngleY();
		
		this.angleZ = drone.getAngleZ();
		
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	@Override
	public BufferedImage getBufferedImage() {

		return bufferedImage;
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
		
}
