package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;


//import static org.junit.Assert.assertThat;

//import org.junit.Assert;
//import org.junit.Test;

import utils.IShape;
import view.BoundBox;
import view.ControlPoint;

public class Drawing implements IShape {

	public Drawing() {
		super();
		list = new LinkedList<>();
		// checkSize();
	}

	//@Test
	public void checkSize() {

		Point pt = new Point(600, 100);
		Dimension sz = new Dimension(-500, 300);

		Line l = new Line(pt, sz);
		addFigure(l);
		sz.setSize(600, 400);
		addFigure(new Rectangle(pt, sz));
		sz.setSize(200, 100);
		addFigure(new Ellipse(pt, sz));
		sz.setSize(300, 50);
		addFigure(new Text(pt, sz));
		//Assert.assertTrue(getSize() == 4);
                
	}

	public void doPaint(Graphics2D g) {

		// Iterator
		for (Figure f : list) {

			f.paint(g);
		}
	}

	private int getSize() {
		return list.size();
	}

	public void addFigure(Figure f) {
		list.add(f);
		setModified(true);
	}

	public void removeFigure(Figure f) {
		list.remove(f);
		setModified(true);
	}
	
	public void clear() {
		list.clear();
		setModified(false);
	}

	public boolean select(Point pt) {
		for (int i = list.size() - 1; i >= 0; i--) {
			Figure f = list.get(i);
			if (f.contains(pt)) {
				f.setSelected(true);
				break;
			}
		}
		// TODO
		return true;
	}

	public boolean select(Point ptPressed, Point ptReleased) {
		BoundBox selBBox = new BoundBox(ptPressed, ptReleased);
		for (Figure f : list) {
			if (selBBox.contains(f.getNormBoundBox())) {
				f.setSelected(true);
			}
		}
		// TODO
		return true;
	}
	
	public void deselectAll() {
		for (Figure f : list) {
			f.setSelected(false);
		}
	}
	
	public ControlPoint getControlPoint(Point point) {
		
		ControlPoint cp = null;
		
		for(Figure f : list) {
			if ( f.isSelected() ){
				cp = f.getControlPoint(point);
				if ( cp != null ) {
					break;
				}
			}
		}
		
		return cp;
	}

	public static void main(String[] args) {
		Drawing d = new Drawing();
		d.checkSize();
	}

	public void save(ObjectOutputStream stream) throws IOException {
		stream.writeObject(list);
		setModified(false);
	}
	
	@SuppressWarnings("unchecked")
	public void open(ObjectInputStream stream) throws ClassNotFoundException, IOException {
		list = (List<Figure>)stream.readObject();
		setModified(false);
	}
	
	public boolean isModified() {
		return modified;
	}
	
	private void setModified( boolean b ){
		modified = b;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Figure getFigure(Point point) {
		
		Figure fig = null;
		
		for(int i = list.size() - 1; i >= 0; i--) {
			
			Figure f = list.get(i);
			if ( f.isSelected() && f.contains(point) ){
				fig = f;
				break;
			}
		}
		return fig;
	}
	
	private List<Figure> list;
	private String docName;
	private boolean modified;
}
