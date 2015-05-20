package dji.sdk.api.GroundStation;

public class DJIGroundStationMissionPushInfo {
	
	/**
	 * 0 - Initialization
	 * 1 - Moving
	 * 2 - Rotating
	 * 3 - In action
	 * 4 - Reached way point and before action
	 * 5 - Reached way point and after action
	 */
	public int currState;
	
	public int errorNotification;
	
	/**
	 * angle in ground frame, degree * 10.
	 */
	public int hotPointAngle;
	
	/**
	 * 0 Init, 1 Running
	 */
	public int hotPointMissionStatus;
	
	/**
	 * distance to hot point, cm
	 */
	public int hotPointRadius;
	
	/**
	 * 4 kinds of mission type:
	 * 0x00 - Attitude
	 * 0x01 - Way Point Mission
	 * 0x02 - Hot Point
	 * 0x03 - Follow Me
	 */
	DJIGroundStationTypeDef.GroundStationStatusPushType missionType;
	
	int reserved;
	
	/**
	 * Next Way Point index
	 */
	public int targetWayPointIndex;
	
}
