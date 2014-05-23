package br.com.drone4.automated.strategy;

import br.com.drone4.automated.action.MoveAction;
import br.com.drone4.model.Drone;

public interface StrategyInterpolator {
	
	public boolean handleGoTo(Drone drone, MoveAction action);
	
	public boolean handleTurn(Drone drone, MoveAction action);
	
}
