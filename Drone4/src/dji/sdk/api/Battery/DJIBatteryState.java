package dji.sdk.api.Battery;

public class DJIBatteryState {

	/**
	 * Cell damaged
	 */
	public short damagedCellIndex;
	
	/**
	 * Low temperature in discharge.
	 */
	public boolean dischargeLowTemperature;
	
	public boolean dischargeOver;
	
	/**
	 * Over heat in discharge 
	 */
	public boolean dischargeOverHeat;
	
	/**
	 * Short cut in discharge
	 */
	public boolean dischargeShortCut;
	
	/**
	 * Self-discharge in storage 
	 */
	public boolean selfDischarge;
	
	/**
	 * Cell Under voltage
	 */
	public short underVoltageCellIndex;
	
}
