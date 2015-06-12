package dji.sdk.interfaces;

import dji.sdk.api.RemoteController.DJIRemoteControllerTypeDef;

public interface DJIRemoteControllerCalibrationStatusCallBack {
	//Intentional typo
	void onReslt(DJIRemoteControllerTypeDef.DJIRemoteControllerCalibrationStatus result);
}
