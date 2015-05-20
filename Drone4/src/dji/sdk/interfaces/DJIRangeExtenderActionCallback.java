package dji.sdk.interfaces;

import dji.sdk.api.RangeExtender.DJIRangeExtenderMsgTypeDef;

public interface DJIRangeExtenderActionCallback {
	void onResult(DJIRangeExtenderMsgTypeDef.RangeExtenderActionResult result);
}
