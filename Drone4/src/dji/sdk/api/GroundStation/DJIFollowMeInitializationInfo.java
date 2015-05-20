package dji.sdk.api.GroundStation;

public class DJIFollowMeInitializationInfo {
	
	/**
	 * This parameter will determine what kind of navigation mode the follow me will choose, such as point to customer and remote control.
	 */
	public DJIGroundStationTypeDef.GroundStationFollowMeNavigationDirection dir;
	
	/**
	 * We suggest that the attitude is better to choose within [3, 20].
	 */
	public float followingAltitude;
	
	/**
	 * We suggest that the distance is better to choose within [4, 10].
	 */
	public float followingDistance;
	
	/**
	 * This will determine which kind of mode the follow me will act.
	 */
	public DJIGroundStationTypeDef.GroundStationFollowMeMode mode;
	
	
	public int sensitivity;
}
