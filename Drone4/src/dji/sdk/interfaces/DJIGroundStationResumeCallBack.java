package dji.sdk.interfaces;

import dji.sdk.api.GroundStation.DJIGroundStationTypeDef;

public interface DJIGroundStationResumeCallBack {
	void onResult(DJIGroundStationTypeDef.GroundStationResumeResult result);
}
