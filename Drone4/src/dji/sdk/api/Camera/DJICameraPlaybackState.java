package dji.sdk.api.Camera;

public class DJICameraPlaybackState {
	/**
	 * current selected file index.
	 */
	public int currentSelectedFileIndex;
	
	/**
	 * file delete status.
	 */
	public DJICameraSettingsTypeDef.CameraMediaFileDeleteStatus fileDeleteStatus;
	
	/**
	 * is all files selected in current view.
	 */
	public boolean isAllFilesInPageSelected;
	
	/**
	 * is the file ever been downloaded.
	 */
	public boolean isFileDownloaded;
	
	/**
	 * is the selected file is a valid photo/video file.
	 */
	public boolean isSelectedFileValid;
	
	/**
	 * the media file type.
	 */
	public DJICameraSettingsTypeDef.CameraMediaFileType mediaFileType;
	
	/**
	 * numbers of media files, include photos and videos.
	 */
	public int numbersOfMediaFiles;
	
	/**
	 * numbers of photos in the SD card
	 */
	public int numbersOfPhotos;
	
	/**
	 * the numbers of selected files.
	 */
	public int numbersOfSelected;
	
	/**
	 * numbers of thumbnail.
	 */
	public int numbersOfThumbnail;
	
	/**
	 * numbers of videos in the SD card
	 */
	public int numbersOfVideos;
	
	/**
	 * photo center coordinate x
	 */
	public int photoCenterCoordinateX;
	
	/**
	 * photo center coordinate y
	 */
	public int photoCenterCoordinateY;
	
	/**
	 * photo height
	 */
	public int photoHeight;
	
	/**
	 * photo width
	 */
	public int photoWidth;
	
	/**
	 * the mode of playback.
	 */
	public DJICameraSettingsTypeDef.CameraPlaybackMode playbackMode;
	
	/**
	 * duration in second of video.
	 */
	public int videoDuration;
	
	/**
	 * current position in second of video playback.
	 */
	public int videoPlayPosition;
	
	/**
	 * progress in percentage of video playback.
	 */
	public int videoPlayProgress;
	
	/**
	 * zoom scale of photo.
	 */
	public float zoomScale;
	
}
