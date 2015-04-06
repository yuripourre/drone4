package dji.sdk.interfaces;

import dji.sdk.api.DJIError;

public interface DJISmartBatteryExecuteResultCallback {
	public void onResult(double result, DJIError mErr);
}
