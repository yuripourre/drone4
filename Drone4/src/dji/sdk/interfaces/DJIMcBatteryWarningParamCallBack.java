package dji.sdk.interfaces;

import dji.sdk.api.MainController.DJIBatteryWarningParameter;

public interface DJIMcBatteryWarningParamCallBack {
	void onResult(DJIBatteryWarningParameter result);
}
