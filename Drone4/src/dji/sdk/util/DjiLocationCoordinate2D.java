package dji.sdk.util;

// Intentional typo to reflect DJI's api
public class DjiLocationCoordinate2D {

	public double latitude = 0;

	public double longitude = 0;

	public DjiLocationCoordinate2D(double latitude, double longitude) {
		super();

		this.latitude = latitude;
		this.longitude = longitude;
	}

	public boolean isValid() {

		boolean validLatitude = (latitude >= -90) && (latitude <= 90);
		boolean validLongitude = (longitude >= -180) && (longitude <= 180);

		return validLatitude && validLongitude;
	}

}
