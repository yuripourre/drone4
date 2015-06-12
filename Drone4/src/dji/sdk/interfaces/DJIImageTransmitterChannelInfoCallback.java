package dji.sdk.interfaces;

import dji.sdk.api.DJIError;
import dji.sdk.api.ImageTransmitter.DJIImageTransmitterChannelInfo;

public interface DJIImageTransmitterChannelInfoCallback {
	void onResult(DJIImageTransmitterChannelInfo mChannelInfo, DJIError mErr);
}
