package dji.sdk.api.Camera;

import br.com.drone4.sensor.camera.StandardCamera;

public class DJIPhantomCamera extends DJICamera {

	public static String TAG = "DJIPhantomCamera";
	
	//This method is not included on DJI's SDK
	public DJIPhantomCamera(StandardCamera camera) {
		super(camera);
	}
	
}
