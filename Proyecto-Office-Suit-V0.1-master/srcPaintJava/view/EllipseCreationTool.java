package view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import model.Ellipse;
import model.Figure;

public class EllipseCreationTool extends CreationTool {

	@Override
	protected Figure doCreateFigure() {

		Point ptPressed = getPtPressed();
		Point ptReleased = getPtReleased();

		return new Ellipse(ptPressed, new Dimension(ptReleased.x - ptPressed.x,
				ptReleased.y - ptPressed.y));
	}

	public void mouseDragged(MouseEvent e) {
		// TODO
	}

}
