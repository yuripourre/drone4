package dji.sdk.interfaces;

import dji.sdk.api.DJIError;
import dji.sdk.api.ImageTransmitter.DJIImageTransmitterTypeDef;

public interface DJIImageTransmitterBandwidthCallback {
	void onResult(DJIImageTransmitterTypeDef.DJIImageTransmitterBandwidth mBandwidth, DJIError mErr);
}
