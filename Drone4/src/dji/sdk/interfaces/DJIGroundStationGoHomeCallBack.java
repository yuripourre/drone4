package dji.sdk.interfaces;

import dji.sdk.api.GroundStation.DJIGroundStationTypeDef;

public interface DJIGroundStationGoHomeCallBack {
	void onResult(DJIGroundStationTypeDef.GroundStationGoHomeResult result);
}
