package view;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import utils.IShape;

public class ControlPoint implements IShape {

	static enum Coordinate {
		N, NE, E, SE, S, SW, W, NW
	}
	
	public ControlPoint(BoundBox bbox, Coordinate coord) {
		this.bbox = bbox;
		this.coord = coord;
	}
		
	@Override
	public void doPaint(Graphics2D g) {
				
		Point pt = getPosition();
		g.fillRect(pt.x - HSIZE, pt.y - HSIZE, 2*HSIZE + 1, 2*HSIZE + 1);
	}
	
	private Point getPosition() {
		
		int x = 0;
		int y = 0;
		
		switch(coord) {
		case N:
			x = bbox.x + bbox.width / 2;
			y = bbox.y;
			break;
		case NE:
			x = bbox.x + bbox.width;
			y = bbox.y;
			break;
		case E:
			x = bbox.x + bbox.width;
			y = bbox.y + bbox.height / 2;
			break;
		case SE:
			x = bbox.x + bbox.width;
			y = bbox.y + bbox.height;
			break;
		case S:
			x = bbox.x + bbox.width / 2;
			y = bbox.y + bbox.height;
			break;
		case SW:
			x = bbox.x;
			y = bbox.y + bbox.height;
			break;
		case W:
			x = bbox.x;
			y = bbox.y + bbox.height / 2;
			break;
		case NW:
			x = bbox.x;
			y = bbox.y;
			break;
		}
		
		return new Point(x, y);
	}
	
	public Cursor getCursor() {
		
		Cursor c = null;
		
		switch(coord) {
			case N:
			case S:
				c = Cursor.getPredefinedCursor(
						Cursor.N_RESIZE_CURSOR);
				break;
			case NE:
			case SW:
				c = Cursor.getPredefinedCursor(
						Cursor.SW_RESIZE_CURSOR);
				break;
			case E:
			case W:
				c = Cursor.getPredefinedCursor(
						Cursor.E_RESIZE_CURSOR);
				break;
			case NW:
			case SE:
				c = Cursor.getPredefinedCursor(
						Cursor.NW_RESIZE_CURSOR);
				break;			
		}
		return c;
	}
	
	public boolean contains(Point point) {
		
		Point pt = getPosition();
		Rectangle r = new Rectangle(
				pt.x - 2*HSIZE,
				pt.y - 2*HSIZE,
				4*HSIZE + 1,
				4*HSIZE + 1);
		
		return r.contains(point);
	}
	
	public void move(int dx, int dy) {
		
		switch(coord) {
		case N:
			bbox.y += dy;
			bbox.height -= dy;
			break;
		case NE:
			break;
		case E:
			bbox.width += dx;
			break;
		case SE:
			break;
		case S:
			bbox.height += dy;
			break;
		case SW:
			break;
		case W:
			break;
		case NW:
			break;
		}
	}

	private Coordinate coord;
	private BoundBox bbox;
	public static final int HSIZE = 3;
}

