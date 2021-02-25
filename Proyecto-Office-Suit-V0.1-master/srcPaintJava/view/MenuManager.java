package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import controller.App;

public class MenuManager extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	
	public MenuManager() {
			
		JMenu file = new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		newFile.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().newDrawing();
			}
		});
		file.add(newFile);
		
		file.add(new JSeparator());
		
		JMenuItem openFile = new JMenuItem("Open");
		openFile.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().openDrawing();
			}
		});
		file.add(openFile);
		
		JMenuItem saveFile = new JMenuItem("Save");
		saveFile.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().saveDrawing();
			}
		});
		file.add(saveFile);
				
		JMenuItem saveAsFile = new JMenuItem("Save As");
		saveAsFile.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().saveAsDrawing();
			}
		});
		file.add(saveAsFile);
		
		file.add(new JSeparator());
	
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().exit();
			}
		});
		file.add(quit);
		
		JMenu tools = new JMenu("Tools");
		lineTool = new JCheckBoxMenuItem("Line Creation");
		lineTool.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				unmarkMenuItem(items[App.getInstance().getActiveTool()]);
				App.getInstance().setActiveTool(ToolInterface.LINETOOL);
				markMenuItem(items[App.getInstance().getActiveTool()]);
			}
		});
		rectTool = new JCheckBoxMenuItem("Rectangle Creation");
		rectTool.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				unmarkMenuItem(items[App.getInstance().getActiveTool()]);
				App.getInstance().setActiveTool(ToolInterface.RECTTOOL);
				markMenuItem(items[App.getInstance().getActiveTool()]);
			}
		});
		elliTool = new JCheckBoxMenuItem("Ellipse Creation");
		elliTool.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				unmarkMenuItem(items[App.getInstance().getActiveTool()]);
				App.getInstance().setActiveTool(ToolInterface.ELLITOOL);
				markMenuItem(items[App.getInstance().getActiveTool()]);
			}
		});
		textTool = new JCheckBoxMenuItem("Text Creation");
		textTool.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				unmarkMenuItem(items[App.getInstance().getActiveTool()]);
				App.getInstance().setActiveTool(ToolInterface.TEXTTOOL);
				markMenuItem(items[App.getInstance().getActiveTool()]);
			}
		});
		seleTool = new JCheckBoxMenuItem("Selection Tool");
		seleTool.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				unmarkMenuItem(items[App.getInstance().getActiveTool()]);
				App.getInstance().setActiveTool(ToolInterface.SELETOOL);
				markMenuItem(items[App.getInstance().getActiveTool()]);
			}
			
		});
		tools.add(lineTool);
		tools.add(rectTool);
		tools.add(elliTool);
		tools.add(textTool);
		tools.add(seleTool);
		
		JMenu edit = new JMenu("Edit");
		JMenuItem clear = new JMenuItem("Clear Drawing");
		clear.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().clearDrawing();
			}
		});
		edit.add(clear);
		
		add(file);
		add(edit);
		add(tools);
	
		items = new JCheckBoxMenuItem[ToolInterface.NUMTOOLS];
		
		items[ToolInterface.LINETOOL] = lineTool;
		items[ToolInterface.RECTTOOL] = rectTool;
		items[ToolInterface.ELLITOOL] = elliTool;
		items[ToolInterface.TEXTTOOL] = textTool;
		items[ToolInterface.SELETOOL] = seleTool;
	}
	
	public void setup() {
		markMenuItem(items[App.getInstance().getActiveTool()]);
	}
	
	public void markMenuItem(JCheckBoxMenuItem mi) {
		if ( mi != null ) mi.setSelected(true);
	}
	
	public void unmarkMenuItem(JCheckBoxMenuItem mi) {
		if ( mi != null ) mi.setSelected(false);
	}
	
	private JCheckBoxMenuItem lineTool;
	private JCheckBoxMenuItem rectTool;
	private JCheckBoxMenuItem elliTool;
	private JCheckBoxMenuItem textTool;
	private JCheckBoxMenuItem seleTool;
	private JCheckBoxMenuItem[] items;

}
