package dji.sdk.interfaces;

import dji.sdk.api.Gimbal.DJIGimbalCalibrationStatus;

public interface DJIGimbalCalibrationStatusCallBack {
	void onResult(DJIGimbalCalibrationStatus status);
}
