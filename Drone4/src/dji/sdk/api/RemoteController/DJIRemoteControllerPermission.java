package dji.sdk.api.RemoteController;

public class DJIRemoteControllerPermission {

	public DJIRemoteControllerPermission() {
	
	}
	
	public int id; 
	
	/**
	 * True (allow) & False (not allow)
	 */
	public boolean pitch;
	
	/**
	 * True (allow) & False (not allow)
	 */
	public boolean playback;
	
	/**
	 * True (allow) & False (not allow)
	 */
	public boolean record;
	
	/**
	 * True (allow) & False (not allow)
	 */
	public boolean roll;

	/**
	 * True (allow) & False (not allow)
	 */
	public boolean takephoto;

	/**
	 * True (allow) & False (not allow)
	 */
	public boolean yaw;
}
