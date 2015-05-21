package examples.dji;

import dji.sdk.api.DJIDrone;
import dji.sdk.api.Camera.DJICamera;

public class DJITestBattery {

	public static void main(String[] args) {
		
		DJICamera camera = DJIDrone.getDjiCamera();
		
		boolean bConnectState = camera.getCameraConnectIsOk();
		if(bConnectState) {
			System.out.println("Camera is Ok");
		} else {
			System.out.println("Camera is not Ok");
		}
	}

}
