package dji.sdk.interfaces;

public interface DJIReceivedVideoDataCallBack {
	public void onResult(byte[] videoBuffer, int size);
}
