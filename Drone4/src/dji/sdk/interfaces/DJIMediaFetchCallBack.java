package dji.sdk.interfaces;

import dji.sdk.api.DJIError;
import dji.sdk.api.media.DJIMedia;

public interface DJIMediaFetchCallBack {
	void onResult(java.util.List<DJIMedia> mList, DJIError mError);
}
