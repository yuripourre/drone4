package dji.sdk.api.Camera;

public class DJICameraSettingsTypeDef {

	public static class DJICameraContinuousPhotoParam {
		public int count = 1;
		public int interval = 3;
	}

	public static enum CameraActionWhenBreak {
		Camera_Enter_Contiuous_Shooting, Camera_Enter_Recording, Camera_Keep_Current_State, Camera_Action_Unknown;
	}

	public static enum CameraAntiFlickerType {
		Camera_Anti_Flicker_50Hz, Camera_Anti_Flicker_60Hz, Camera_Anti_Flicker_Auto, Camera_Anti_Flicker_Unknown;
	}

	public static enum CameraCaptureMode {
		Camera_Continous_Capture, //Intentional typo 
		Camera_Multi_Capture,
		Camera_Single_Capture;
	}

	public static enum CameraContrastType {
		Camera_Contrast_Hard,
		Camera_Contrast_Soft,
		Camera_Contrast_Standard,
		Camera_Contrast_Unkown;
	}
	
	public static enum CameraDeletePhotoOperation {
		Delete_Photo_Operation_Unknown,
		Enter_Multiple_Delete_Mode,
		Exit_Multiple_Delete_Mode,
		Multiple_Delete_Confirmed,
		Multiple_Delete_Selected,
		Single_Delete_Confirmed;
	}
	
	public static enum CameraDigitalFilterType {
		Camera_Digital_Filter_Art,
		Camera_Digital_Filter_BlackAndWhite,
		Camera_Digital_Filter_Bright,
		Camera_Digital_Filter_Inverse,
		Camera_Digital_Filter_Movie,
		Camera_Digital_Filter_None,
		Camera_Digital_Filter_Reminiscence,
		Camera_Digital_Filter_Unknown;
	}

	public static enum CameraExposureCompensationType {
		Camera_Exposure_Compensation_Default,
		Camera_Exposure_Compensation_N_0_0,
		Camera_Exposure_Compensation_N_0_3,
		Camera_Exposure_Compensation_N_0_7,
		Camera_Exposure_Compensation_N_1_0,
		Camera_Exposure_Compensation_N_1_3,
		Camera_Exposure_Compensation_N_1_7,
		Camera_Exposure_Compensation_N_2_0,
		Camera_Exposure_Compensation_N_2_3,
		Camera_Exposure_Compensation_N_2_7,
		Camera_Exposure_Compensation_N_3_0,
		Camera_Exposure_Compensation_N_3_3,
		Camera_Exposure_Compensation_N_3_7,
		Camera_Exposure_Compensation_N_4_0,
		Camera_Exposure_Compensation_N_4_3,
		Camera_Exposure_Compensation_N_4_7,
		Camera_Exposure_Compensation_N_5_0,
		Camera_Exposure_Compensation_P_0_3,
		Camera_Exposure_Compensation_P_0_7,
		Camera_Exposure_Compensation_P_1_0,
		Camera_Exposure_Compensation_P_1_3,
		Camera_Exposure_Compensation_P_1_7,
		Camera_Exposure_Compensation_P_2_0,
		Camera_Exposure_Compensation_P_2_3,
		Camera_Exposure_Compensation_P_2_7,
		Camera_Exposure_Compensation_P_3_0,
		Camera_Exposure_Compensation_P_3_3,
		Camera_Exposure_Compensation_P_3_7,
		Camera_Exposure_Compensation_P_4_0,
		Camera_Exposure_Compensation_P_4_3,
		Camera_Exposure_Compensation_P_4_7,
		Camera_Exposure_Compensation_P_5_0,
		Camera_Exposure_Compensation_Unknown;
	}

	public static enum CameraExposureMeteringType {
		Camera_Exposure_Metering_Average,
		Camera_Exposure_Metering_Center,
		Camera_Exposure_Metering_Point,
		Camera_Exposure_Metering_Unknown;
	}

	public static enum CameraFileIndexModeType {
		Camera_File_Index_Mode_Continous,
		Camera_File_Index_Mode_Reset,
		Camera_File_Index_Mode_Unkown; //Intentional typo
	}
	
	public static enum CameraISOType {
		Camera_ISO_100,
		Camera_ISO_12800,
		Camera_ISO_1600,
		Camera_ISO_200,
		Camera_ISO_25600,
		Camera_ISO_3200,
		Camera_ISO_400,
		Camera_ISO_6400,
		Camera_ISO_800,
		Camera_ISO_Auto,
		Camera_ISO_HighSensitive,
		Camera_ISO_LowSensitive,
		Camera_ISO_Unknown;
	}
	
	public static enum CameraMediaFileDeleteStatus {
		Camera_Media_File_Delete_Status_Unknown,
		Media_File_Delete_Failed,
		Media_File_Delete_Successed,
		Media_File_Deleting;
	}
	
	public static enum CameraMediaFileType {
		Camera_Media_File_Type_Unknown,
		Media_File_DNG,
		Media_File_JPEG,
		Media_File_VIDEO;
	}

	public static enum CameraMode {
		Camera_Camera_Mode,
		Camera_Capture_Mode,
		Camera_Download_Mode,
		Camera_PlayBack_Mode,
		Camera_Record_Mode,
		Camera_SavePower_Mode,
		Camera_TransCode_Mode,
		Camera_Tuning_Mode,
		Camera_Unknown_Mode,
		Camera_USB_Mode;
	}

	public static enum CameraMultiShotCount {
		Camera_Multi_Shot_3,
		Camera_Multi_Shot_5,
		Camera_Multi_Shot_Unknown;
	}

	public static enum CameraPhotoFormatType {
		Camera_Photo_Format_Unknown,
		Camera_Photo_JPEG,
		Camera_Photo_RAW,
		Camera_Photo_RAWAndJPEG;
	}
	
	public static enum CameraPhotoQualityType {
		Camera_Photo_Quality_Excellent,
		Camera_Photo_Quality_Fine,
		Camera_Photo_Quality_Normal,
		Camera_Photo_Quality_Unknown;
	}
	
	public static enum CameraPhotoRatioType {
		Camera_Photo_Ratio_16_9,
		Camera_Photo_Ratio_4_3,
		Camera_Photo_Ratio_Unknown;
	}

	public static enum CameraPhotoSizeType {
		Camera_Photo_Size_4384x2466,
		Camera_Photo_Size_4384x2922,
		Camera_Photo_Size_4384x3288,
		Camera_Photo_Size_4608x3456,
		Camera_Photo_Size_Default,
		Camera_Photo_Size_Unknown;
	}

	public static enum CameraPlaybackMode {
		Camera_Playback_Mode_Unknown,
		Media_Files_Download,
		Multiple_Media_Files_Delete,
		Multiple_Media_Files_Display,
		Single_Photo_Playback,
		Single_Photo_ZoomMode,
		Single_Video_Playback_Start,
		Single_Video_Playback_Stop;
	}
	
	//Intentional Typo
	public static enum CameraPreviewResolustionType {
		Resolution_Type_320x240_15fps,
		Resolution_Type_320x240_30fps,
		Resolution_Type_640x480_15fps,
		Resolution_Type_640x480_30fps,
		Resolution_Type_Unkown;
	}

	public static enum CameraRecordingFovType {
		Camera_Recording_FOV_Unknown,
		Camera_Recording_FOV0,
		Camera_Recording_FOV1,
		Camera_Recording_FOV2;
	}

	public static enum CameraRecordingResolutionType {
		Camera_Recording_Resolution_1280x720_30p,
		Camera_Recording_Resolution_1280x720_60p,
		Camera_Recording_Resolution_1280x960_25p,
		Camera_Recording_Resolution_1280x960_30p,
		Camera_Recording_Resolution_1920x1080_25p,
		Camera_Recording_Resolution_1920x1080_30p,
		Camera_Recording_Resolution_1920x1080_60p,
		Camera_Recording_Resolution_640x480_30p,
		Camera_Recording_Resolution_Default,
		Camera_Recording_Resolution_Unknown;
	}

	public static enum CameraSharpnessType {
		Camera_Sharpness_Hard,
		Camera_Sharpness_Soft,
		Camera_Sharpness_Standard,
		Camera_Sharpness_Unknown;
	}

	public static enum CameraVideoFrameRate {
		Camera_Video_Frame_Rate_24fps,
		Camera_Video_Frame_Rate_25fps,
		Camera_Video_Frame_Rate_30fps,
		Camera_Video_Frame_Rate_48fps,
		Camera_Video_Frame_Rate_50fps,
		Camera_Video_Frame_Rate_60fps,
		Camera_Video_Frame_Rate_Unknown;
	}
	
	public static enum CameraVideoPlaybackOperation {
		Camera_Video_Playback_FastBackward,
		Camera_Video_Playback_FastForward,
		Camera_Video_Playback_Locate,
		Camera_Video_Playback_Start,
		Camera_Video_Playback_Stop,
		Camera_Video_Playback_Unknown;
	}
	
	public static enum CameraVideoQuality {
		Camera_Video_Quality_Excellent,
		Camera_Video_Quality_Fine,
		Camera_Video_Quality_Normal,
		Camera_Video_Quality_Unknown;
	}
	
	public static enum CameraVideoResolution {
		Camera_Video_Resolution_1280x720p,
		Camera_Video_Resolution_1920x1080p,
		Camera_Video_Resolution_3840x2160p,
		Camera_Video_Resolution_Unknown;
	}
	
	public static enum CameraVideoStandard {
		Camera_Video_Standard_NTSC,
		Camera_Video_Standard_PAL,
		Camera_Video_Standard_Unknown;
	}
	
	public static enum CameraVideoStorageFormat {
		Camera_Video_Storage_Format_MOV,
		Camera_Video_Storage_Format_MP4,
		Camera_Video_Storage_Format_Unknown;
	}
	
	public static enum CameraVisionType {
		Camera_Type_Inspire,
		Camera_Type_Null,
		Camera_Type_Plus,
		Camera_Type_Vision;
	}

	public static enum CameraWhiteBalanceType {
		Camera_White_Balance_Auto,
		Camera_White_Balance_Cloudy,
		Camera_White_Balance_Indoor,
		Camera_White_Balance_Indoor_Fluorescent,
		Camera_White_Balance_Indoor_Incandescent,
		Camera_White_Balance_Sunny,
		Camera_White_Balance_Unknown,
		Camera_White_Balance_Water_Suface;
	}
	
	public static enum CameraWorkMode {
		Camera_Work_Mode_Capture,
		Camera_Work_Mode_Download,
		Camera_Work_Mode_Playback,
		Camera_Work_Mode_PowerSave,
		Camera_Work_Mode_Record,
		Camera_Work_Mode_Transcode,
		Camera_Work_Mode_Tuning,
		Camera_Work_Mode_Unknown,
	}
}
