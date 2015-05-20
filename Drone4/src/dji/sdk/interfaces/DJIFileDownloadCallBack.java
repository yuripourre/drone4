package dji.sdk.interfaces;

public interface DJIFileDownloadCallBack {
	void OnStart();
	void OnEnd();
	void OnError(Exception exception);
	void OnProgressUpdate(int progress);
}
