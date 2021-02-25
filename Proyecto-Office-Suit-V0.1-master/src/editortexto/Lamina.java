package editortexto;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class Lamina extends JPanel
{
	
	public AreaPersonalizada area;
	public JMenu fuentes, estilo, tamano, fuentesDisponibles;
	public JPopupMenu myPopupMenu, popup;
	public JToolBar bar;

	
        public Lamina(AreaPersonalizada area)
	{
            this.area= area;
            fuentesDisponibles = new JMenu("Fuentes Disponibles");
		
		myPopupMenu = new JPopupMenu();
			
		setLayout(new BorderLayout());
		
		area.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel panelBar = new JPanel();
		JScrollPane panelArea = new JScrollPane(area);

		JMenuBar myMenuBar = new JMenuBar();
			
		fuentes = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamano = new JMenu("Tamaño");
		
		createItems(new String[]{"10","12","14","16","18","20","22","24","26"}, tamano);
		createItems(new String[]{"Negrita", "Cursiva", "Subrayado"}, estilo);
			
		fuentes.add(crearMenuFuentes());
			
		myMenuBar.add(fuentes);
		myMenuBar.add(estilo);
		myMenuBar.add(tamano);
		
		myMenuBar.setBackground(Color.WHITE);
		
		panelBar.add(myMenuBar);

		area.setComponentPopupMenu(myPopupMenu);
			
		bar =  new JToolBar();
			
		setUpBar(new ImageIcon("src/editortexto/Negrita.jpg")).addActionListener(new StyledEditorKit.BoldAction());
		setUpBar(new ImageIcon("src/editortexto/Cursiva.png")).addActionListener(new StyledEditorKit.ItalicAction());
		setUpBar(new ImageIcon("src/editortexto/Subrayado.jpg")).addActionListener(new StyledEditorKit.UnderlineAction());
		bar.addSeparator();
			
		setUpBar(new ImageIcon("src/editortexto/Izquierda.png")).addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_LEFT));
		setUpBar(new ImageIcon("src/editortexto/Centrado.png")).addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_CENTER));
		setUpBar(new ImageIcon("src/editortexto/Derecha.png")).addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_RIGHT));
		setUpBar(new ImageIcon("src/editortexto/Justificado.png")).addActionListener(new StyledEditorKit.AlignmentAction(null, StyleConstants.ALIGN_JUSTIFIED));
		bar.addSeparator();
                setUpBar2(new ImageIcon("src/editortexto/Pintura.jpg"));
                panelBar.add(bar);
		JLabel espacioIzquierda = new JLabel("                                       ");
		JLabel espacioDerecha = new JLabel("                                       ");
		JLabel espacioAbajo = new JLabel("                                       ");
		
		add(panelBar, BorderLayout.NORTH);
		add(panelArea, BorderLayout.CENTER);
		add(espacioIzquierda, BorderLayout.WEST);
		add(espacioDerecha, BorderLayout.EAST);
		add(espacioAbajo, BorderLayout.SOUTH);
	       
                
        
                pasar();
        }
        public AreaPersonalizada pasar(){
        return area;
        }	
	public JMenu crearMenuFuentes()
	{
		//Menu Fuentes
		popup = new JPopupMenu();
		
        popup.setLayout(new BorderLayout());
        popup.setPopupSize(100, 500);
        popup.setInvoker(fuentesDisponibles);
        
        fuentesDisponibles.addMouseListener(menuMouseListener);
       
        ActionListener l = new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
               popup.setVisible(false);
            }
        };
        
        String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        JPanel panel = new JPanel(new GridLayout(342,0));
        for(String i: fuentes) {
            JMenuItem item = new JMenuItem(i);
            item.addActionListener(l);
            item.addActionListener(new StyledEditorKit.FontFamilyAction(null, i));
            panel.add(item);
        }
        
        JScrollPane scrollPane = new JScrollPane(panel);
        popup.add(scrollPane);
        
        return fuentesDisponibles;
	}
	//Barra Cambio Letras	
	 public JButton setUpBar2(ImageIcon icono)
	{
		JButton button = new JButton(icono);
		
		button.setBackground(Color.WHITE);
	button.addActionListener(new GestionarColor());
		bar.add(button);
	        	
		return button;
	    
        }
        public JButton setUpBar(ImageIcon icono)
	{
		JButton button = new JButton(icono);
		
		button.setBackground(Color.WHITE);
	
		bar.add(button);
	        	
		return button;
	    
        }
		
	public void createItems(String[] myString, JMenu myMenu)
	{

		for (String i : myString)
		{
			JMenuItem myItem = new JMenuItem(i);
			myMenu.add(myItem);
				
			if(myMenu == estilo)
			{
				JMenuItem myItem2 = new JMenuItem(i);
					
				if(myItem.getText().equals("Negrita"))
					myItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
				else if (myItem.getText().equals("Cursiva"))
					myItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
				else if (myItem.getText().equals("Subrayado"))
					myItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
					
				myPopupMenu.add(myItem2);
					
				if (i.equals("Negrita"))
				{
					myItem.addActionListener(new StyledEditorKit.BoldAction());
					myItem2.addActionListener(new StyledEditorKit.BoldAction());
				}
					
				else if (i.equals("Cursiva"))
				{
					myItem.addActionListener(new StyledEditorKit.ItalicAction());
					myItem2.addActionListener(new StyledEditorKit.ItalicAction());
				}
					
				else
				{
					myItem.addActionListener(new StyledEditorKit.UnderlineAction());
					myItem2.addActionListener(new StyledEditorKit.UnderlineAction());
				}
			}
				
			else
			{
				myItem.addActionListener(new StyledEditorKit.FontSizeAction(null, Integer.parseInt(i)));
			}
		}
	}
	
	
	public MouseListener menuMouseListener = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if(!popup.isVisible())
            	showMenu();
            
            else
                popup.setVisible(false);
        }
 
       public void mouseEntered(MouseEvent e) {
           if(!popup.isVisible() && fuentesDisponibles.isSelected())
               showMenu();
       }
 
       public void mouseExited(MouseEvent e) {
           if(popup.isVisible() && !popup.contains(e.getPoint())) {
               popup.setVisible(false);
           }
       }
   };
 
   public void showMenu() {
       Rectangle r = fuentesDisponibles.getBounds();
       Point p = new Point(r.x, r.y+r.height);
       SwingUtilities.convertPointToScreen(p, fuentesDisponibles.getParent());
       popup.setLocation(p.x, p.y);
       popup.setVisible(true);
  }
	



class GestionarColor implements ActionListener
{

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Color selectColor=Color.BLACK;
        Color jColor = selectColor;

if ((jColor = JColorChooser.showDialog(area, "Select color", jColor)) != null) {
selectColor = jColor;
area.setForeground(selectColor);
}
        }
    
}
}



