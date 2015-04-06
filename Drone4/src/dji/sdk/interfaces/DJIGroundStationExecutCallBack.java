package dji.sdk.interfaces;

import dji.sdk.api.GroundStation.DJIGroundStationTypeDef;

public interface DJIGroundStationExecutCallBack {
	void onResult(DJIGroundStationTypeDef.GroundStationResult result);
}
