package view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import model.Figure;
import model.Text;

public class TextCreationTool extends CreationTool {

	@Override
	protected Figure doCreateFigure() {

		Point ptPressed = getPtPressed();
		Point ptReleased = getPtReleased();

		return new Text(ptPressed, new Dimension(ptReleased.x - ptPressed.x,
				ptReleased.y - ptPressed.y));
	}

	public void mouseDragged(MouseEvent e) {
		// TODO
	}

}
