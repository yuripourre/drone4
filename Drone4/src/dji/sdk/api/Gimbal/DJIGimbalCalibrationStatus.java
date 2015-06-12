package dji.sdk.api.Gimbal;

import dji.sdk.api.Gimbal.DJIGimbalTypeDef.CalibrationResult;
import dji.sdk.api.Gimbal.DJIGimbalTypeDef.GimbalWorkMode;
import dji.sdk.api.Gimbal.DJIGimbalTypeDef.HasReachedMax;
import dji.sdk.api.Gimbal.DJIGimbalTypeDef.InstallationDirection;
import dji.sdk.api.Gimbal.DJIGimbalTypeDef.SelfCalibrationMark;

public class DJIGimbalCalibrationStatus {

	/**
	 * The result of calibration, enum values are failure or success
	 */
	public DJIGimbalTypeDef.CalibrationResult calibrationResult = CalibrationResult.Success;
	
	/**
	 * The installation for the gimbal, such as normal and up-side-down
	 */
	public DJIGimbalTypeDef.InstallationDirection installationDirection = InstallationDirection.Forward;
	
	/**
	 * The mark for reaching the maximum of gimbal.
	 */
	public DJIGimbalTypeDef.HasReachedMax pitchHasReachedMax = HasReachedMax.Not_Yet;
	
	/**
	 * The mark for reaching the maximum of gimbal.
	 */
	public DJIGimbalTypeDef.HasReachedMax rollHasReachedMax = HasReachedMax.Not_Yet;
	
	
	/**
	 * There are two calibaration mark: Not in process and in process.
	 */
	public DJIGimbalTypeDef.SelfCalibrationMark selfCalibrationMark = SelfCalibrationMark.Calibration;
	
	/**
	 * There are three mode for gimbal work mode: Free Mode, FPV and Yaw Follow.
	 */
	public DJIGimbalTypeDef.GimbalWorkMode workMode = GimbalWorkMode.Free_Mode;
	
	/**
	 * The mark for reaching the maximum of gimbal.
	 */
	public DJIGimbalTypeDef.HasReachedMax yawHasReachedMax = HasReachedMax.Not_Yet;

	public DJIGimbalCalibrationStatus(CalibrationResult calibrationResult,
			InstallationDirection installationDirection,
			HasReachedMax pitchHasReachedMax, HasReachedMax rollHasReachedMax,
			SelfCalibrationMark selfCalibrationMark, GimbalWorkMode workMode,
			HasReachedMax yawHasReachedMax) {
		super();
		this.calibrationResult = calibrationResult;
		this.installationDirection = installationDirection;
		this.pitchHasReachedMax = pitchHasReachedMax;
		this.rollHasReachedMax = rollHasReachedMax;
		this.selfCalibrationMark = selfCalibrationMark;
		this.workMode = workMode;
		this.yawHasReachedMax = yawHasReachedMax;
	}
	
}
