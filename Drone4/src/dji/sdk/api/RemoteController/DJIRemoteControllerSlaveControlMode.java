package dji.sdk.api.RemoteController;

import dji.sdk.api.RemoteController.DJIRemoteControllerTypeDef.ControlModeFunction;

public class DJIRemoteControllerSlaveControlMode {

	public boolean isBackward;
	
	private DJIRemoteControllerTypeDef.ControlModeFunction mode = ControlModeFunction.None;
	
	/**
	 * Allow the remote control to control the pitch, roll, yaw. 
	 */
	public DJIRemoteControllerTypeDef.ControlModeFunction function() {
		return mode;
	}
	
}
