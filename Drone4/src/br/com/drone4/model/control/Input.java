package br.com.drone4.model.control;

import br.com.etyllica.core.event.KeyEvent;

public class Input {

	private boolean forwardPressed = false;

	private boolean backwardPressed = false;

	private boolean turnLeftPressed = false;

	private boolean turnRightPressed = false;

	private boolean upPressed = false;

	private boolean downPressed = false;

	private boolean rightPressed = false;

	private boolean leftPressed = false;
	
	public void updateKeyboard(KeyEvent event) {

		if(event.isKeyDown(KeyEvent.TSK_W)) {
			upPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_W)) {
			upPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_D)) {
			rightPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_D)) {
			rightPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_A)) {
			leftPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_A)) {
			leftPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_S)) {
			downPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_S)) {
			downPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
			forwardPressed = true;			

		} else if(event.isKeyUp(KeyEvent.TSK_UP_ARROW)) {
			forwardPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {
			backwardPressed = true;

		} else if(event.isKeyUp(KeyEvent.TSK_DOWN_ARROW)) {
			backwardPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {
			turnLeftPressed = true;

		} else if(event.isKeyUp(KeyEvent.TSK_LEFT_ARROW)) {
			turnLeftPressed = false;
		}

		if(event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {
			turnRightPressed = true;
		} else if(event.isKeyUp(KeyEvent.TSK_RIGHT_ARROW)) {
			turnRightPressed = false;
		}
	}

	public boolean isForwardPressed() {
		return forwardPressed;
	}

	public boolean isBackwardPressed() {
		return backwardPressed;
	}

	public boolean isTurnLeftPressed() {
		return turnLeftPressed;
	}

	public boolean isTurnRightPressed() {
		return turnRightPressed;
	}

	public boolean isUpPressed() {
		return upPressed;
	}

	public boolean isDownPressed() {
		return downPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

}
