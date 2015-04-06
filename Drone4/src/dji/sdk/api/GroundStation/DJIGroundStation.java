package dji.sdk.api.GroundStation;

import dji.sdk.interfaces.DJIGroundStationExecutCallBack;
import dji.sdk.interfaces.DJIGroundStationFlyingInfoCallBack;
import dji.sdk.interfaces.DJIGroundStationGoHomeCallBack;
import dji.sdk.interfaces.DJIGroundStationHoverCallBack;
import dji.sdk.interfaces.DJIGroundStationOneKeyFlyCallBack;
import dji.sdk.interfaces.DJIGroundStationResumeCallBack;
import dji.sdk.interfaces.DJIGroundStationTakeOffCallBack;

public class DJIGroundStation {

	private DJIGroundStationTask task = new DJIGroundStationTask();
	
	private DJIGroundStationFlyingInfoCallBack groundStationFlyingInfoCallBack;
	
	/**
	 * Start upate timer
	 * @param intervel - Timer run interval
	 * @return 
	 */
	public boolean startUpdateTimer(int intervel) {
		return true;
	}

	/**
	 * Stop upate timer
	 * @return success
	 */
	public boolean stopUpdateTimer() {
		return true;
	}

	/**
	 * release ground station interface
	 */
	public void destroy() {

	}

	/**
	 * Open ground station
	 * @param mCallBack - The ground station execute callBack
	 */
	public void openGroundStation(DJIGroundStationExecutCallBack mCallBack) {

	}

	/**
	 * Close ground station
	 * @param mCallBack - The ground station execute callBack
	 */
	public void closeGroundStation(DJIGroundStationExecutCallBack mCallBack) {

	}

	/**
	 * Upload ground station task
	 * @param task - The ground station task
	 * @param mCallBack - The ground station execute callBack
	 */
	public void uploadGroundStationTask(DJIGroundStationTask task, DJIGroundStationExecutCallBack mCallBack) {

	}

	/**
	 * Download ground station task
	 * @param mCallBack - The ground station execute callBack
	 */
	public void downloadGroundStationTask(DJIGroundStationExecutCallBack mCallBack) {

	}

	/**
	 * Start ground station task 
	 * @param mCallBack - The ground station take off callBack
	 */
	public void startGroundStationTask(DJIGroundStationTakeOffCallBack mCallBack) {

	}

	/**
	 * Pause ground station task
	 * @param mCallBack - The ground station take off callBack
	 */

	public void pauseGroundStationTask(DJIGroundStationHoverCallBack mCallBack) {

	}

	/**
	 * One key fly
	 * @param mCallBack - The ground station hover callBack
	 */
	public void onKeyFly(DJIGroundStationOneKeyFlyCallBack mCallBack) {

	}



	/**
	 * Continue ground station task
	 * @param mCallBack - The ground station resume callBack
	 */
	public void continueGroundStationTask(DJIGroundStationResumeCallBack mCallBack) {

	}


	/**
	 * Go home
	 * @param mCallBack - The ground station go home callBack
	 */
	public void goHome(DJIGroundStationGoHomeCallBack mCallBack) {

	}
	/**
	 * setAircraftYawSpeed
	 * @param yawSpeed - Aircraft yaw rotate speed[-1000 ~ 1000]
	 * @param mCallBack - The ground station execute callBack
	 */
	public void setAircraftYawSpeed(int yawSpeed,
			DJIGroundStationExecutCallBack mCallBack) {

	}


	/**
	 * Set Aircraft Pitch Rotate Speed
	 * @param pitchSpeed - Aircraft pitch rotate speed[-1000 ~ 1000]
	 * @param mCallBack - The ground station execute callBack
	 */

	public void setAircraftPitchSpeed(int pitchSpeed,
			DJIGroundStationExecutCallBack mCallBack) {

	}

	/**
	 * Set Aircraft Roll Rotate Speed
	 * @param rollSpeed - Aircraft roll rotate speed[-1000 ~ 1000]
	 * @param mCallBack - The ground station execute callBack
	 */

	public void setAircraftRollSpeed(int rollSpeed,
			DJIGroundStationExecutCallBack mCallBack) {

	}

	/**
	 * Set Aircraft Roll Rotate Speed
	 * @param throttle - Aircraft roll rotate speed[0 stop,1 up, 2 down]
	 * @param mCallBack - The ground station execute callBack
	 */
	public void setAircraftThrottle(int throttle,
			DJIGroundStationExecutCallBack mCallBack) {

	}


	/**
	 * Set Aircraft JoyStick Attitude
	 * @param yawSpeed - Aircraft yaw rotate speed[-1000 ~ 1000]
	 * @param pitchSpeed - Aircraft pitch rotate speed[-1000 ~ 1000]
	 * @param rollSpeed - Aircraft roll rotate speed[-1000 ~ 1000]
	 * @param throttle - Aircraft roll rotate speed[0 stop,1 up, 2 down]
	 * @param mCallBack - The ground station execute callBack
	 */

	public void setAircraftJoystick(int yawSpeed,
			int pitchSpeed,
			int rollSpeed,
			int throttle,
			DJIGroundStationExecutCallBack mCallBack) {

	}

	/**
	 * Get GroundStationFlyingInfoCallBack
	 * @return DJIGroundStationFlyingInfoCallBack
	 */
	public DJIGroundStationFlyingInfoCallBack getGroundStationFlyingInfoCallBack() {
		return groundStationFlyingInfoCallBack;
	}

	/**
	 * Set GroundStationFlyingInfoCallBack
	 * @param mGroundStationFlyingInfoCallBack - The ground station fly infomation callback
	 */
	public void setGroundStationFlyingInfoCallBack(DJIGroundStationFlyingInfoCallBack mGroundStationFlyingInfoCallBack) {
		this.groundStationFlyingInfoCallBack = mGroundStationFlyingInfoCallBack;
	}

	/**
	 * Get Ground Station Task
	 * @return DJIGroundStationTask
	 */
	public DJIGroundStationTask getDJIGroundStationTask() {
		return task;
	}
	
}
