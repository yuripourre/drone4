package dji.sdk.interfaces;

import java.util.ArrayList;

import dji.sdk.api.RemoteController.DJIRemoteControllerChannelParams;

public interface DJIRemoteControllerGetChannelParamsCallBack {
	//Intentional Typo
	void onResutl(ArrayList<DJIRemoteControllerChannelParams> result);
}
