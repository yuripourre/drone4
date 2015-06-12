package dji.sdk.api.Gimbal;

public class DJIGimbalTypeDef {

	/**
	 *  This will reflect the result of last calibration.
	 */
	public static enum CalibrationResult {
		Failure,
		Success;
	}
	
	/**
	 * The command id is relative to the gimbal customer params setting. The customer could use it in the DJIGimbalCustomerParamsCommand to specifically invoke a setting command
	 */
	public static enum CommandId {
		Pitch_Action_Params,
		Pitch_Sensitivity,
		Roll_Action_Params,
		Roll_Sensitivity,
		Yaw_Action_Params,
		Yaw_Sensitivity;
	}
	
	/**
	 * To determine whether gimbal is on work or not.
	 */
	public static enum GimbalSwitch {
		Resume,
		Stop;
	}
	
	/**
	 * This enum will determine which kind of work mode the gimbal will use.
	 */
	public static enum GimbalWorkMode {
		Fpv,
		Free_Mode,
		Yaw_Follow;
	}
	
	/**
	 * The enum is used to classify whether the calibration in specific direction finishes or not.
	 */
	public static enum HasReachedMax {
		Not_Yet,
		Reached;
	}
	
	/**
	 * The gimbal install in which kind of direction.
	 */
	public static enum InstallationDirection {
		Forward,
		Overturn;
	}
	
	/**
	 * The enum is used to classify whether the calibration is in process or not.
	 */
	public static enum SelfCalibrationMark {
		Calibration,
		Not_Yet;
	}

}
