package dji.sdk.api.Battery;

import dji.sdk.api.DJIObject;
import dji.sdk.interfaces.DJIBatteryGetHistoryStatusCallBack;
import dji.sdk.interfaces.DJIBatteryGetPartVoltageCallBack;
import dji.sdk.interfaces.DJIBatteryUpdateInfoCallBack;
import dji.sdk.interfaces.DJISmartBatteryExecuteResultCallback;

public class DJIBattery extends DJIObject {

	public static final String TAG = "DJIBattery";

	private int updateInterval = 0; //No update
	
	public DJIBattery() {
		super();
	}

	public void destroy() {

	}

	public boolean startUpdateTimer(int intervel) {
		updateInterval = intervel;
		return true;
	}

	public boolean stopUpdateTimer() {
		updateInterval = 0;
		return true;
	}

	/**
	 * This function will provide the connection status.
	 * @param mCallBack
	 */
	public void getBatteryConnectionStatus(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * This function will return the error type. 
	 * @param mCallBack
	 */
	public void getBatteryErrorType(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * This function will return the history status of the battery in last 31 times.
	 * @param mCallBack
	 */
	public void getBatteryHistoryStatus(DJIBatteryGetHistoryStatusCallBack mCallBack) {
		
	}
	
	/**
	 * Get the battery self-discharge day.
	 * @param mCallBack
	 */
	public void getBatterySelfDischargeDay(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	public void getPartVoltages(DJIBatteryGetPartVoltageCallBack mCallBack) {
		
	}
	
	/**
	 * Using a result callback to send the information, which contains the smart battery level for returning to home point. 
	 * @param mCallBack
	 */
	public void getSmartBatteryGohomeBatteryLevel(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * Get battery level which is needed for landing under the control of Smart Battery
	 * @param mCallBack
	 */
	public void getSmartBatteryLandBatteryLevel(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * Get the time which is needed for going home under the control of Smart Battery. 
	 * @param mCallBack
	 */
	public void getSmartBatteryNeedTimeForGoHome(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * Get the time which is needed for landing under the control of Smart Battery
	 * @param mCallBack
	 */
	public void getSmartBatteryNeedTimeForLand(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * Get the radius for going home under the control of Smart Battery.
	 * @param mCallBack
	 */
	public void getSmartBatteryRadiusForGohome(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * Get the flag for going home under the control of Smart Battery
	 * @param mCallBack
	 */
	public void getSmartBatteryRequestGohomeFlag(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * Get rest time for all tasks under the control of Smart Battery.
	 * @param mCallBack
	 */
	public void getSmartBatteryRestTimeForAll(DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	public void setBatterySelfDischargeDay(int days, DJISmartBatteryExecuteResultCallback mCallBack) {
		
	}
	
	/**
	 * Set update battery information callback
	 * @param mCallBack
	 */
	public void setBatteryUpdateInfoCallBack(DJIBatteryUpdateInfoCallBack mCallBack) {
		
	}
	
}
