package dji.sdk.interfaces;

import dji.sdk.api.GroundStation.DJIGroundStationTypeDef;

public interface DJIGroundStationTakeOffCallBack {
	void onResult(DJIGroundStationTypeDef.GroundStationTakeOffResult result);
}
