package dji.sdk.api.ImageTransmitter;

import dji.sdk.interfaces.DJIExecuteResultCallback;
import dji.sdk.interfaces.DJIImageTransmitterBandwidthCallback;
import dji.sdk.interfaces.DJIImageTransmitterChannelInfoCallback;
import dji.sdk.interfaces.DJIImageTransmitterChannelPowerCallback;
import dji.sdk.interfaces.DJIImageTransmitterDoubleOutputStateCallback;
import dji.sdk.interfaces.DJIImageTransmitterRadioSignalQualityCallback;

/**
 * DJIImageTransmitter is a base class for the image transmitter of DJI drone.
 * Located in the remote controller, Light Bridge component has been added into
 * the system of Inspire 1 and Phantom 3 for the consideration of transmitting high 
 * quality images and videos. DJIImageTransmitter has abstracted the functions of 
 * the light bridge which will support long-distance file transmitting. As the 
 * Light Bridge requires sufficient signal, the Light Bridge provide several candidate 
 * channel for selection. Developers could provide function for switching channel 
 * which could provide stable and smooth transmission. Also, the upper bound and lower 
 * bound could be set up by the functions provided by DJIImageTransmitter. What's more, 
 * the bandwidth could be set up for further consideration of transmitting.
 */
public class DJIImageTransmitter {
	public String TAG = "DJIInspireImageTransmitter";
	
	/**
	 * Release dji ofdm interface
	 */
	public void destroy() {
		
	}
		
	/**
	 * Get ImageTransmitter bandwidth
	 * @param mCall
	 */
	void getImageTransmitterBandwidth(DJIImageTransmitterBandwidthCallback mCall) {
		
	}
	
	/**
	 * Get ImageTransmitter current channel and channel select mode
	 * @param mCall
	 */
	void getImageTransmitterChannel(DJIImageTransmitterChannelInfoCallback mCall) {
		
	}
	
	/**
	 * Get ImageTransmitter is double output
	 * @param mCall
	 */
	void getImageTransmitterDoubleOutput(DJIImageTransmitterDoubleOutputStateCallback mCall) {
		
	}
	
	/**
	 * Set ImageTransmitter bandwidth
	 * @param mBandwidth
	 * @param mCall
	 */
	void setImageTransmitterBandWidth(DJIImageTransmitterTypeDef.DJIImageTransmitterBandwidth mBandwidth, 
			DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set ImageTransmitter channel by manual.
	 * @param channel
	 * @param mCall
	 */
	void setImageTransmitterChannel(int channel, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set ImageTransmitter auto select channel mode.
	 * @param mCall
	 */
	void setImageTransmitterChannelAutoSelect(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set ImageTransmitter Channel Power Callback.
	 * @param mCB
	 */
	void setImageTransmitterChannelPowerCallback(DJIImageTransmitterChannelPowerCallback mCB) {
		
	}
	
	/**
	 * Set ImageTransmitter double output.
	 * @param isDouble
	 * @param mCall
	 */
	void setImageTransmitterDoubleOutput(boolean isDouble, DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Set Downlink Radio Signal Quality Callback.
	 * @param mCB
	 */
	void setImageTransmitterDownlinkRadioSignalQualityCallback(DJIImageTransmitterRadioSignalQualityCallback mCB) {
		
	}
	
	/**
	 * Set Uplink Radio Signal Quality Callback.
	 * @param mCB
	 */
	void setImageTransmitterUplinkRadioSignalQualityCallback(DJIImageTransmitterRadioSignalQualityCallback mCB) {
		
	}
	
	/**
	 * Start Need Channel Power Updates Notify the ImageTransmitter device to start update frequency power data.
	 * @param mCall
	 */
	void startNeedChannelPowerUpdates(DJIExecuteResultCallback mCall) {
		
	}
	
	/**
	 * Stop Need Channel Power Updates Notify the ImageTransmitter device to stop update frequency power data.
	 * @param mCall
	 */
	void stopNeedChannelPowerUpdates(DJIExecuteResultCallback mCall) {
		
	}
	
}
