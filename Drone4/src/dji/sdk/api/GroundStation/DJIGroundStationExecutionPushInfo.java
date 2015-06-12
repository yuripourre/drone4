package dji.sdk.api.GroundStation;

public class DJIGroundStationExecutionPushInfo {

	/**
	 * 0 - Initialization
	 * 1 - Moving
	 * 2 - Rotating
	 * 3 - In action
	 * 4 - Reached way point and before action
	 * 5 - Reached way point and after action
	 */
	public int currentState;
	
	/**
	 * The estimate time for finishing this task.
	 */
	public int estimateRunTime;
	
	/**
	 * There are 3 kinds of incidences: upload incidence, way point mission finish incidence and reach way point incidence.
	 */
	public DJIGroundStationTypeDef.GroundStationExecutionPushType eventType;
	
	/**
	 * The value true for valid
	 * False for invalid
	 */
	public boolean isMissionValid;
	
	/**
	 * For notificating the repeat
	 */
	public int isRepeat;
	
	/**
	 * The reserved information.
	 */
	public int reserved;
	
	/**
	 * Current Way point Index
	 */
	public int wayPointIndex;
	
}
