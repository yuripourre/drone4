package dji.sdk.api.GroundStation;

public class DJIGroundStationTypeDef {

	public enum GroundStationCancelResult {
		GS_Cancel_Began,
		GS_Cancel_Gps_Not_Ready,
		GS_Cancel_Moto_Not_Start,
		GS_Cancel_Successed,
		GS_Cancel_Timeout,
		GS_Cancel_Unknown;
	}

	public enum GroundStationControlMode {
		GS_Mode_Atti,
		GS_Mode_Gohome,
		GS_Mode_Gps_Atti,
		GS_Mode_Gps_Cruise,
		GS_Mode_Landing,
		GS_Mode_Manual,
		GS_Mode_Pause_1,
		GS_Mode_Pause_2,
		GS_Mode_Single,
		GS_Mode_TakeOff,
		GS_Mode_Unknown,
		GS_Mode_Waypoint;
	}

	public enum GroundStationGoHomeResult {
		GS_GoHome_Began,
		GS_GoHome_Gps_Not_Ready,
		GS_GoHome_Successed,
		GS_GoHome_Timeout,
		GS_GoHome_Unknown;
	}

	public enum GroundStationGpsStatus {
		GS_GPS_Excellent,
		GS_GPS_Good,
		GS_GPS_Unknown,
		GS_GPS_Weak;
	}
	
	public enum GroundStationHoverResult {
		GS_Hover_Began,
		GS_Hover_Gps_Not_Ready,
		GS_Hover_Moto_Not_Start,
		GS_Hover_Successed,
		GS_Hover_Timeout,
		GS_Hover_Unknown;
	}
	
	public enum GroundStationOneKeyFlyResult {
		GS_One_Key_Fly_Began,
		GS_One_Key_Fly_Gps_Not_Ready,
		GS_One_Key_Fly_IsFlying,
		GS_One_Key_Fly_Not_Auto_Mode,
		GS_One_Key_Fly_Successed,
		GS_One_Key_Fly_Takeoff;
	}
	
	public enum GroundStationResult {
		GS_Result_Began,
		GS_Result_Canceled,
		GS_Result_Failed,
		GS_Result_Successed,
		GS_Result_Timeout,
		GS_Result_Unknown;
	}
	
	public enum GroundStationResumeResult {
		GS_Resume_Began,
		GS_Resume_Gps_Not_Ready,
		GS_Resume_Successed,
		GS_Resume_Timeout,
		GS_Resume_Unknown;
	}
	
	public enum GroundStationTakeOffResult {
		GS_Takeoff_Began,
		GS_Takeoff_Gps_Not_Ready,
		GS_Takeoff_Mode_Error,
		GS_Takeoff_Successed,
		GS_Takeoff_Timeout,
		GS_Takeoff_Unknown;
	}

}
