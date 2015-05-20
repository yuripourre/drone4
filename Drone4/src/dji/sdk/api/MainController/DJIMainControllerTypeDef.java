package dji.sdk.api.MainController;

public class DJIMainControllerTypeDef {
	
	public static enum DJIMcDeformMode {
		/**
		 * Normal Mode
		 */
		Normal_Mode,
		
		/**
		 * Other
		 */
		Other,
		
		/**
		 * Pack Mode
		 */
		Pack_Mode,
		
		/**
		 * Protect Mode
		 */
		Protect_Mode;
	}
	
	public static enum DJIMcDeformStatus {
		/**
		 * Description : Deformation Stopped State
		 */
		Deformation_Stopped_State,
		
		/**
		 * Description : Fold Complete State
		 */
		Fold_Complete_State,
		
		/**
		 * Description : Folding State
		 */
		Folding_State,
		
		/**
		 * Description : Other
		 */
		Other,
		
		/**
		 * Description : Stretch Complete State
		 */
		Stretch_Complete_State,
		
		/**
		 * Description : Stretching State
		 */
		Stretching_State,
		
		/**
		 * Description : Unknown State
		 */
		Unkown_State; //Intentional Typo
	}
	
	public static enum DJIMCUErrorType {
		Mc_Compass_Calibration_Error,
		Mc_Compass_Error,
		Mc_Config_Error,
		Mc_Imu_Calibration_Error,
		Mc_Imu_Error,
		Mc_Invalid_Battery_Communication_Error,
		Mc_Invalid_Battery_Error,
		Mc_Low_Battery_Error,
		Mc_No_Error,
		Mc_Pmu_Error,
		Mc_Sensor_Error,
		Mc_SerialNum_Error,
		Mc_Servious_Battery_Error,
		Mc_Transmitter_Calibration_Error,
		Mc_Transmitter_Error,
		Mc_Unkown_Error,
		Mc_X1_Error,
		Mc_X2_Error; 
	}
	
	public static enum DJIMcFunctionType {
		/**
		 * Compass Calibration
		 */
		Compass_Calibration,
		
		/**
		 * CurPosition As HomePonit
		 */
		CurPosition_As_HomePonit, //Intentional typo
		
		/**
		 * CurPosition As HotPoint
		 */
		CurPosition_As_HotPoint,
		
		/**
		 * Disable Deform Protect
		 */
		Disable_Deform_Protect,
		
		/**
		 * Disable Dynamic HomePoint
		 */
		Disable_Dynamic_HomePoint,
		
		/**
		 * Disable Follow Function
		 */
		Disable_Follow_Function,
		
		/**
		 * Disable IOC
		 */
		Disable_IOC,
		
		/**
		 * Enable Deform Protect
		 */
		Enable_Deform_Protect,
		
		/**
		 * Enable Dynamic HomePoint
		 */
		Enable_Dynamic_HomePoint,
		
		/**
		 * Enable Follow Function
		 */
		Enable_Follow_Function,
		
		/**
		 * Enable IOC
		 */
		Enable_IOC,
		
		/**
		 * Enter Pack Mode
		 */
		Enter_Pack_Mode,
		
		/**
		 * Exit Auto Landing
		 */
		Exit_Auto_Landing,
		
		/**
		 * Exit Auto TakeOff
		 */
		Exit_Auto_TakeOff,
		
		/**
		 * Exit Compass Calibration
		 */
		Exit_Compass_Calibration,
		
		/**
		 * Exit Go home
		 */
		Exit_Gohome,

		/**
		 * Exit Pack Mode
		 */
		Exit_Pack_Mode,
		
		/**
		 * Go Home
		 */
		Go_Home,
		
		/**
		 * Lock Course
		 */
		Lock_Course,
		
		/**
		 * One Key Fly
		 */
		One_Key_Fly,
		
		/**
		 * One Key Landing
		 */
		One_Key_Landing,
		
		/**
		 * Other
		 */
		Other,
		
		/**
		 * Start Motor
		 */
		Start_Motor,
		
		/**
		 * Stop Motor
		 */
		Stop_Motor;
	}

	public static enum DJIMcIocType {
		/**
		 * Course Lock
		 */
		Course_Lock,
		
		/**
		 * Homepoint Lock
		 */
		Homepoint_Lock,
		
		/**
		 * Hotpoint Surround
		 */
		Hotpoint_Surround,
		
		/**
		 * Other
		 */
		Other;
	}
	
	public static enum DJIPhantomType {
		DJI_Phantom2Vision,
		Unknown;
	}
}
