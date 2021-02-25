package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Text extends Figure {

	public Text(Point position, Dimension size) {
		super(position, size);
		content = "Título";
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doPaint(Graphics2D g) {
		Point pt = getPosition();
		Dimension sz = getSize();
		g.drawString(content, pt.x, pt.y);
	}

	private String content;
}
