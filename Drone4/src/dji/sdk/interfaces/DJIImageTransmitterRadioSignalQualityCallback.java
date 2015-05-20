package dji.sdk.interfaces;

import dji.sdk.api.ImageTransmitter.DJIImageTransmitterRadioSignalQuality;

public interface DJIImageTransmitterRadioSignalQualityCallback {
	void onResult(DJIImageTransmitterRadioSignalQuality mRadioSignalQuality);
}
