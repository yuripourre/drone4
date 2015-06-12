package dji.sdk.api.Gimbal;


public class DJIGimbalCustomerParamsCommand {
	
	/**
	 * This parameter will determine which command will be selected for informing gimbal to adjust its attitude
	 */
	public DJIGimbalTypeDef.CommandId id;
	
	/**
	 * The value will determine the degree of setting.
	 */
	public int value;
	
}
