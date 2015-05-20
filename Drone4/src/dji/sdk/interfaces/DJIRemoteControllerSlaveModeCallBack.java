package dji.sdk.interfaces;

import java.util.ArrayList;

import dji.sdk.api.RemoteController.DJIRemoteControllerSlaveControlMode;

public interface DJIRemoteControllerSlaveModeCallBack {
	void onResult(boolean isDefault, ArrayList<DJIRemoteControllerSlaveControlMode> result);
}
