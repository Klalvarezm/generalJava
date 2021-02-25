package controller;

import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Drawing;
import model.Figure;
import view.ControlPoint;
import view.MainFrame;

public class App {

	// Singleton
	private static App instance = new App();

	private App() {
		drawing = new Drawing();
		frame = new MainFrame(APPNAME);
	}

	// Singleton
	public static App getInstance() {
		return instance;
	}

	public void setup() {
		frame.setup();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	public void paint(Graphics2D g) {
		drawing.doPaint(g);
	}

	public void addFigure(Figure f) {
		drawing.addFigure(f);
		frame.repaintCanvas();
	}
	
	public void clearDrawing() {
		drawing.clear();
		frame.repaintCanvas();
	}
	
	public int getActiveTool() {
		return frame.getActiveTool();
	}
	
	public void setActiveTool(int actTool) {
		frame.setActiveTool(actTool);
	}

	public void select(Point ptReleased) {
		if ( drawing.select(ptReleased) ) {
			frame.repaintCanvas();
		}
	}

	public void select(Point ptPressed, Point ptReleased) {
		if ( drawing.select(ptPressed, ptReleased) ) {
			frame.repaintCanvas();
		}
	}

	public void newDrawing() {
		
		if ( drawing.isModified() ){
			int r = JOptionPane.showConfirmDialog(
					frame,
					"El dibujo ha sido modificado. �Desea guardarlo?", "Aviso", 
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if ( r == JOptionPane.CANCEL_OPTION ){
				// Nothing to do
			}
			else if ( r == JOptionPane.YES_OPTION ) {
				saveDrawing();
			}
			else
			{
				drawing.clear();
				frame.repaintCanvas();
			}
		} else {
			drawing.clear();
			frame.repaintCanvas();
		}
		// 1. drawing.isModified() ?
		// 1.1 No : drawing.clear()
		// 1.2 Si : Prompt : �Desea guardar?
		// 1.2.1 No : drawing.clear()
		// 1.2.2 Si : drawing.getFileName() ?
		// 1.2.2.1 fn != null : drawing.save()
		// 1.2.2.2 fn == null : saveAsDrawing()
	}

	private void openDrawing(String docName) {
		try {
			ObjectInputStream stream = new ObjectInputStream(
					new FileInputStream(docName));
			drawing.open(stream);
			stream.close();
			frame.repaintCanvas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openDrawing() {
	}

	public int saveDrawing() {
		
		int r = JFileChooser.CANCEL_OPTION;
		
		String docName = drawing.getDocName();
		if ( docName == null ){
			JFileChooser choo = new JFileChooser(
					System.getProperty("user.dir"));
			choo.setDialogType(JFileChooser.SAVE_DIALOG);
			choo.setVisible(true);
			File f = choo.getSelectedFile();
			if ( f == null ){
				// Nothing to do
			}
			else {
				if ( f.canWrite() ) {
					if ( f.exists() ) {
						int rr = JOptionPane.showConfirmDialog(
								frame,
								"El archivo ya existe. �Desea sobreescribirlo?",
								APPNAME, 
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.WARNING_MESSAGE);
						if ( rr == JOptionPane.CANCEL_OPTION ){
							// Nothing to do
						}
						else if ( rr == JOptionPane.YES_OPTION ) {
							docName = f.getAbsolutePath();
							r = saveDrawing(docName)
									? JOptionPane.OK_OPTION
									: JOptionPane.NO_OPTION;
						}
						else if ( rr == JOptionPane.NO_OPTION ) {
							r = saveDrawing();
						}
					}
					else {
						docName = f.getAbsolutePath();
						r = saveDrawing(docName)
								? JOptionPane.OK_OPTION
								: JOptionPane.NO_OPTION;
					}
				}
				else {
					JOptionPane.showMessageDialog(frame,
							"El usuario activo no tiene permisos para escribir en la carpeta seleccionada!", 
							APPNAME, 
							JOptionPane.WARNING_MESSAGE);
					r = saveDrawing();
				}
			}
		}
		
		return r;
	}

	private boolean saveDrawing(String docName) {
		
		boolean b = true;
		
		try {
			ObjectOutputStream stream = new ObjectOutputStream(
					new FileOutputStream(docName));
			drawing.save(stream);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		
		return b;
	}

	public void saveAsDrawing() {
		// 1. Open JFileChooser
		// 1.1 Cancelado : Nada
		// 1.2 Guardar : 
		//		JFileChooser.getFileName()
		// 		verificar si ya existe
		// 		1.2.1 no existe : permiso ?
		//		1.2.1.1 si: crear stream
		// 		drawing.save(stream)
		//		stream.close()
		//		1.2.1.2 no: ir a 1.
		// 		1.2.2 existe : Preguntar �Desea sobreescribir?
		//		1.2.2.1 si : ir a 1.2.1.1.
		// 		1.2.2.2 no : ir a 1.
	}

	public void exit() {
		// TODO Dise�ar...
		System.exit(0);
	}
	
	public void deselectAll() {
		drawing.deselectAll();
		frame.repaintCanvas();
	}
	
	public static void main(String[] args) {
		App app = getInstance();
		app.setup();
	}
	
	private MainFrame frame;
	private Drawing drawing;
	private static final String APPNAME = "Editor Gráfico";

	public ControlPoint getControlPoint(Point point) {
		return drawing.getControlPoint(point);
	}

	public Figure getFigure(Point point) {
		return drawing.getFigure(point);
	}

}