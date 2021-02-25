package editortexto;

import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.Caret;
import javax.swing.text.JTextComponent;



public class AccionBuscar extends AbstractAction
{
    
    private static final long serialVersionUID = -3542731242829577691L;

    
    private JTextComponent areaTexto;

   
    public AccionBuscar(JTextComponent areaTexto)
    {
        this.areaTexto = areaTexto;
        
        
        this.putValue(Action.NAME, "Buscar ...");
        this.putValue(
            Action.ACCELERATOR_KEY,
            KeyStroke.getAWTKeyStroke('B', Event.CTRL_MASK));
    }

   
    public void actionPerformed(ActionEvent arg0)
    {
    	
        String textoABuscar = areaTexto.getSelectedText();

        if (textoABuscar == null)
        {
            textoABuscar = "";
        }

        
        textoABuscar = JOptionPane.showInputDialog(
                areaTexto, "Texto a buscar", textoABuscar);

        
        String texto = areaTexto.getText();
        
       
        Caret seleccion = areaTexto.getCaret();
        int posicion = 0;
        if (seleccion.getDot() != seleccion.getMark())
        {
            posicion = seleccion.getDot();
        }

       
        posicion = texto.indexOf(textoABuscar, posicion);

        // Si no se encuentra el texto, se termina.
        if (posicion == -1)
        {
            return;
        }

        // Se selecciona el texto encontrado. Valdría la llamada a areaTexto.select(),
        // pero dice la API que es mejor llamar a esto.
        areaTexto.setCaretPosition(posicion);
        areaTexto.moveCaretPosition(posicion + textoABuscar.length());
    }
}
