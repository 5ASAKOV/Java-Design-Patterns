package command;

import geometry.Shape;
import mvc.DrawingModel;

public class CmdRemoveShape implements Command{
	
	private DrawingModel model;
	private Shape shape;
	private int index;
	
	public CmdRemoveShape(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
		this.index = model.getShapeIndex(shape);
	}
	
	@Override
	public void execute() {
		model.remove(shape);	
		model.removeSelected(shape);
	}

	@Override
	public void unexecute() {
		model.addOnIndex(index, shape);
		model.addSelected(shape);
	}
	
}