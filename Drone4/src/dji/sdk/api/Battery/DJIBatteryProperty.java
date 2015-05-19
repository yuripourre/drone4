package dji.sdk.api.Battery;

public class DJIBatteryProperty {
	/**
	 * temperature between -128 to 127 (Centigrade)
	 */
	public int batteryTemperature = 0;
	
	/**
	 * current (mA)
	 */
	public int currentCurrent = 0;
	
	/**
	 * current electricity (mAh)
	 */
	public int currentElectricity = 0;
	
	/**
	 * voltage (mV)
	 */
	public int currentVoltage = 0;
	
	/**
	 * battery's design volume (mAh)
	 */
	public int designedVolume = 0;
	
	/**
	 * the history charge count
	 */
	public int dischargeCount = 0;
	
	/**
	 * battery's full charge volume (mAh)
	 */
	public int fullChargeVolume = 0;
	
	/**
	 * remain life percentage
	 */
	public int remainLifePercent = 0;
	
	/**
	 * remain power percentage
	 */
	public int remainPowerPercent = 0;
}
