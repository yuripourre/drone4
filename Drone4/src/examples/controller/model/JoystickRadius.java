package examples.controller.model;

import java.awt.Color;

import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.etyllica.layer.Layer;
import br.com.etyllica.linear.Point2D;
import br.com.luvia.util.PointUtils;

public class JoystickRadius {

	private static final int DEFAULT_RADIUS = 120/2;
	private static final int DEFAULT_JOYSTICK_RADIUS = 50/2;

	private Layer area;
	private Layer joystick;
	private boolean active = false;

	//Center
	private float sensitivityX = 0;
	private float sensitivityY = 0;
	
	private Point2D center;
	private Point2D joyPosition;

	public JoystickRadius(int x, int y) {
		super();
		area = new Layer(x, y, DEFAULT_RADIUS*2, DEFAULT_RADIUS*2);

		int cx = area.getX()+DEFAULT_RADIUS;
		int cy = area.getY()+DEFAULT_RADIUS;
		
		center = new Point2D(cx, cy);
		joyPosition = new Point2D(cx, cy);
		
		joystick = new Layer(cx-DEFAULT_JOYSTICK_RADIUS, cy-DEFAULT_JOYSTICK_RADIUS, DEFAULT_JOYSTICK_RADIUS*2, DEFAULT_JOYSTICK_RADIUS*2);
	}

	public Layer getArea() {
		return area;
	}

	public Layer getJoystick() {
		return joystick;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void draw(Graphic g) {

		g.setAlpha(50);
		g.setColor(Color.BLACK);
		g.fillOval(area);

		if(active) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.YELLOW);
		}

		g.fillOval(joystick);
		g.resetOpacity();
	}

	public void updateMouse(PointerEvent event) {

		int mx = event.getX();
		int my = event.getY();

		if(event.isButtonDown(MouseButton.MOUSE_BUTTON_LEFT)) {

			if(!active) {
				if(joystick.colideCirclePoint(mx, my)) {
					setActive(true);
				}
			} else {

				calculateSensitivityX(mx);
				calculateSensitivityY(my);
				
				int jx = mx-DEFAULT_JOYSTICK_RADIUS;
				int jy = my-DEFAULT_JOYSTICK_RADIUS;
				
				joyPosition.setLocation(mx, my);
								
				double dist = joyPosition.distance(center);
				
				if(dist < DEFAULT_RADIUS) {
					joystick.setCoordinates(jx, jy);					
				} else {
					Point2D limit = PointUtils.distantPoint(center, joyPosition, DEFAULT_RADIUS);
					joystick.setCoordinates((int)limit.getX()-DEFAULT_JOYSTICK_RADIUS, (int)limit.getY()-DEFAULT_JOYSTICK_RADIUS);
				}				
			}

		} else if(event.isButtonUp(MouseButton.MOUSE_BUTTON_LEFT)) {
			if(active) {
				setActive(false);
				resetJoystick();
				sensitivityX = 0;
				sensitivityY = 0;
			}
		}		
	}

	private void calculateSensitivityX(int mx) {
		float cx = area.getX()+DEFAULT_RADIUS;

		sensitivityX = (mx-cx)/DEFAULT_RADIUS;

		if(sensitivityX>1) {
			sensitivityX = 1;
		} else if(sensitivityX<-1) {
			sensitivityX = -1;
		}
	}
	
	private void calculateSensitivityY(int my) {
		float cy = area.getY()+DEFAULT_RADIUS;

		sensitivityY = (my-cy)/DEFAULT_RADIUS;

		if(sensitivityY>1) {
			sensitivityY = 1;
		} else if(sensitivityY<-1) {
			sensitivityY = -1;
		}
		
		sensitivityY = -sensitivityY;
	}

	private void resetJoystick() {
		int cx = area.getX()+DEFAULT_RADIUS-DEFAULT_JOYSTICK_RADIUS;
		int cy = area.getY()+DEFAULT_RADIUS-DEFAULT_JOYSTICK_RADIUS;

		joystick.setCoordinates(cx, cy);
	}

	public float getSensitivityX() {
		return sensitivityX;
	}
	
	public float getSensitivityY() {
		return sensitivityY;
	}

}
