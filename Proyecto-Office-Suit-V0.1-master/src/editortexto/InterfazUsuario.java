package editortexto;

import javax.swing.*;
import java.awt.*;
import java.net.*;
public class InterfazUsuario implements Runnable
{
  AreaPersonalizada area=new AreaPersonalizada();
  
  
  static JPanel panelBar = new JPanel();
	private JFrame frame;
	
	@Override
	public void run() 
	{
		frame = new JFrame();
                
                
                
               JMenuBar barraMenu = new JMenuBar();
                construyeMenuArchivo(barraMenu);
                 frame.getContentPane().add(barraMenu, BorderLayout.NORTH); 
               
               
		
int anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
		int largoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
				
        frame.setPreferredSize(new Dimension(800, 700));
        frame.setLocation(anchoPantalla/2-400, largoPantalla/2-350);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        URL rutaLogo = InterfazUsuario.class.getResource("Logo.png");
        
        frame.setTitle("Editor de Texto");
        //Este Es el frame Completo (Todo menos archivo)
        createComponents(frame.getContentPane());
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(rutaLogo));
        
        frame.pack();
        frame.setVisible(true);
	}
	
	private void createComponents(Container container) 
    {
    	
        Lamina laminaEditorTexto = new Lamina(area);
    	
    	container.add(laminaEditorTexto);
    }
	
	public JFrame getFrame() 
	{
		return frame;
	
        }

   
       
        public void construyeMenuArchivo(JMenuBar barraMenu)
    {
    	
   
      JMenuItem salvar = new JMenuItem(new AccionSalvarFichero(area));
        JMenuItem cargar = new JMenuItem(new AccionCargarFichero(area));
        JMenuItem salir = new JMenuItem(new AccionSalir(area));
        JMenuItem buscar = new JMenuItem(new AccionBuscar(area));
        
        JMenu menuArchivo = new JMenu("Archivo");
        
        menuArchivo.add(salvar);
        menuArchivo.add(cargar);
        menuArchivo.add(salir);
        barraMenu.add(menuArchivo);
       
    }

        
       
}
        class AreaPersonalizada extends JTextPane
{
	
	public boolean getScrollableTracksViewportWidth() 
	{
		return true;
	}

    
	

       
}