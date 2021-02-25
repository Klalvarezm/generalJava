package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import model.Figure;
import controller.App;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Canvas() {
		
		super();
		setBackground(Color.WHITE);

		tools = new Tool[ToolInterface.NUMTOOLS]; // 2. Construction

		// 3. Initialization
		tools[ToolInterface.LINETOOL] = new LineCreationTool();
		tools[ToolInterface.RECTTOOL] = new RectCreationTool();
		tools[ToolInterface.ELLITOOL] = new EllipseCreationTool();
		tools[ToolInterface.TEXTTOOL] = new TextCreationTool();
		tools[ToolInterface.SELETOOL] = new SelectionTool();
		tools[ToolInterface.MOVETOOL] = new MoveTool();
		tools[ToolInterface.RESIZETOOL] = new ResizeTool();

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				
				if ( cpSelected != null ) {
					savedTool = activeTool;
					setActiveTool(ToolInterface.
							RESIZETOOL);
					tools[activeTool].setControlPoint(
							cpSelected);
				}
				else if ( figSelected != null ) {
					savedTool = activeTool;
					setActiveTool(ToolInterface.
							MOVETOOL);
					tools[activeTool].setFigure(
							figSelected);
				}
				else {				
					App.getInstance().deselectAll();
				}
				
				tools[activeTool].mousePressed(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				tools[activeTool].mouseReleased(e);
				tools[activeTool].setFigure(null);				
				tools[activeTool].setControlPoint(null);				
				if ( figSelected != null ) {
					activeTool = savedTool;
					figSelected = null;
				}
			}
		});

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				tools[activeTool].mouseDragged(e);
				
				if ( figSelected != null ) {
					repaint();
				}
			}
		
			@Override
			public void mouseMoved(MouseEvent e) {
				cpSelected = App.getInstance().getControlPoint(
						e.getPoint());
				if ( cpSelected != null ) {
					setCursor(cpSelected.getCursor());
				}
				else {
					figSelected = App.getInstance().getFigure(
							e.getPoint());
					if ( figSelected != null ) {
						setCursor(
								Cursor.getPredefinedCursor(
										Cursor.MOVE_CURSOR));
					}
					else {
					setCursor(
							Cursor.getPredefinedCursor(
									Cursor.DEFAULT_CURSOR));
					}
				}
			}
		});
	}
	
	public int getActiveTool() {
		return activeTool;
	}

	public void setActiveTool(int actTool) {
		if (0 <= actTool && actTool < ToolInterface.NUMTOOLS) {
			activeTool = actTool;
		} else {
			throw new IllegalArgumentException("Out of range tool index!");
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		App.getInstance().paint((Graphics2D) g);
	}

	// State pattern
	private int activeTool;
	private int savedTool;
	private Tool[] tools; // 1. Declaration
	private Figure figSelected;
	private ControlPoint cpSelected;
}
