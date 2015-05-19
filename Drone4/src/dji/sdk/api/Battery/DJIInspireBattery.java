package dji.sdk.api.Battery;


/**
 * As an extension of DJIBattery, DJIInspireBattery could specifically communicate with the Inspire 1 as
 * well as Phantom 3 and share same properties with DJIBattery, which means it could receive current
 * battery information and status from Inspire 1 and Phantom 3.
 * 
 * To make sure the information interchange is stable and completed, the lifecycle of callback should be set
 * correctly. Effected by the android life cycle, the callback, especially the one receives the information
 * from the aircraft, should follow the pattern of android system and update its statement on the basis of
 * the stage of the life cycle. For better understanding the construction of the life cycle of DJI callback, we
 * will provide a tutorial for setting up the callback life cycle. The code following is a sample of life cycle
 * setting of DJIBatteryUpdateInfoCallBack.
 */
public class DJIInspireBattery extends DJIBattery {
	
}
