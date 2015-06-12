package dji.sdk.interfaces;

import dji.sdk.api.MainController.DJIMainControllerTypeDef;

public interface DJIMcIocTypeCallBack {
	void onResult(DJIMainControllerTypeDef.DJIMcIocType mIocType);
}
