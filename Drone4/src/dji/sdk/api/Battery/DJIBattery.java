package dji.sdk.api.Battery;

import dji.sdk.api.DJIObject;
import dji.sdk.interfaces.DJIBattryUpdateInfoCallBack;
import dji.sdk.interfaces.DJISmartBatteryExecuteResultCallback;

public class DJIBattery extends DJIObject {

	public static final String TAG = "DJIBattery";
	
	public DJIBattery() {
		super();
	}
	
	public void destroy() {
		
	}
	
	public boolean startUpdateTimer(int intervel) {
		return true;
	}
	
	public boolean stopUpdateTimer() {
		return true;
	}
	
	//Intentional typo 
	public void setBattryUpdateInfoCallBack(DJIBattryUpdateInfoCallBack mCallBack) {
		//mCallBack.onResult(state);
	}
	
	public void getSmartBatteryRestTimeForAll(DJISmartBatteryExecuteResultCallback mCallBack) {
		//mCallBack.onResult(result, mErr);
	}
	
	public void getSmartBatteryNeedTimeForGoHome(DJISmartBatteryExecuteResultCallback mCallBack) {
		//mCallBack.onResult(result, mErr);
	}
	
	public void getSmartBatteryNeedTimeForLand(DJISmartBatteryExecuteResultCallback mCallBack) {
		//mCallBack.onResult(result, mErr);
	}
	
	public void getSmartBatteryGohomeBatteryLevel(DJISmartBatteryExecuteResultCallback mCallBack) {
		//mCallBack.onResult(result, mErr);
	}
	
	public void getSmartBatteryLandBatteryLevel(DJISmartBatteryExecuteResultCallback mCallBack) {
		//mCallBack.onResult(result, mErr);
	}
	
	public void getSmartBatteryRadiusForGohome(DJISmartBatteryExecuteResultCallback mCallBack) {
		//mCallBack.onResult(result, mErr);
	}
	
	public void getSmartBatteryRequestGohomeFlag(DJISmartBatteryExecuteResultCallback mCallBack) {
		//mCallBack.onResult(result, mErr);
	}
}
