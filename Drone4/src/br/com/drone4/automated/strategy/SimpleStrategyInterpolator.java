package br.com.drone4.automated.strategy;

import br.com.drone4.automated.action.MoveAction;
import br.com.drone4.control.Sensitivity;
import br.com.drone4.model.Drone;

public class SimpleStrategyInterpolator implements StrategyInterpolator {

	@Override
	public boolean handleGoTo(Drone drone, MoveAction action) {

		boolean foundY = false;

		boolean foundZ = false;
		
		if(drone.getZ() < action.getZ()) {
			
			drone.goForward(Sensitivity.FULL_POSITIVE);
			
		} else {
			
			foundZ = true;
		}

		if(drone.getY() < action.getY()) {

			drone.goUp(Sensitivity.FULL_POSITIVE);

		} else if(drone.getY() > action.getY()) {
			
			drone.goDown(Sensitivity.FULL_NEGATIVE);
			
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

			drone.roll(Sensitivity.FULL_POSITIVE);

		} else if(drone.getAngleY() > action.getAngleY()) {
			
			drone.roll(Sensitivity.FULL_NEGATIVE);
			
		} else {
			
			foundY = true;
			
		}		
		

		if(foundY && foundZ) {

			return true;

		}
		return false;
	}

}
