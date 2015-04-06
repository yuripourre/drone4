package dji.sdk.interfaces;

import dji.sdk.api.MainController.DJIMainControllerSystemState;

public interface DJIMcuUpdateStateCallBack {
	void onResult(DJIMainControllerSystemState state); 
}
