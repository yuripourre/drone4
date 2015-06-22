package examples.dji;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import br.com.etyllica.core.graphics.Graphic;
import dji.sdk.api.DJIDrone;
import dji.sdk.api.DJIError;
import dji.sdk.api.Camera.DJICamera;
import dji.sdk.api.Camera.DJICameraSettingsTypeDef.CameraCaptureMode;
import dji.sdk.interfaces.DJIExecuteResultCallback;
import dji.sdk.interfaces.DJIReceivedVideoDataCallBack;
import examples.drone4.outdoor.MultiPilotEnvironment;

public class DJICameraExample extends MultiPilotEnvironment {

	private static final String TAG = "DJITestCamera";
	
	private BufferedImage buffer;
	private DJIReceivedVideoDataCallBack mReceivedVideoDataCallBack;
	
	public DJICameraExample(int w, int h) {
		super(w, h);
	}
	
	@Override
	public void load() {
		super.load();
		
		//Start Drone 1
		DJIDrone.setDrone(drone1);
		
		DJICamera camera = DJIDrone.getDjiCamera();

		boolean bConnectState = camera.getCameraConnectIsOk();
		if(bConnectState) {
			System.out.println("Camera is Ok");
		} else {
			System.out.println("Camera is not Ok");
		}
		
		//Based on OnCreateMethods
        mReceivedVideoDataCallBack = new DJIReceivedVideoDataCallBack() {

            @Override
            public void onResult(byte[] videoBuffer, int size) {
            	
            	InputStream in = new ByteArrayInputStream(videoBuffer);
				try {
					buffer = ImageIO.read(in);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        };
        
        DJIDrone.getDjiCamera().setReceivedVideoDataCallBack(mReceivedVideoDataCallBack);
        
        DJIDrone.getDjiCamera().startTakePhoto(CameraCaptureMode.Camera_Single_Capture, new DJIExecuteResultCallback() {

            @Override
            public void onResult(DJIError mErr) {
                //Log.d(TAG, "Set Action errorCode = "+ mErr.errorCode);
                //\Log.d(TAG, "Set Action errorDescription = "+ mErr.errorDescription);
            }
        });
		
        DJIDrone.getDjiCamera().startUpdateTimer(1000);
	}

	@Override
	public void draw(Graphic g) {
		super.draw(g);
		g.drawImage(buffer, 20, 50);
	}

}
