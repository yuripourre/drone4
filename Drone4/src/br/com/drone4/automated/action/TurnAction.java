package br.com.drone4.automated.action;

public class TurnAction extends MoveAction {

	public TurnAction(double angleX, double angleY, double angleZ) {
		super(MoveActionType.TURN);
		
		this.angleX = angleX;
		this.angleY = angleY;
		this.angleZ = angleZ;
	}
	
}
