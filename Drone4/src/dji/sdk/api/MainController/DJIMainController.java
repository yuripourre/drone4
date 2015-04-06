package dji.sdk.api.MainController;

import dji.sdk.api.DJIObject;
import dji.sdk.interfaces.DJIExecuteBooleanResultCallback;
import dji.sdk.interfaces.DJIExecuteFloatResultCallback;
import dji.sdk.interfaces.DJIExecuteResultCallback;
import dji.sdk.interfaces.DJIMcuErrorCallBack;
import dji.sdk.interfaces.DJIMcuUpdateStateCallBack;

public class DJIMainController extends DJIObject {
	
	public static final java.lang.String TAG = "DJIMainController"; 

	private DJIMcuErrorCallBack mDJIMcuErrorCallBack;
	
	private DJIMcuUpdateStateCallBack mDJIMcuUpdateStateCallBack;
	
	public DJIMainController() {
		super();
	}
	
	/**
	 * Start upate timer
	 * @param intervel - Timer run interval
	 * @return success 
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
     * release mcu 
     */
    public void destroy() {
    	
    }

    /**
     * Get DJIMcuErrorCallBack 
     * @return DJIMcuErrorCallBack
     */
    public DJIMcuErrorCallBack getMcuErrorCallBack() {
    	return mDJIMcuErrorCallBack;
    }

    /**
     * Set DJIMcuErrorCallBack 
     * @param mMcuErrorCallBack - The main controller error callback
     */
    public void setMcuErrorCallBack(DJIMcuErrorCallBack mMcuErrorCallBack) {
    	this.mDJIMcuErrorCallBack = mMcuErrorCallBack;
    }

    /**
     * Get DJIMcuUpdateStateCallBack 
     * @return DJIMcuUpdateStateCallBack
     */
    public DJIMcuUpdateStateCallBack getMcuUpdateStateCallBack() {
    	return mDJIMcuUpdateStateCallBack;
    }

    /**
     * Set DJIMcuUpdateStateCallBack 
     * @param mMcuUpdateStateCallBack - The main controller update state callBack
     */
    public void setMcuUpdateStateCallBack(DJIMcuUpdateStateCallBack mMcuUpdateStateCallBack) {
    	
    }

    /**
     * Get MCU Version 
     * @return String
     */
    public String getMCUVersion() {
    	return "XXXX(MCU Version)";
    }
    
    /**
     * Set no fly zone 
     * @param zone - The nofly zones
     * @param mCallBack - The result callback
     */
    public void setNoFlyZone(DJIPhantomNoFlyZone zone,
                    DJIExecuteBooleanResultCallback mCallBack) {
    	
    }

    /**
     * Set Fly Limit Parameter
     * @param para - The fly limit parameter
     * @param mCallBack - The result callback
     */
    public void setFlyLimitParameter(DJIPhantomFlyLimitParameter para,
                            DJIExecuteBooleanResultCallback mCallBack) {
    	
    }

	/**
	 * Set Go Home Command 
	 * @param goHome - The go home
	 * @param mCallBack - The result callback
	 */
    public void setGohomeCmd(boolean goHome,
                    DJIExecuteBooleanResultCallback mCallBack) {
    	
    }

    /**
     * Get Smart Battery Go home Flag 
     * @param mCallBack - The result callback
     */
    public void getSmartBatteryGohomeFlag(DJIExecuteBooleanResultCallback mCallBack) {
    	
    }

    /**
     * Set Smart Battery Go home Flag 
     * @param flag - The smart battery go home flag
     * @param mCallBack - The result callback
     * 
     * P.S.:typo to reflect DJI's API
     */
    public void SetSmartBatteryGohomeFlag(boolean flag,
                                 DJIExecuteBooleanResultCallback mCallBack) {
    	
    }

    /**
     * Set Start Compass Calibration 
     * @param mCallBack - The result callback
     */
    public void setStartCompassCalibration(DJIExecuteBooleanResultCallback mCallBack) {
    	
    }

    /**
     * Set Aircraft Home Gps Location 
     * @param latitude - The latitude of location
     * @param longitude - The longitude of location
     * @param mCallBack - The result callback
     */
    public void setAircraftHomeGpsLocation(double latitude,
                                  double longitude,
                                  DJIExecuteResultCallback mCallBack) {
    	
    }

    /**
     * Set Go Home Altitude 
     * @param altitude - The go home altitude(m) [20m - 500m]
     * @param mCallBack - The result callback
     */
    public void setGohomeAltitude(float altitude,
                         DJIExecuteBooleanResultCallback mCallBack) {
    	
    }

    /**
     * Get Go Home Altitude 
     * @param mCallBack - The result callback, result <= 0 --> invalid, result > 0 --> normal.
     */
    public void getGohomeAltitude(DJIExecuteFloatResultCallback mCallBack) {
    	
    }
	
}
