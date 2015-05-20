package dji.sdk.interfaces;

import dji.sdk.api.RemoteController.DJIRemoteControllerCustomerPreference;
import dji.sdk.api.RemoteController.DJIRemoteControllerTypeDef;

public interface DJIRemoteControllerModeCallBack {
	void onResult(DJIRemoteControllerTypeDef.DJIRemoteControllerControlMode mode,
            java.util.ArrayList<DJIRemoteControllerCustomerPreference> channelTypeList);
}
