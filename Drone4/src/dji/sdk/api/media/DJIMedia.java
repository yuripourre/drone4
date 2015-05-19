package dji.sdk.api.media;

import java.awt.image.BufferedImage;

public class DJIMedia {

	/**
	 * the media file name
	 */
	public String fileName;

	/**
	 * the media file size
	 */
	public long fileSize;

	/**
	 * the media's create time
	 */
	public String createTime;

	/**
	 * if media is video. the property is indicate the duration of the video
	 */
	public float durationSeconds;

	/**
	 * the media type
	 */
	public DJIMediaTypeDef.MediaType mediaType;

	/**
	 * the media url
	 */
	public String mediaURL;

	/**
	 * thumbnail image
	 */
	// Original method returns android Bitmap
	// public Bitmap thumbnail;
	public BufferedImage thumbnail;

}
