package dji.sdk.interfaces;

import dji.sdk.api.RemoteController.DJIRemoteControllerMasterInfo;

public interface DJIRemoteControllerSearchMastersCallBack {
	void onResult(java.util.ArrayList<DJIRemoteControllerMasterInfo> result);
}
