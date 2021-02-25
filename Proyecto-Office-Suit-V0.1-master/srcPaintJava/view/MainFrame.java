package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame(String title) {
		super(title);
		canvas = new Canvas();
		mmanager = new MenuManager();
	}

	public void setup() {
		add(mmanager, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);

		setActiveTool(ToolInterface.LINETOOL);
		mmanager.setup();
	}
	
	public int getActiveTool() {
		return canvas.getActiveTool();
	}
	
	public void setActiveTool(int actTool) {
		canvas.setActiveTool(actTool);
	}

	public void repaintCanvas() {
		canvas.repaint();
	}

	private MenuManager mmanager;
	private Canvas canvas;

}