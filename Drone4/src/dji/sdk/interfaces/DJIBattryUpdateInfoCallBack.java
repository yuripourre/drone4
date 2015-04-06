package dji.sdk.interfaces;

import dji.sdk.api.Battery.DJIBatteryProperty;

//Intentional typo (Battry) to reflect DJI's API
public interface DJIBattryUpdateInfoCallBack {
	void onResult(DJIBatteryProperty state);
}
