package dji.sdk.api.GroundStation;

public class DJIGroundStationTypeDef {

	/**
	 * This enum will determine which kind of action the drone will take while the ground station finished.
	 */
	public static enum DJIGroundStationFinishAction {
		/**
		 * Back to first way point
		 */
		Back_To_First_Way_Point,		
		
		/**
		 * Back to the home point
		 */
		Go_Home,		
		
		/**
		 * Land directly.
		 */
		Land,
		
		/**
		 * Nothing will happen.
		 */
		None;
	}
	
	/**
	 * This enum will determine the direction while the drone executes the flight.
	 */
	public static enum DJIGroundStationMovingMode {
		/**
		 * Point to next way point.
		 */
		Auto,	
		
		/**
		 * Initial value
		 */
		Init,
		
		/**
		 * Use the direction provided by the way point.
		 */
		On_The_Basis_Of_Way_Point,
		
		/**
		 * The customer could use remote control for controlling the drone's heading.
		 */
		Remote_Control;
	}
	
	/**
	 * This enum reflects the path mode
	 */
	public static enum DJIGroundStationPathMode {
		/**
		 * Point to Point.
		 */
		Point_To_Point;
	}
	
	/**
	 * DJINavigationFlightControlCoordinateSystem
	 */
	public static enum DJINavigationFlightControlCoordinateSystem {
		/**
		 * Body coordinate system
		 */
		Navigation_Flight_Control_Coordinate_System_Body,
		
		/**
		 * Ground coordinate system
		 */
		Navigation_Flight_Control_Coordinate_System_Ground;
	}
	
	/**
	 * Flight control horizontal control mode, will affect the mPitch and mRoll of DJINavigationFlightControlData
	 */
	public static enum DJINavigationFlightControlHorizontalControlMode {
		/**
		 * Horizontal control angle.
		 */
		Navigation_Flight_Control_Horizontal_Control_Angle,
		
		/**
		 * Horizontal control position.
		 */
		Navigation_Flight_Control_Horizontal_Control_Position,
		
		/**
		 * Horizontal control velocity.
		 */
		Navigation_Flight_Control_Horizontal_Control_Velocity;
	}
	
	/**
	 * Flight control's coordinate system
	 */
	public static enum DJINavigationFlightControlVerticalControlMode {
		/**
		 * Vertical control position.
		 */
		Navigation_Flight_Control_Vertical_Control_Position,

		/**
		 * Vertical control throttle.
		 */
		Navigation_Flight_Control_Vertical_Control_Throttle,

		/**
		 * Vertical control velocity.
		 */
		Navigation_Flight_Control_Vertical_Control_Velocity;
	}
	
	/**
	 * Flight control yaw control mode, will affect the mYaw of DJINavigationFlightControlData
	 */
	public static enum DJINavigationFlightControlYawControlMode {
		/**
		 * Yaw control angle, mYaw in range [-180, 180] degree
		 */
		Navigation_Flight_Control_Yaw_Control_Angle,
		
		/**
		 * Yaw control palstance.
		 */
		Navigation_Flight_Control_Yaw_Control_Palstance;
	}
	
	/**
	 * Ground Station Cancel Result Type Define
	 */
	public static enum GroundStationCancelResult {
		GS_Cancel_Began,
		GS_Cancel_Gps_Not_Ready,
		GS_Cancel_Moto_Not_Start,
		GS_Cancel_Successed,
		GS_Cancel_Timeout,
		GS_Cancel_Unknown;
	}
	
	public static enum GroundStationExecutionPushType {
		Navi_Mission_Finish,
		Navi_Mission_WayPoint_Reach_Point,
		Navi_Upload_Finish;
	}
	
	/**
	 * Ground Station Control Mode Type Define
	 */
	public static enum GroundStationFlightMode {
		GS_Mode_Assited_Takeoff,
		GS_Mode_Atti,
		GS_Mode_Atti_CL,
		GS_Mode_Atti_Hover,
		GS_Mode_Atti_Landing,
		GS_Mode_Atti_Limited,
		GS_Mode_Auto_Takeoff,
		GS_Mode_Blake,
		GS_Mode_Click_Go,
		GS_Mode_Gohome,
		GS_Mode_Gps_Atti,
		GS_Mode_GPS_Atti_Limited,
		GS_Mode_GPS_CL,
		GS_Mode_Gps_Cruise,
		GS_Mode_Home_Lock,
		GS_Mode_Hot_Point,
		GS_Mode_Hover,
		GS_Mode_Joystick,
		GS_Mode_Landing,
		GS_Mode_Manual,
		GS_Mode_Navi_Go,
		GS_Mode_Pause_1,
		GS_Mode_Pause_2,
		GS_Mode_Single,
		GS_Mode_TakeOff,
		GS_Mode_Unknown,
		GS_Mode_Waypoint;
	}
	
	public static enum GroundStationFollowMeMode {
		Default;
	}
	
	public static enum GroundStationFollowMeNavigationDirection {
		Point_To_Customer,
		Remote_Control;
	}

	public static enum GroundStationGoHomeResult {
		GS_GoHome_Began,
		GS_GoHome_Gps_Not_Ready,
		GS_GoHome_Successed,
		GS_GoHome_Timeout, 
		GS_GoHome_Unknown;
	}

	public static enum GroundStationGpsStatus {
		GS_GPS_Excellent,
		GS_GPS_Good,
		GS_GPS_Unknown,
		GS_GPS_Weak;
	}
	
	public static enum GroundStationStatusPushType {
		Navi_Mode_Attitude,
		Navi_Mode_FollowMe,
		Navi_Mode_Hotpoint,
		Navi_Mode_Waypoint;
	}

	public static enum GroundStationHoverResult {
		GS_Hover_Began, GS_Hover_Gps_Not_Ready, GS_Hover_Moto_Not_Start, GS_Hover_Successed, GS_Hover_Timeout, GS_Hover_Unknown;
	}

	public static enum GroundStationOneKeyFlyResult {
		GS_One_Key_Fly_Began, GS_One_Key_Fly_Gps_Not_Ready, GS_One_Key_Fly_IsFlying, GS_One_Key_Fly_Not_Auto_Mode, GS_One_Key_Fly_Successed, GS_One_Key_Fly_Takeoff;
	}

	public static enum GroundStationResult {
		GS_Result_Began, GS_Result_Canceled, GS_Result_Failed, GS_Result_Successed, GS_Result_Timeout, GS_Result_Unknown;
	}

	public static enum GroundStationResumeResult {
		GS_Resume_Began, GS_Resume_Gps_Not_Ready, GS_Resume_Successed, GS_Resume_Timeout, GS_Resume_Unknown;
	}

	public static enum GroundStationTakeOffResult {
		GS_Takeoff_Began, GS_Takeoff_Gps_Not_Ready, GS_Takeoff_Mode_Error, GS_Takeoff_Successed, GS_Takeoff_Timeout, GS_Takeoff_Unknown;
	}

}
