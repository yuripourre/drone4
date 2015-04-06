package dji.sdk.api.Gimbal;

public class DJIGimbalRotation {

	public int angle;
	public boolean direction;
	public boolean enable;
	public boolean type;
	
	/**
	 * 
	 * @param mEnable - The rotate enable
	 * @param mDirection - The rotate direction
	 * @param mType - The rotate type
	 * @param mAngle - The rotate angle
	 */
	public DJIGimbalRotation(boolean mEnable, boolean mDirection, boolean mType, int mAngle) {
	    super();
	    angle = mAngle;
	    type = mType;
	    direction = mDirection;
	    enable = mEnable;
	}
	
}
