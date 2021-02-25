package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public abstract class ClosedFigure extends GeomFigure {

	public ClosedFigure(Point position, Dimension size) {
		super(position, size);
	}

	private static final long serialVersionUID = 1L;

	private Color fill;

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

}
