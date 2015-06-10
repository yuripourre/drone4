package dji.sdk.api;

import br.com.drone4.drone.PhantomDJI;
import dji.sdk.api.Battery.DJIBattery;
import dji.sdk.api.Camera.DJICamera;
import dji.sdk.api.Gimbal.DJIGimbal;
import dji.sdk.api.GroundStation.DJIGroundStation;
import dji.sdk.api.MainController.DJIMainController;
import dji.sdk.api.RangeExtender.DJIRangeExtender;

public class DJIDrone {
	
	private static DJIBattery battery = new DJIBattery(); 
	private static DJICamera camera;
	private static DJIGimbal gimbal = new DJIGimbal();
	private static DJIGroundStation groundStation = new DJIGroundStation();
	private static DJIMainController mainController = new DJIMainController();
	private static DJIRangeExtender rangeExtender = new DJIRangeExtender();
	
	public static final String TAG = "DJIDrone";
	
	//Added on Inspire 1 Update
	//private static DJIRemoteController remoteController;
	//private static DJIImageTransmitter imageTransmitter;

	private static PhantomDJI drone;
	
	public DJIDrone() {
		super();
	}	

	/**
	 * Return a static object of DjiCamera containing the information and operations of drone's camera.
	 * @return  DJICamera
	 */
	public static DJICamera getDjiCamera() {
		return camera;
	}

	/**
	 * Return a static object of DjiMainController. The main controller class would get and set the flight parameters of the drone. 
	 * @return
	 */
	public static DJIMainController getDjiMC() {
		return mainController;
	}

	public static DJIMainController getDjiMainController() {
		return getDjiMC();
	}

	/**
	 * Return a static object of DjiCamera containing the information and operations of drone gimbal.
	 * 
	 *  @return DJIGimbal
	 */
	public static DJIGimbal getDjiGimbal() {
		return gimbal;
	}
	
	/**
	 * Return a static object of DJIImageTransmitter containing the information and operations of ofdm. 
	 * @return DJIImageTransmitter
	 */
	/*public static DJIImageTransmitter getDjiImageTransmitter() {
		
	}*/
	

	/**
	 * Return a static object of DJIRangeExternder.
	 * @return DJIRangeExtender
	 */
	public static DJIRangeExtender getDjiRangeExtender() {
		return rangeExtender;	
	}

	/**
	 * Return a static object of DjiBattery containing the information and operations of drone's battery. 
	 * @return DJIBattery 
	 */
	public static DJIBattery getDjiBattery() {
		return battery;
	}

	/**
	 * Return a static object of DjiGroundStation. Ground Station provides some automatic operations
	 * for controlling the flight behavior of drone. However, all of the APIs in DjiGroundStation require
	 * that developers have the key of SDK-LEVEL-2. For P2V+, there are only joystick and ground
	 * station in the DJIGroundStation class. For Inspire 1 and Phantom 3, there are joystick, ground
	 * station, hot point and follow me(coming soon). 
	 * @return
	 */
	public static DJIGroundStation getDjiGroundStation() {
		return groundStation;
	}
	
	/**
	 * Return a static object of DjiRemoteController containing the information and operations of remote control.
	 * @return DJIRemoteController
	 */
	/*public static DJIRemoteController getDjiRemoteController() {
		
	}*/
	
	/**
	 * Description : TODO (Original comment from the DJI's SDK)
	 * @return DJIDroneType
	 */
	public static DJIDroneTypeDef.DJIDroneType getDroneType() {
		return DJIDroneTypeDef.DJIDroneType.DJIDrone_Vision;
	}
	
	/**
	 * Return an integer which will be used to identify the permission for using SDK on a basis of the level key.
	 * @return level
	 */
	public static int getLevel() {
		return 1;
	}

	public static PhantomDJI getDrone() {
		return drone;
	}

	public static void setDrone(PhantomDJI drone) {
		DJIDrone.drone = drone;
		camera = new DJICamera(drone.getCamera());
	}

}
