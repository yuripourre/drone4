package dji.sdk.interfaces;

import dji.sdk.api.GroundStation.DJIGroundStationTypeDef;

public interface DJIGroundStationOneKeyFlyCallBack {
	void onResult(DJIGroundStationTypeDef.GroundStationOneKeyFlyResult result);
}
