package dji.sdk.api.Camera;

import dji.sdk.api.DJIObject;
import dji.sdk.api.media.DJIMedia;
import dji.sdk.interfaces.DJICameraSdCardInfoCallBack;
import dji.sdk.interfaces.DJICameraSystemStateCallBack;
import dji.sdk.interfaces.DJIExecuteResultCallback;
import dji.sdk.interfaces.DJIMediaFetchCallBack;
import dji.sdk.interfaces.DJIReceivedFileDataCallBack;
import dji.sdk.interfaces.DJIReceivedVideoDataCallBack;
import dji.sdk.util.DjiLocationCoordinate2D;

public class DJICamera extends DJIObject {
	
	public static java.lang.String TAG = "DJICamera";
	
	
	/**
	 * Release djicamera
	 */
	public void destory() {
		
	}	
	
	/**
	 * Get media file data
	 * @param mDjiMedia
	 * @param mCall
	 */
	public void fetchMediaData(DJIMedia mDjiMedia, DJIReceivedFileDataCallBack mCall) {
		
	}
	
	/**
	 * Get sdcard media list
	 * @param mCall
	 */
	public void fetchMediaList(DJIMediaFetchCallBack mCall) {
		
	}
	
	/**
	 * Get media thumbnail bitmap
	 * @param mDjiMedia
	 * @param mCall
	 */
	public void fetchMediaThumbnail(DJIMedia mDjiMedia, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Format camera sdcard
	 * @param mCall
	 */
	public void formatSDCard(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera action when connection broken 
	 * @param mCall
	 */
	public void getCameraActionWhenConnectionBroken(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera antiflicker
	 * @param mCall
	 */
	public void getCameraAntiFlicker(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera connection is ok or not.
	 * @return
	 */
	public boolean getCameraConnectIsOk() {
		return true;
	}
	
	/**
	 * Get camera contrast
	 * @param mCall
	 */
	public void getCameraContrast(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera exposure compenstation 
	 * @param mCall
	 */
	public void getCameraExposureCompensation(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera exposure metering
	 * @param mCall
	 */
	public void getCameraExposureMetering(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera gps
	 * @param mCall
	 */
	public void getCameraGps(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera iso
	 * @param mCall
	 */
	public void getCameraISO(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera taking photo file format(raw or jpeg)
	 * @param mCall
	 */
	public void getCameraPhotoFormat(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera taking photo size
	 * @param mCall
	 */
	public void getCameraPhotoSize(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera recording param(resulotion&fov)
	 * @param mCall
	 */
	public void getCameraRecordingParam(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera sharpness
	 * @param mCall
	 */
	public void getCameraSharpness(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get the camera version
	 * @return
	 */
	public java.lang.String getCameraVersion() {
		return "3.0";
	}
	
	/**
	 * Get camera white balance
	 * @param mCall
	 */
	public void getCameraWhiteBalance(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera continuous taking photo param
	 * @param mCall
	 */
	public void getContinuousPhotoParam(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera property
	 * @return
	 */
	public DJICameraProperty getDjiCameraProperty() {
		return null;
	}
	
	/**
	 * Get camera multi taking photo count
	 * @param mCall
	 */
	public void getMutiPhotoCount(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Get camera type
	 * @return
	 */
	public DJICameraSettingsTypeDef.CameraVisionType getVisionType() {
		return DJICameraSettingsTypeDef.CameraVisionType.Camera_Type_Plus;
	}
	
	/**
	 * Native Recevie Video Data Callback Function
	 * @param videoBuffer
	 * @param size
	 */
	public static void onVideoRecv(byte[] videoBuffer, int size) {
		
	}
	
	/**
	 * Reset camera setting to default
	 * @param mCall
	 */
	public void restoreCameraDefaultSettings(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Save camera setting config
	 * @param mCall
	 */
	public void saveCameraConfig(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera action when connection broken
	 * @param action
	 * @param mCall
	 */
	public void setCameraActionWhenConnectionBroken(DJICameraSettingsTypeDef.CameraActionWhenBreak action, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera antiflicker
	 * @param antiFlickerType
	 * @param mCall
	 */
	public void setCameraAntiFlicker(DJICameraSettingsTypeDef.CameraAntiFlickerType antiFlickerType, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera contrast
	 * @param contrast
	 * @param mCall
	 */
	public void setCameraContrast(DJICameraSettingsTypeDef.CameraContrastType contrast, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera exposure compenstation
	 * @param compensationType
	 * @param mCall
	 */
	public void setCameraExposureCompensation(DJICameraSettingsTypeDef.CameraExposureCompensationType compensationType, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera exposure metering
	 * @param meteringType
	 * @param mCall
	 */
	public void setCameraExposureMetering(DJICameraSettingsTypeDef.CameraExposureMeteringType meteringType, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera file prefix
	 * @param mPrefix
	 * @param mCall
	 */
	public void setCameraFilePrefix(java.lang.String mPrefix, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera gps
	 * @param gps
	 * @param mCall
	 */
	public void setCameraGps(DjiLocationCoordinate2D gps, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera iso
	 * @param isoType
	 * @param mCall
	 */
	public void setCameraISO(DJICameraSettingsTypeDef.CameraISOType isoType, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera mode
	 * @param mode
	 * @param mCall
	 */
	public void setCameraMode(DJICameraSettingsTypeDef.CameraMode mode, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera taking photo file format
	 * @param photoFormat
	 * @param mCall
	 */
	public void setCameraPhotoFormat(DJICameraSettingsTypeDef.CameraPhotoFormatType photoFormat, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera taking photo size
	 * @param photoSize
	 * @param mCall
	 */
	public void setCameraPhotoSize(DJICameraSettingsTypeDef.CameraPhotoSizeType photoSize, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera recording parameter
	 * @param resolution
	 * @param fov
	 * @param mCall
	 */
	public void setCameraRecordingParam(DJICameraSettingsTypeDef.CameraRecordingResolutionType resolution, DJICameraSettingsTypeDef.CameraRecordingFovType fov, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera sharpness
	 * @param sharpness
	 * @param mCall
	 */
	public void setCameraSharpness(DJICameraSettingsTypeDef.CameraSharpnessType sharpness, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera white balance
	 * @param whiteBalance
	 * @param mCall
	 */
	public void setCameraWhiteBalance(DJICameraSettingsTypeDef.CameraWhiteBalanceType whiteBalance, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera continuous taking photo param
	 * @param count
	 * @param interval
	 * @param mCall
	 */
	public void setContinuousPhotoParam(int count, int interval, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set camera system state callbak
	 * @param mCameraSdcardInfoCB
	 */
	public void setDjiCameraSdcardInfoCallBack(DJICameraSdCardInfoCallBack mCameraSdcardInfoCB) {
		
	}
	
	/**
	 * Set camera system state callbak
	 * @param mDjiCameraSystemStateCallBack
	 */
	public void setDjiCameraSystemStateCallBack(DJICameraSystemStateCallBack mDjiCameraSystemStateCallBack) {
		
	}
	
	/**
	 * Set camera multi taking photo count
	 * @param count
	 * @param mCall
	 */
	public void setMutiPhotoCount(DJICameraSettingsTypeDef.CameraMultiShotCount count, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set receive video data call back
	 * @param mReceivedVideoDataCallBack
	 */
	public void setReceivedVideoDataCallBack(DJIReceivedVideoDataCallBack mReceivedVideoDataCallBack) {
		
	}
	
	/**
	 * Start record
	 * @param mCall
	 */
	public void startRecord(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Start taking photo
	 * @param mCall
	 */
	public void startTakePhoto(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Start upate timer
	 * @param intervel
	 * @return
	 */
	public boolean startUpdateTimer(int intervel) {
		return true;
	}
	
	/**
	 * Stop record
	 * @param mCall
	 */
	public void stopRecord(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Stop taking photo
	 * @param mCall
	 */
	public void stopTakePhoto(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Stop upate timer
	 * @return
	 */
	public boolean stopUpdateTimer() {
		return true;
	}
	
	/**
	 * Sync camera time
	 * @param mCall
	 */
	public void syncTime(DJIExecuteResultCallback mCall) {
		
	}
	
}
