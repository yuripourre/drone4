package dji.sdk.interfaces;

import dji.sdk.api.MainController.DJIMainControllerTypeDef;

public interface DJIMcuErrorCallBack {
	void onError(DJIMainControllerTypeDef.DJIMCUErrorType error); 
}
