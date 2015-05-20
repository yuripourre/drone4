package dji.sdk.api.Gimbal;

public class DJIGimbalCapacity {
	/**
	 * On a basis of the drone type, the maxPitchRotationAngle would reflect the maximum of the rotation angle for pitching.
	 */
	public float maxPitchRotationAngle;
	
	/**
	 * On a basis of the drone type, the maxRollRotationAngle would reflect the maximum of the rotation angle for rolling.
	 */
	public float maxRollRotationAngle;
	
	/**
	 * On a basis of the drone type, the maxYawRotationAngle would reflect the maximum of the rotation angle for yawing.
	 */
	public float maxYawRotationAngle;
	
	/**
	 * On a basis of the drone type, the minPitchRotationAngle would reflect the minimum of the rotation angle for pitching.
	 */
	public float minPitchRotationAngle;
	
	/**
	 * On a basis of the drone type, the minRollRotationAngle would reflect the minimum of the rotation angle for rolling.
	 */
	public float minRollRotationAngle;
	
	/**
	 * On a basis of the drone type, the minYawRotationAngle would reflect the minimum of the rotation angle for rolling.
	 */
	public float minYawRotationAngle;
	
	/**
	 * The variable of pitchAvailable would reflect whether the gimbal could pitch.
	 */
	public boolean pitchAvailable;
	
	/**
	 * The variable of rollAvailable would reflect whether the gimbal could roll.
	 */
	public boolean rollAvailable;
	
	/**
	 * The variable of yawAvailable would reflect whether the gimbal could yaw.
	 */
	public boolean yawAvailable;
	
}
