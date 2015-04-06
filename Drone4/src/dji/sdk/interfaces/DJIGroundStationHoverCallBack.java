package dji.sdk.interfaces;

import dji.sdk.api.GroundStation.DJIGroundStationTypeDef;

public interface DJIGroundStationHoverCallBack {
	void onResult(DJIGroundStationTypeDef.GroundStationHoverResult result);
}
