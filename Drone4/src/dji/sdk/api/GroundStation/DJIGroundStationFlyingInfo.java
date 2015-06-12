package dji.sdk.api.GroundStation;

public class DJIGroundStationFlyingInfo {

	public float altitude;
	
	/**
	 * The phantom location latitude.
	 */
	public double droneLocationLatitude;
	
	/**
	 * The phantom location longitude
	 */
	public double droneLocationLongitude;
	
	/**
	 * ControlMode
	 */
	public DJIGroundStationTypeDef.GroundStationFlightMode flightMode;
	
	/**
	 * GPS Status
	 */
	public DJIGroundStationTypeDef.GroundStationGpsStatus gpsStatus;
	
	/**
	 * The home point location latitude.
	 */
	public double homeLocationLatitude;
	
	/**
	 * The home point location longitude.
	 */
	public double homeLocationLongitude;
	
	/**
	 * Pitch
	 */
	public int pitch;
	
	/**
	 * Roll
	 */
	public int roll;
	
	/**
	 * Target Waypoint Index
	 */
	public int targetWaypointIndex;
	
	/**
	 * Velocity along latitude direction.
	 */
	public int velocityX;
	
	/**
	 * Velocity along longitude direction.
	 */
	public int velocityY;
	
	/**
	 * Velocity along vertical direction.
	 */
	public int velocityZ;
	
	/**
	 * Yaw
	 */
	public int yaw;
	

	public DJIGroundStationFlyingInfo() {
		super();
	}

}
