package dji.sdk.api.ImageTransmitter;

/**
 * The DJIInspireImageTransmitter is the subclass of DJIImageTransmitter. 
 * Inheriting all functions from DJIImageTransmitter, the DJIInspireImageTransmitter
 * is designed for the Inspire 1. It has implemented some functions for setting the
 * upper bound and lower bound, setting bandwidth, switching channel(s) and doubling
 * the output. By adjusting the image transmitter properties, the transmission would
 * be stable and smooth.
 */
public class DJIInspireImageTransmitter extends DJIImageTransmitter {

	public String TAG = "DJIInspireImageTransmitter";
	
}
