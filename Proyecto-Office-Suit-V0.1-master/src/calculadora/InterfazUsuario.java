package calculadora;

import javax.swing.*;
import java.awt.*;
import java.net.*;

public class InterfazUsuario implements Runnable
{
	private JFrame frame;
	
	@Override
	public void run() 
	{
		frame = new JFrame();
		
		int anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
		int largoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
				
        frame.setPreferredSize(new Dimension(350, 400));
        frame.setLocation(anchoPantalla/2-175, largoPantalla/2-200);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        URL rutaLogo = InterfazUsuario.class.getResource("Logo.png");
        
        frame.setTitle("Calculadora");
        
        createComponents(frame.getContentPane());
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(rutaLogo));
        
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
	}
	
	private void createComponents(Container container) 
    {
    	Lamina LaminaCalculadora = new Lamina();
    	
    	container.add(LaminaCalculadora);
    }
	
	 public JFrame getFrame() 
	 {
		 return frame;
	 }

}
