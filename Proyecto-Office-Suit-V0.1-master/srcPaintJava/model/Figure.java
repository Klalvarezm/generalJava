package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

import utils.IShape;
import view.BoundBox;
import view.ControlPoint;

public abstract class Figure implements IShape, Serializable {

	private static final long serialVersionUID = 1L;

	public Figure(Point position, Dimension size) {
		super();
		bbox = new BoundBox(position, size);
		if (needsNormalization()) {
			bbox.normalize();
		}
		bbox.init();
		color = Color.BLACK;
	}

	protected boolean needsNormalization() {
		return true;
	}

	public abstract void doPaint(Graphics2D g);

	public void paint(Graphics2D g) {
		g.setColor(color);
		doPaint(g);
		if (selected) {
			bbox.doPaint(g);
		}
	}

	public Dimension getSize() {
		return bbox.getSize();
	}

	public Point getPosition() {
		return bbox.getLocation();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean contains(Point pt) {
		return getNormBoundBox().contains(pt);
	}

	public BoundBox getBoundBox() {
		return bbox;
	}
	
	public BoundBox getNormBoundBox() {
		return bbox.getNormBoundBox();
	}
	
	public ControlPoint getControlPoint(Point point) {
		return bbox.getControlPoint(point);
	}
	
	public void move(int dx, int dy) {
		bbox.doMove(dx, dy);
	}

	private BoundBox bbox;
	private Color color;
	private boolean selected;
}