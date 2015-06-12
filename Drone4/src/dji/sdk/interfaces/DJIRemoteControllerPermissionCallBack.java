package dji.sdk.interfaces;

import dji.sdk.api.RemoteController.DJIRemoteControllerPermission;

public interface DJIRemoteControllerPermissionCallBack {
	void onResult(DJIRemoteControllerPermission result);
}
