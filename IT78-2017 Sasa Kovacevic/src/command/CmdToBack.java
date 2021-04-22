package command;

import geometry.Shape;
import mvc.DrawingModel;

public class CmdToBack implements Command {
	private Shape shape;
	private DrawingModel model;
	private int shapeIndex;
	
	public CmdToBack(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
		this.shapeIndex = model.getShapeIndex(this.shape);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		model.remove(shape);
		if (shapeIndex == 0) {
			model.addOnIndex(0, shape);
		}
		else
			model.addOnIndex(shapeIndex - 1, shape);
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		model.remove(shape);
		model.addOnIndex(shapeIndex, shape);
	}

}
