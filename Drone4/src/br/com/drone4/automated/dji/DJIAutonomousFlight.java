package br.com.drone4.automated.dji;

import java.util.List;

import br.com.abby.linear.Point3D;
import br.com.drone4.control.Sensitivity;
import br.com.drone4.model.Drone;
import dji.sdk.api.GroundStation.DJIGroundStationTask;
import dji.sdk.api.GroundStation.DJIGroundStationWaypoint;

public class DJIAutonomousFlight {

	private Drone drone;

	private int currentPoint = 0;

	private DJIGroundStationTask task;
	
	private boolean landing = false;
	
	private boolean goal = false;

	public DJIAutonomousFlight(Drone drone, DJIGroundStationTask task) {
		super();

		this.drone = drone;

		this.task = task;	
	}

	public boolean flight() {

		if (goal) {
			return true;
		}
		
		List<DJIGroundStationWaypoint> points = task.getAllWaypoint();

		DJIGroundStationWaypoint waypoint = points.get(currentPoint);

		Point3D point = extractPoint(waypoint);		
		
		if(drone.getX() != point.getX()) {
			gotoPoint(point);
		} else {
			reachedPoint(points);
		}
		
		return goal;
	}

	private void reachedPoint(List<DJIGroundStationWaypoint> points) {
		
		if (landing && !land()) {
			
			if(drone.getY() > 0) {
				drone.goDown(Sensitivity.FULL_POSITIVE);
			} else if(drone.getY()<=0) {
				drone.setY(0);
				goal = true;
			}
			
			return;
		}
		
		currentPoint++;

		if(currentPoint>=points.size()) {
			if(!task.loop) {
				land();
			} else {
				currentPoint %= points.size();
			}
		}
	}

	private boolean land() {
		return drone.getY() == 0;		
	}

	private void gotoPoint(Point3D point) {
		double angleY = drone.angleXZ(point);
		drone.setAngleY(angleY);
		drone.goForward(drone.getSpeed());
	}

	private Point3D extractPoint(DJIGroundStationWaypoint waypoint) {
		return new Point3D(waypoint.lontitude, waypoint.latitude, waypoint.altitude);
	}

}
