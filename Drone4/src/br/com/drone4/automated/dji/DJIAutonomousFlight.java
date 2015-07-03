package br.com.drone4.automated.dji;

import java.util.List;

import br.com.abby.linear.ColoredPoint3D;
import br.com.drone4.control.Sensitivity;
import br.com.drone4.model.Drone;
import dji.sdk.api.GroundStation.DJIGroundStationTask;
import dji.sdk.api.GroundStation.DJIGroundStationWaypoint;

public class DJIAutonomousFlight {

	private Drone drone;
	private DJIGroundStationTask task;

	private int currentPoint = 0;

	private boolean needTurn = true;
	private boolean goal = false;
	private boolean landing = false;

	double tolerance = 1;//1 meter radius 

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

		if(currentPoint >= points.size()) {
			return false;
		}

		DJIGroundStationWaypoint waypoint = points.get(currentPoint);

		//Next Waypoint
		ColoredPoint3D point = extractPoint(waypoint);

		if (!isOverPoint(point)) {
			turnToPoint(point);
			goToPoint(point);
		} else {
			reachedPoint(points);
		}

		return goal;
	}

	private boolean isOverPoint(ColoredPoint3D point) {
		return near(drone.getX(), point.getX(), tolerance) &&
				near(drone.getZ(), point.getZ(), tolerance);
	}

	private boolean near(double value, double target, double tolerance) {
		return value<=target+tolerance &&value>=target-tolerance;
	}

	private void reachedPoint(List<DJIGroundStationWaypoint> points) {

		if (landing && !landed()) {
			land();
			return;
		}

		currentPoint++;
		needTurn = true;

		if (currentPoint >= points.size()) {
			if (!task.loop) {
				landed();
			} else {
				currentPoint %= points.size();
			}
		}
	}

	protected void land() {
		if (drone.getY() > 0) {
			drone.goDown(Sensitivity.FULL_POSITIVE);
		} else if (drone.getY() <= 0) {
			drone.setY(0);

			// landed
			goal = true;
			landing = false;
		}
	}

	private boolean landed() {
		return drone.getY() == 0;
	}

	private void goToPoint(ColoredPoint3D point) {
		if(needTurn) {
			return;
		}

		drone.goForward(drone.getSpeed());
	}

	private void turnToPoint(ColoredPoint3D point) {
		
		double angleY = point.angleXZ(drone)+90;
		
		double offset = Sensitivity.FULL_POSITIVE;

		if (drone.getAngleY() != angleY) {
			if (drone.getAngleY() < angleY+offset) {
				drone.turnLeft(Sensitivity.FULL_POSITIVE/2);

				if(drone.getAngleY() >= angleY+offset) {
					needTurn = false;
				}

			} else if (drone.getAngleY() > angleY-offset) {
				drone.turnRight(Sensitivity.FULL_NEGATIVE/2);

				if (drone.getAngleY() <= angleY-offset) {
					needTurn = false;
				}
			}

		}/* else {
			needTurn = false;
		}*/
	}

	private ColoredPoint3D extractPoint(DJIGroundStationWaypoint waypoint) {
		return new ColoredPoint3D(waypoint.lontitude, waypoint.altitude, waypoint.latitude);
	}

	public int getCurrentPoint() {
		return currentPoint;
	}

}
