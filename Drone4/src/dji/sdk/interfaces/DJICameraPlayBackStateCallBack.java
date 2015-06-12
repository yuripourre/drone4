package dji.sdk.interfaces;

import dji.sdk.api.Camera.DJICameraPlaybackState;

public interface DJICameraPlayBackStateCallBack {
	void onResult(DJICameraPlaybackState mState);
}
