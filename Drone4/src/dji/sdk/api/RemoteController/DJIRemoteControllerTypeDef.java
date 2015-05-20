package dji.sdk.api.RemoteController;

public class DJIRemoteControllerTypeDef {

	public enum ControlModeFunction {
		None, Pitch, Roll, Yaw, Unknown;
	}
	
	public enum DJIRemoteControllerCalibrationStatus {
		/**
		 * Exit Calibration
		 */
		Exit_Calibration,

		/**
		 * Normal
		 */		
		Normal, 
		
		/**
		 * Calibration records the extremum value.
		 */
		Record_extremum,
		
		/**
		 * Calibration records the mid value
		 */
		Record_Mid_val,
		
		Unknown;
	}
	
	public enum DJIRemoteControllerChannelType {
		/**
		 * aileron
		 */
		A,
		/**
		 * elevator
		 */
		E, 
		/**
		 * 无
		 */
		None, 
		/**
		 * 其他
		 */
		OTHER, 
		/**
		 * rudder
		 */
		R, 
		/**
		 * throttle
		 */
		T;
	}
	
	public enum DJIRemoteControllerConnectMasterResult {
		Master_Refuse_Join,
		Number_of_Slave_Limit,
		Overtime,
		Success,
		Unknown,
		Wrong_Password;
	}
	
	public enum DJIRemoteControllerControlMode {
		America,
		China,
		/**
		 * If you set up the customer define mode, please remember that set up the value for each channel.
		 */
		Custom,
		Japan,
		Unknown;
	}
	
	public enum DJIRemoteControllerType {
		Listener,
		/**
		 * The Master
		 */
		Master,		
		
		/**
		 * Slave which should be assigned permission
		 */
		Salve, //Intentional typo
		Unknown;
	}
}
