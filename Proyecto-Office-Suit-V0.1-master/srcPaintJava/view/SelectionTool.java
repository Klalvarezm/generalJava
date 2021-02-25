package view;

import java.awt.Point;
import java.awt.event.MouseEvent;

import controller.App;

public class SelectionTool extends Tool {

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		select();
	}

	private void select() {
		Point ptPressed = getPtPressed();
		Point ptReleased = getPtReleased();

		if (ptPressed.equals(ptReleased)) {
			App.getInstance().select(ptReleased);
		} else {
			App.getInstance().select(ptPressed, ptReleased);
		}

	}

	public void mouseDragged(MouseEvent e) {
		// TODO
	}

}