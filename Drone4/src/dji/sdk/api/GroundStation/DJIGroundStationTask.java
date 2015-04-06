package dji.sdk.api.GroundStation;

import java.util.ArrayList;
import java.util.List;

public class DJIGroundStationTask {

	private List<DJIGroundStationWaypoint> mWaypointsList; 
	private int startWaypointIndex = 0; 
	private int wayPointCount = 0;
	
	private boolean loop = false;
	
	public DJIGroundStationTask() {
		super();
		
		mWaypointsList = new ArrayList<DJIGroundStationWaypoint>();
	}
	

    /**
     * Get the count of waypoint 
     * @return
     */

    public int getWayPointCount() {
    	return wayPointCount;
    }
    
    /**
     * Get the start waypoint index 
     * @return
     */
    public int getStartWaypointIndex() {
    	return startWaypointIndex;
    }

    /**
     * Set the start waypoint index 
     * @param index - The start waypoint index
     */
    public void setStartWaypointIndex(int index) {
    	this.startWaypointIndex = index;
    }

    /**
     * Set the loop mode 
     * @param loop - The loop mode
     */
    public void setLoop(boolean loop) {
    	this.loop = loop;
    }
    
    /**
     * Add a waypoint to list
     * @param waypoint - The waypoint
     */
    public void addWaypoint(DJIGroundStationWaypoint waypoint) {
    	
    }

    /**
     * Insert a waypoint 
     * @param waypoint - The waypoint
     * @param index - The waypoint index
     */

    public void insertWaypoint(DJIGroundStationWaypoint waypoint,
                      int index) {
    	mWaypointsList.add(index, waypoint);
    }

    /**
     * Remove all waypoints
     * (Intentionally Uppercase to reflect DJI's API) 
     */
    public void RemoveAllWaypoint() {
    	mWaypointsList.clear();
    }

    /**
     * Get waypoint at index 
     * @param index - The waypoint index
     * @return DJIGroundStationWaypoint
     */
    public DJIGroundStationWaypoint getWaypointAtIndex(int index) {
    	return mWaypointsList.get(index);
    }   


    /**
     * Get all waypoints 
     * @return List
     */

    public List<DJIGroundStationWaypoint> getAllWaypoint() {
    	return mWaypointsList; 
    }
	
}
