package dji.sdk.api.Camera;

public class DJICameraSettingsTypeDef {

	public static class DJICameraContinuousPhotoParam {
		public int count = 1;
		public int interval = 3;
	}

	public enum CameraActionWhenBreak {
		Camera_Enter_Contiuous_Shooting, Camera_Enter_Recording, Camera_Keep_Current_State;
	}

	public enum CameraAntiFlickerType {
		Camera_Anti_Flicker_50Hz, Camera_Anti_Flicker_60Hz, Camera_Anti_Flicker_Auto;
	}

	public enum CameraCaptureMode {
		Camera_Continous_Capture, Camera_Multi_Capture, Camera_Single_Capture;
	}

	public enum CameraContrastType {
		Camera_Contrast_Hard, Camera_Contrast_Soft, Camera_Contrast_Standard;
	}

	public enum CameraExposureCompensationType {
		Camera_Exposure_Compensation_Default, Camera_Exposure_Compensation_N_0_0, Camera_Exposure_Compensation_N_0_3, Camera_Exposure_Compensation_N_0_7, Camera_Exposure_Compensation_N_1_0, Camera_Exposure_Compensation_N_1_3, Camera_Exposure_Compensation_N_1_7, Camera_Exposure_Compensation_N_2_0, Camera_Exposure_Compensation_P_0_3, Camera_Exposure_Compensation_P_0_7, Camera_Exposure_Compensation_P_1_0, Camera_Exposure_Compensation_P_1_3, Camera_Exposure_Compensation_P_1_7, Camera_Exposure_Compensation_P_2_0;
	}

	public enum CameraExposureMeteringType {
		Camera_Exposure_Metering_Average, Camera_Exposure_Metering_Center, Camera_Exposure_Metering_Point;
	}

	public enum CameraISOType {
		Camera_ISO_100, Camera_ISO_1600, Camera_ISO_200, Camera_ISO_3200, Camera_ISO_400, Camera_ISO_800, Camera_ISO_Auto;
	}

	public enum CameraMode {
		Camera_Camera_Mode, Camera_Unknown_Mode, Camera_USB_Mode;
	}

	public enum CameraMultiShotCount {
		Camera_Multi_Shot_3, Camera_Multi_Shot_5;
	}

	public enum CameraPhotoFormatType {
		Camera_Photo_JPEG, Camera_Photo_RAW;
	}

	public enum CameraPhotoSizeType {
		Camera_Photo_Size_4384x2466, Camera_Photo_Size_4384x2922, Camera_Photo_Size_4384x3288, Camera_Photo_Size_4608x3456, Camera_Photo_Size_Default;
	}

	public enum CameraPreviewResolustionType {
		Resolution_Type_320x240_15fps, Resolution_Type_320x240_30fps, Resolution_Type_640x480_15fps, Resolution_Type_640x480_30fps;
	}

	public enum CameraRecordingFovType {
		Camera_Recording_FOV0, Camera_Recording_FOV1, Camera_Recording_FOV2;
	}

	public enum CameraRecordingResolutionType {
		Camera_Recording_Resolution_1280x720_30p, Camera_Recording_Resolution_1280x720_60p, Camera_Recording_Resolution_1280x960_30p, Camera_Recording_Resolution_1920x1080_30p, Camera_Recording_Resolution_1920x1080_60i, Camera_Recording_Resolution_640x480_30p, Camera_Recording_Resolution_Default;
	}

	public enum CameraSharpnessType {
		Camera_Sharpness_Hard, Camera_Sharpness_Soft, Camera_Sharpness_Standard;
	}

	public enum CameraVisionType {
		Camera_Type_Plus, Camera_Type_Vision;
	}

	public enum CameraWhiteBalanceType {
		Camera_White_Balance_Auto, Camera_White_Balance_Cloudy, Camera_White_Balance_Indoor, Camera_White_Balance_Sunny;
	}
}
