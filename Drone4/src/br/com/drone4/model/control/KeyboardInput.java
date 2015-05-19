package br.com.drone4.model.control;

import br.com.drone4.control.Sensitivity;
import br.com.etyllica.core.event.KeyEvent;

public class KeyboardInput {

  private static final int UNDEFINED_ID = -1;

  private int id = UNDEFINED_ID;

  private double forwardPressed = 0;
  private double backwardPressed = 0;
  private double turnLeftPressed = 0;
  private double turnRightPressed = 0;

  private double upPressed = 0;
  private double downPressed = 0;
  private double rightPressed = 0;
  private double leftPressed = 0;

  private double upperRightUpPressed = 0; // R1
  private double upperRightDownPressed = 0; // R2
  private double upperLeftUpPressed = 0; // L1
  private double upperLeftDownPressed = 0; // L2

  public KeyboardInput() {
    super();
  }

  public KeyboardInput(int id) {
    super();
    this.id = id;
  }

  public void updateKeyboard(KeyEvent event) {

    if (event.isKeyDown(KeyEvent.TSK_W)) {
      upPressed = Sensitivity.FULL_POSITIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_W)) {
      upPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_D)) {
      turnRightPressed = Sensitivity.FULL_POSITIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_D)) {
      turnRightPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_A)) {
      turnLeftPressed = Sensitivity.FULL_NEGATIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_A)) {
      turnLeftPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_S)) {
      downPressed = Sensitivity.FULL_NEGATIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_S)) {
      downPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
      forwardPressed = Sensitivity.FULL_POSITIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_UP_ARROW)) {
      forwardPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {
      backwardPressed = Sensitivity.FULL_NEGATIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_DOWN_ARROW)) {
      backwardPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {
      leftPressed = Sensitivity.FULL_NEGATIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_LEFT_ARROW)) {
      leftPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {
      rightPressed = Sensitivity.FULL_POSITIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_RIGHT_ARROW)) {
      rightPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_2)) {
      upperLeftUpPressed = Sensitivity.FULL_POSITIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_2)) {
      upperLeftUpPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_1)) {
      upperLeftDownPressed = Sensitivity.FULL_NEGATIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_1)) {
      upperLeftDownPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_9)) {
      upperRightUpPressed = Sensitivity.FULL_POSITIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_9)) {
      upperRightUpPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_0)) {
      upperRightDownPressed = Sensitivity.FULL_NEGATIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_0)) {
      upperRightDownPressed = 0;
    }

    if (id != UNDEFINED_ID && event.getId() == id) {
      updateJoystick(event);
    }

  }

  public void updateJoystick(KeyEvent event) {

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_UP)) {
      upPressed = Sensitivity.FULL_POSITIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_CENTER_Y)) {
      upPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_DOWN)) {
      downPressed = Sensitivity.FULL_NEGATIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_CENTER_Y)) {
      downPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_RIGHT)) {
      turnRightPressed = Sensitivity.FULL_NEGATIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_CENTER_X)) {
      turnRightPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_LEFT)) {
      turnLeftPressed = Sensitivity.FULL_POSITIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_CENTER_X)) {
      turnLeftPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_BUTTON_1)) {
      forwardPressed = Sensitivity.FULL_POSITIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_BUTTON_1)) {
      forwardPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_BUTTON_3)) {
      backwardPressed = Sensitivity.FULL_NEGATIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_BUTTON_3)) {
      backwardPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_BUTTON_4)) {
      leftPressed = Sensitivity.FULL_NEGATIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_BUTTON_4)) {
      leftPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_BUTTON_2)) {
      rightPressed = Sensitivity.FULL_POSITIVE;
    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_BUTTON_2)) {
      rightPressed = 0;
    }

    // Upper Buttons
    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_BUTTON_7)) {
      upperLeftUpPressed = Sensitivity.FULL_POSITIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_BUTTON_7)) {
      upperLeftUpPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_BUTTON_5)) {
      upperLeftDownPressed = Sensitivity.FULL_NEGATIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_BUTTON_5)) {
      upperLeftDownPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_BUTTON_8)) {
      upperRightUpPressed = Sensitivity.FULL_POSITIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_BUTTON_8)) {
      upperRightUpPressed = 0;
    }

    if (event.isKeyDown(KeyEvent.TSK_JOYSTICK_BUTTON_6)) {
      upperRightDownPressed = Sensitivity.FULL_NEGATIVE;

    } else if (event.isKeyUp(KeyEvent.TSK_JOYSTICK_BUTTON_6)) {
      upperRightDownPressed = 0;
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

  public boolean isUpperLeftUpPressed() {
    return upperLeftUpPressed != 0;
  }

  public boolean isUpperLeftDownPressed() {
    return upperLeftDownPressed != 0;
  }

  public boolean isUpperRightUpPressed() {
    return upperRightUpPressed != 0;
  }

  public boolean isUpperRightDownPressed() {
    return upperRightDownPressed != 0;
  }

}
