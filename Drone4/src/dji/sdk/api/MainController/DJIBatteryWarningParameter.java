package dji.sdk.api.MainController;

public class DJIBatteryWarningParameter {
	/**
	 * need go home or not
	 */
	boolean isNeedGoHome;
	
	boolean isNeedLand; 
	
	/**
	 * the percent of voltage for battery warning LowBattery: 25 - 50 SeriousLowBattery: 10 - 25
	 */
	int percent;
	
}
