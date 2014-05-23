package br.com.drone4.automated.action;

public class GoToAction extends MoveAction {

	public GoToAction(double x, double y, double z) {
		super(MoveActionType.GO_TO);
		
		this.x = x;
		
		this.y = y;
		
		this.z = z;

	}
	
}
