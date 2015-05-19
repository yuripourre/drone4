package dji.sdk.interfaces;

import dji.sdk.api.Battery.DJIBatteryProperty;

public interface DJIBatteryUpdateInfoCallBack {
	void onResult(DJIBatteryProperty state);
}
