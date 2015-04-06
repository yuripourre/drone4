package dji.sdk.interfaces;

import dji.sdk.api.DJIError;

public interface DJIReceivedFileDataCallBack {
	void onResult(byte[] buffer, int size, int progress, DJIError mErr); 
}
