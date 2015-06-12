package dji.sdk.interfaces;

import dji.sdk.api.Battery.DJIBatteryState;

public interface DJIBatteryGetCurrentStateCallBack {
	void onResult(DJIBatteryState state);
}
