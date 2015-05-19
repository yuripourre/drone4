package dji.sdk.api.Gimbal;

import dji.sdk.api.DJIObject;
import dji.sdk.interfaces.DJIGimbalErrorCallBack;
import dji.sdk.interfaces.DJIGimbalUpdateAttitudeCallBack;

public class DJIGimbal extends DJIObject {

	public static final String TAG = "DJIGimbal";

	/**
	 * Start upate timer
	 * 
	 * @param intervel - Timer run interval
	 * @return success
	 */
	public boolean startUpdateTimer(int intervel) {
		return true;
	}

	/**
	 * Stop upate timer
	 * 
	 * @return success
	 */
	public boolean stopUpdateTimer() {
		return true;
	}

	/**
	 * release gimbal interface
	 */
	public void destroy() {

	}


	/**
	 * Get gimbal max picth angle
	 */

	public int getGimbalPitchMaxAngle() {
		return 360; // Verify
	}

	/**
	 * Get gimbal min picth angle
	 */
	public int getGimbalPitchMinAngle() {
		return 0; // Verify
	}

	/**
	 * Set gimbal follow mode
	 * 
	 * @param isFpv - Set the fpv mode
	 */
	public int setGimbalFpvMode(boolean isFpv) {
		return 0; // Verify
	}

	/**
	 * Update the gimbal angle
	 * 
	 * @param pitch
	 * @param roll
	 * @param yaw
	 */
	public void updateGimbalAttitude(DJIGimbalRotation pitch, DJIGimbalRotation roll,
			DJIGimbalRotation yaw) {

	}

	/**
	 * Set GimbalErrorCallBack
	 * 
	 * @param mCallBack - The gimbal error callBack
	 */
	public void setGimbalErrorCallBack(DJIGimbalErrorCallBack mCallBack) {

	}

	/**
	 * Set GimbalUpdateAttitudeCallBack
	 * 
	 * @param mCallBack - The gimbal update attitude callBack
	 */
	public void setGimbalUpdateAttitudeCallBack(DJIGimbalUpdateAttitudeCallBack mCallBack) {

	}

}
