package br.com.drone4.automated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.drone4.automated.action.MoveAction;
import br.com.drone4.automated.action.MoveActionType;
import br.com.drone4.automated.strategy.SimpleStrategyInterpolator;
import br.com.drone4.automated.strategy.StrategyInterpolator;
import br.com.drone4.model.Drone;

public class AutonomousFlight {

  private Drone drone;

  private int currentPoint = 0;

  private Map<MoveActionType, StrategyInterpolator> map;

  private List<MoveAction> actions = new ArrayList<MoveAction>();

  public AutonomousFlight(Drone drone, List<MoveAction> actions) {
    super();

    this.drone = drone;

    this.actions.addAll(actions);

    map = new HashMap<MoveActionType, StrategyInterpolator>();

    SimpleStrategyInterpolator interpolator = new SimpleStrategyInterpolator();

    map.put(MoveActionType.GO_TO, interpolator);
    map.put(MoveActionType.TURN, interpolator);

  }

  public void flight() {

    MoveAction action = actions.get(currentPoint);

    StrategyInterpolator strategy = map.get(action.getActionType());

    boolean nextPoint = false;

    switch (action.getActionType()) {

      case GO_TO:
        nextPoint = strategy.handleGoTo(drone, action);
        break;

      case TURN:
        nextPoint = strategy.handleTurn(drone, action);
        break;
    }

    if (nextPoint) {
      if (currentPoint < actions.size() - 1) {
        currentPoint++;
      }
    }

  }

}
