package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Rectangle extends ClosedFigure {

	public Rectangle(Point position, Dimension size) {
		super(position, size);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doPaint(Graphics2D g) {
		Point pt = getPosition();
		Dimension sz = getSize();
		g.drawRect(pt.x, pt.y, sz.width, sz.height);
	}

}
