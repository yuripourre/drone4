package br.com.drone4.automated.strategy;

import br.com.drone4.automated.action.MoveAction;
import br.com.drone4.model.Drone;

public class SimpleStrategyInterpolator implements StrategyInterpolator {

	@Override
	public boolean handleGoTo(Drone drone, MoveAction action) {

		boolean foundY = false;

		boolean foundZ = false;
		
		if(drone.getZ() < action.getZ()) {
			drone.goForward();
		} else {
			foundZ = true;
		}

		if(drone.getY() < action.getY()) {

			drone.goUp();

		} else if(drone.getY() > action.getY()) {
			drone.goDown();
		} else {
			foundY = true;
		}
		
		

		if(foundY && foundZ) {

			return true;

		}
				
		return false;
	}

	@Override
	public boolean handleTurn(Drone drone, MoveAction action) {
		
		boolean foundY = false;

		boolean foundZ = true;
		
		if(drone.getAngleY() < action.getAngleY()) {

			drone.turnLeft();

		} else if(drone.getAngleY() > action.getAngleY()) {
			drone.turnRight();
		} else {
			foundY = true;
		}
		
		

		if(foundY && foundZ) {

			return true;

		}
		return false;
	}

}
