package view;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class ResizeTool extends Tool {

	@Override
	public void mousePressed( final MouseEvent me ) {
		super.mousePressed( me );
		ptPressed = getPtPressed();
	}
	
	@Override
	public void mouseDragged( final MouseEvent me ) {
		if ( cpSelected != null && ptPressed != null ) {
			Point pt = me.getPoint();
			cpSelected.move(
					pt.x - ptPressed.x,
					pt.y - ptPressed.y);
			ptPressed.x = pt.x;
			ptPressed.y = pt.y;
		}
	}

	@Override
	public void mouseReleased( final MouseEvent me ) {
		
		super.mouseReleased( me );
		ptPressed = null;		
	}
	
	private Point ptPressed;
}
