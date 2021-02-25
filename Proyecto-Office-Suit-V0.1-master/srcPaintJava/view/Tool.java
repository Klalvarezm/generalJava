package view;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.Figure;

public abstract class Tool {

	public void mousePressed(MouseEvent e) {
		mePressed = e;
	}

	public void mouseReleased(MouseEvent e) {
		meReleased = e;
	}

	public abstract void mouseDragged(MouseEvent e);

	public void mouseMoved(MouseEvent e) {
		// Placeholder
	}

	protected Point getPtPressed() {
		return mePressed.getPoint();
	}

	protected Point getPtReleased() {
		return meReleased.getPoint();
	}
	
	public void setFigure(Figure f) {
		selFigure = f;
	}
	
	public void setControlPoint(ControlPoint cp) {
		cpSelected = cp;
	}
	
	protected Figure selFigure;
	protected ControlPoint cpSelected;

	private MouseEvent mePressed;
	private MouseEvent meReleased;
}
