package dji.sdk.interfaces;

public interface DJIRemoteControllerGimbalSpeedCallBack {
	void onResult(int pitchSpeed, int rollSpeed, int yawSpeed);
}
