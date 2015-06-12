package dji.sdk.interfaces;

import java.util.ArrayList;

import dji.sdk.api.Gimbal.DJIGimbalCustomerParamsCommand;

public interface DJIGimbalGetCustomerParamsCallBack {
	void onResult(ArrayList<DJIGimbalCustomerParamsCommand> cmdList);
}
