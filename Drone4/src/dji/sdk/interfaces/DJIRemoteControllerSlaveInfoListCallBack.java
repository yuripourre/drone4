package dji.sdk.interfaces;

import java.util.ArrayList;

import dji.sdk.api.RemoteController.DJIRemoteControllerSlaveInfo;

public interface DJIRemoteControllerSlaveInfoListCallBack {
	void onResult(ArrayList<DJIRemoteControllerSlaveInfo> result);
}
