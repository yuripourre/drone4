package dji.sdk.api.MainController;

public class DJIDeformInfo {
	/**
	 * Is Deform Protected Or Not
	 */
	boolean isDeformProtected;
	
	/**
	 * the deform mode
	 */
	DJIMainControllerTypeDef.DJIMcDeformMode mode;
	
	/**
	 * the deform status
	 */
	DJIMainControllerTypeDef.DJIMcDeformStatus status;
	
	public DJIDeformInfo() {
		
	}
}
