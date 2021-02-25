package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends GeomFigure {

	private static final long serialVersionUID = 1L;

	public Line(Point pt, Dimension sz) {
		super(pt, sz);
	}

	@Override
	public void doPaint(Graphics2D g) {
		Point pt = getPosition();
		Dimension sz = getSize();
		g.drawLine(pt.x, pt.y, pt.x + sz.width, pt.y + sz.height);
	}

	@Override
	protected boolean needsNormalization() {
		return false;
	}

}