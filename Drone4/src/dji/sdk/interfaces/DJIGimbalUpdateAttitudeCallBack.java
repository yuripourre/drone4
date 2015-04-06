package dji.sdk.interfaces;

import dji.sdk.api.Gimbal.DJIGimbalAttitude;

public interface DJIGimbalUpdateAttitudeCallBack {
	public void onResult(DJIGimbalAttitude attitude);
}
