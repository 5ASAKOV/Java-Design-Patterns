package geometry;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable, Moveable, Comparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean selected;
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(Point p);
	public abstract void draw(Graphics g);
	public abstract boolean contains(int x, int y);
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}