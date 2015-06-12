package dji.sdk.interfaces;

import dji.sdk.api.DJIError;

public interface DJIImageTransmitterDoubleOutputStateCallback {
	void onResult(boolean mState, DJIError mErr);
}
