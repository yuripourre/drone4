package dji.sdk.interfaces;

import dji.sdk.api.GroundStation.DJIGroundStationFlyingInfo;

public interface DJIGroundStationFlyingInfoCallBack {
	void onResult(DJIGroundStationFlyingInfo flyingInfo);
}
