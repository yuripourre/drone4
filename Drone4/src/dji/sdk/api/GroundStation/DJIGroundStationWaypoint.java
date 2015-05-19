package dji.sdk.api.GroundStation;

public class DJIGroundStationWaypoint {

	public float altitude;
	public int turnMode;
	public float heading;
	public float speed;
	public short stayTime;
	public short maxReachTime;
	public double latitude;
	public double lontitude; // Typo to reflects DJI's API

	/**
	 * Constructor
	 * 
	 * @param mLatitude - The waypoint latitude
	 * @param mLontitude - The waypoint lontitude
	 */
	public DJIGroundStationWaypoint(double mLatitude, double mLontitude) {
		this.latitude = mLatitude;
		this.lontitude = mLontitude;
	}

	public DJIGroundStationWaypoint(double mLatitude, double mLontitude, float altitude) {
		this.latitude = mLatitude;
		this.lontitude = mLontitude;
		this.altitude = altitude;
	}

}
