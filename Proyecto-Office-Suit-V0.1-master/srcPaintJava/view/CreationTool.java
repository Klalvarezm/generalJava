package view;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.Figure;
import controller.App;

public abstract class CreationTool extends Tool {

	protected abstract Figure doCreateFigure();

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		createFigure();
	}

	// Template Method pattern
	private final void createFigure() {
		Point ptPressed = getPtPressed();
		Point ptReleased = getPtReleased();

		if (ptPressed.equals(ptReleased)) {
			// Nothing to do
		} else {
			Figure f = doCreateFigure();
			if (f != null) {
				App.getInstance().addFigure(f);
			}
		}
	}
}
