package dji.sdk.api.RemoteController;

public class DJIRemoteControllerMasterInfo {

	/**
	 * The Master ID
	 */
    public int ID;

    /**
     * The Master Name 
     */
    public String name;

    
    /**
     * 4 digits password
     */
    public int password;

	/**
	 * The communication quality
	 */
    public int quality;
    
    //Intentional typo
    public DJIRemoteControllerMasterInfo(int ID, String name, int passward, int quality) {
    	super();
    	this.ID = ID;
    	this.name = name;
    	this.password = passward;
    	this.quality = quality;
    }

}
