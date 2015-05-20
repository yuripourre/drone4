package dji.sdk.interfaces;

import dji.sdk.api.GroundStation.DJIGroundStationTypeDef;

public interface DJIGroundStationExecuteCallBack {
	void onResult(DJIGroundStationTypeDef.GroundStationResult result);
}
