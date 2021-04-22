package command;

import geometry.HexagonAdapter;
import hexagon.Hexagon;

public class CmdUpdateHexagon implements Command{
	private HexagonAdapter newState;
	private HexagonAdapter oldState;
	private HexagonAdapter originalState = new HexagonAdapter(0, 0, 0);
	
	public CmdUpdateHexagon(HexagonAdapter oldState, HexagonAdapter newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		 /*
		  Hexagon h = new
		  Hexagon(oldState.getHexagon().getX(),oldState.getHexagon().getY(),oldState.
		  getHexagon().getR()); h.setAreaColor(oldState.getHexagon().getAreaColor());
		  h.setBorderColor(oldState.getHexagon().getBorderColor());
		  h.setSelected(true); originalState.setHexagon(h);
		  
		  Hexagon h1= new
		  Hexagon(newState.getHexagon().getX(),newState.getHexagon().getY(),newState.
		  getHexagon().getR()); h1.setAreaColor(newState.getHexagon().getAreaColor());
		  h1.setBorderColor(newState.getHexagon().getBorderColor());
		  h1.setSelected(true); oldState.setHexagon(h1);
		 */
		
		/*
		 * originalState.getHexagon().setX(oldState.getHexagon().getX());
		 * originalState.getHexagon().setY(oldState.getHexagon().getY());
		 * originalState.getHexagon().setR(oldState.getHexagon().getR());
		 * originalState.getHexagon().setAreaColor(oldState.getHexagon().getAreaColor())
		 * ; originalState.getHexagon().setBorderColor(oldState.getHexagon().
		 * getBorderColor());
		 * 
		 * oldState.getHexagon().setX(newState.getHexagon().getX());
		 * oldState.getHexagon().setY(newState.getHexagon().getY());
		 * oldState.getHexagon().setR(newState.getHexagon().getR());
		 * oldState.getHexagon().setAreaColor(newState.getHexagon().getAreaColor());
		 * oldState.getHexagon().setBorderColor(newState.getHexagon().getBorderColor());
		 */
		
		this.originalState = oldState.clone(this.originalState);
		this.oldState = newState.clone(this.oldState);
	}

	@Override
	public void unexecute() {
		/*
		oldState.getHexagon().setX(originalState.getHexagon().getX());
		oldState.getHexagon().setY(originalState.getHexagon().getY());
		oldState.getHexagon().setR(originalState.getHexagon().getR());
		oldState.getHexagon().setAreaColor(originalState.getHexagon().getAreaColor());
		oldState.getHexagon().setBorderColor(originalState.getHexagon().getBorderColor());
		*/
		
		this.oldState = originalState.clone(this.oldState);
	}

}