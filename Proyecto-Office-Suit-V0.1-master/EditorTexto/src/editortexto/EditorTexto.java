package editortexto;

import javax.swing.*;
import java.awt.*;

public class EditorTexto 
{
JMenuBar barraMenu = new JMenuBar();
	public static void main(String[] args)
	{
		InterfazUsuario ui = new InterfazUsuario();
        SwingUtilities.invokeLater(ui);
    }

}

