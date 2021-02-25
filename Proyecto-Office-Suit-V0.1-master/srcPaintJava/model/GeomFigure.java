package model;

import java.awt.Dimension;
import java.awt.Point;

public abstract class GeomFigure extends Figure {

	public GeomFigure(Point position, Dimension size) {
		this(position, size, 1);
	}

	public GeomFigure(Point position, Dimension size, float thickness) {
		super(position, size);
		this.thickness = thickness;
	}

	private static final long serialVersionUID = 1L;

	private float thickness;

	public float getThickness() {
		return thickness;
	}

	public void setThickness(float thickness) {
		this.thickness = thickness;
	}

}