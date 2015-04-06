package dji.sdk.api.GroundStation;

public class DJIGroundStationFlyingInfo {

    public int targetWaypointIndex;
    public int pitch;
    public int roll;
    public int yaw;
    public int vx;
    public int vy;
    public int vz;
    public float altitude;
    public double homeLocationLatitude;
    public double homeLocationLongitude;
    public double phantomLocationLatitude;
    public double phantomLocationLongitude;
    public DJIGroundStationTypeDef.GroundStationControlMode controlMode;
    public DJIGroundStationTypeDef.GroundStationGpsStatus gpsStatus;
	
	public DJIGroundStationFlyingInfo() {
		super();
	}
	
}
