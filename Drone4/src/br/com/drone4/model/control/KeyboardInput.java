package br.com.drone4.model.control;

import br.com.drone4.control.Sensitivity;
import br.com.etyllica.core.event.KeyEvent;

public class KeyboardInput {

	private double forwardPressed = 0;

	private double backwardPressed = 0;

	private double turnLeftPressed = 0;

	private double turnRightPressed = 0;

	private double upPressed = 0;

	private double downPressed = 0;

	private double rightPressed = 0;

	private double leftPressed = 0;
	
	public void updateKeyboard(KeyEvent event) {

		if(event.isKeyDown(KeyEvent.TSK_W)) {
			upPressed = Sensitivity.FULL_POSITIVE;
		} else if(event.isKeyUp(KeyEvent.TSK_W)) {
			upPressed = 0;
		}

		if(event.isKeyDown(KeyEvent.TSK_D)) {
			rightPressed = Sensitivity.FULL_POSITIVE;
		} else if(event.isKeyUp(KeyEvent.TSK_D)) {
			rightPressed = 0;
		}

		if(event.isKeyDown(KeyEvent.TSK_A)) {
			leftPressed = Sensitivity.FULL_NEGATIVE;
		} else if(event.isKeyUp(KeyEvent.TSK_A)) {
			leftPressed = 0;
		}

		if(event.isKeyDown(KeyEvent.TSK_S)) {
			downPressed = Sensitivity.FULL_NEGATIVE;
		} else if(event.isKeyUp(KeyEvent.TSK_S)) {
			downPressed = 0;
		}

		if(event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
			forwardPressed = Sensitivity.FULL_POSITIVE;			

		} else if(event.isKeyUp(KeyEvent.TSK_UP_ARROW)) {
			forwardPressed = 0;
		}

		if(event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {
			backwardPressed = Sensitivity.FULL_NEGATIVE;

		} else if(event.isKeyUp(KeyEvent.TSK_DOWN_ARROW)) {
			backwardPressed = 0;
		}

		if(event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {
			turnLeftPressed = Sensitivity.FULL_NEGATIVE;

		} else if(event.isKeyUp(KeyEvent.TSK_LEFT_ARROW)) {
			turnLeftPressed = 0;
		}

		if(event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {
			turnRightPressed = Sensitivity.FULL_POSITIVE;
		} else if(event.isKeyUp(KeyEvent.TSK_RIGHT_ARROW)) {
			turnRightPressed = 0;
		}
	}

	public boolean isForwardPressed() {
		return forwardPressed != 0;
	}

	public boolean isBackwardPressed() {
		return backwardPressed != 0;
	}

	public boolean isTurnLeftPressed() {
		return turnLeftPressed != 0;
	}

	public boolean isTurnRightPressed() {
		return turnRightPressed != 0;
	}

	public boolean isUpPressed() {
		return upPressed != 0;
	}

	public boolean isDownPressed() {
		return downPressed != 0;
	}

	public boolean isRightPressed() {
		return rightPressed != 0;
	}

	public boolean isLeftPressed() {
		return leftPressed != 0;
	}	

}