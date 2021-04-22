package command;

import geometry.Donut;
import geometry.Point;

public class CmdUpdateDonut implements Command {
	
	private Donut oldState;
	private Donut newState;
	private Donut originalState = new Donut(new Point(), 0, 0);

	public CmdUpdateDonut(Donut oldState, Donut newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		/*originalState.getCenter().setX(oldState.getCenter().getX());
		originalState.getCenter().setY(oldState.getCenter().getY());
		originalState.setRadius(oldState.getRadius());
		originalState.setInnerRadius(oldState.getInnerRadius());
		originalState.setFillColor(oldState.getFillColor());
		originalState.setsEdgeColor(oldState.getsEdgeColor());
		
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		oldState.setRadius(newState.getRadius());
		oldState.setInnerRadius(newState.getInnerRadius());
		oldState.setFillColor(newState.getFillColor());
		oldState.setsEdgeColor(newState.getsEdgeColor());
		*/

		this.originalState = oldState.clone(this.originalState);
		this.oldState = newState.clone(this.oldState);
	}

	@Override
	public void unexecute() {
		/*oldState.getCenter().setX(originalState.getCenter().getX());
		oldState.getCenter().setY(originalState.getCenter().getY());
		oldState.setRadius(originalState.getRadius());
		oldState.setInnerRadius(originalState.getInnerRadius());
		oldState.setFillColor(originalState.getFillColor());
		oldState.setEdgeColor(originalState.getEdgeColor());
		oldState.setsEdgeColor(originalState.getsEdgeColor());
		*/
		
		this.oldState = originalState.clone(this.oldState);
	}
}
