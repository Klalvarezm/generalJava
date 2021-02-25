package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Ellipse extends ClosedFigure {

	public Ellipse(Point position, Dimension size) {
		super(position, size);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doPaint(Graphics2D g) {
		Point pt = getPosition();
		Dimension sz = getSize();
		g.drawOval(pt.x, pt.y, sz.width, sz.height);
	}

}
