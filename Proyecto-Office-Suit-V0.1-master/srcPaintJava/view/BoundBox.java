package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import model.Figure;
import utils.IShape;
import view.ControlPoint.Coordinate;

public class BoundBox extends Rectangle implements IShape {

	private static final long serialVersionUID = 1L;

	public BoundBox(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public BoundBox(Point p, Dimension d) {
		super(p, d);
	}

	// Copy Constructor
	public BoundBox(BoundBox bb) {
		super(bb);
	}

	public BoundBox(Point ptPressed, Point ptReleased) {
		super(ptPressed.x, ptPressed.y, ptReleased.x - ptPressed.x,
				ptReleased.y - ptPressed.y);
	}
	
	public void init() {
		buildControlPoints();
	}
	
	public void doMove(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	private void buildControlPoints() {
		cPoints = new ControlPoint[NCPOINTS];
		Coordinate[] coords = Coordinate.values();
		for(int i = 0; i < NCPOINTS; i++){
			cPoints[i] = new ControlPoint(
					this.getNormBoundBox(),
					coords[i]);
		}
	}

	private void createNormBoundBox() {
		if (norm == null) {
			if (width < 0 || height < 0) {
				norm = new BoundBox(this);
				norm.normalize();
			} else {
				norm = this;
			}
		} else {
			// nothing to do
		}
	}

	public BoundBox getNormBoundBox() {
		if ( norm == null ) {
			createNormBoundBox();
		}
		return norm;
	}

	public void normalize() {
		if (width < 0) {
			width = -width;
			x = x - width;
		}
		if (height < 0) {
			height = -height;
			y = y - height;
		}
	}

	@Override
	public void doPaint(Graphics2D g) {
		createNormBoundBox();
		g.setColor(Color.RED);
		g.drawRect(norm.x, norm.y, norm.width, norm.height);
		for(ControlPoint cp : cPoints){
			cp.doPaint(g);
		}
	}
	
	public ControlPoint getControlPoint(Point point) {
		
		ControlPoint cp = null;
		
		for(ControlPoint cpp : cPoints) {
			if ( cpp.contains(point) ){
				cp = cpp;
				break;
			}
		}
		
		return cp;
	}

	public static void main(String[] args) {
		BoundBox a = new BoundBox(100, 200, -100, -200);
		a.normalize();
		System.out.println(a);
	}

	public static final int NCPOINTS = Coordinate.values().length;
	private ControlPoint[] cPoints;
	private BoundBox norm;
}
