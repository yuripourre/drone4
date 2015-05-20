package dji.sdk.api.RemoteController;

public class DJIRemoteControllerSlaveInfo {
	
	public DJIRemoteControllerSlaveInfo() {

	}
	
	/**
	 * Description : ID
	 */
	public int id;

	/**
	 * Description: Name
	 */
	public String name;
	
	/**
	 * Description : Quality
	 */
	public int quality;
	
	/**
	 * Description : password 
	 */
	public int password;
	
	public boolean takephoto;

    public boolean record;

    public boolean playback;

    public boolean pitch;

    public boolean roll;

    public boolean yaw;

    public boolean isOpen;

}
