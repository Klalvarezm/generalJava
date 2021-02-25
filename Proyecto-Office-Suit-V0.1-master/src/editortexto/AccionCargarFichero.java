package editortexto;
import java.awt.Event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;



public class AccionCargarFichero extends AbstractAccionFichero
{
    
    private static final long serialVersionUID = 7764384764137362305L;

   
    public AccionCargarFichero(JTextComponent componenteTexto)
    {
    	// Configurar clase padre para que sea CARGAR fichero.
        super(componenteTexto, Opciones.CARGAR);
        
        // Etiqueta y tecla aceleradora
        this.putValue(Action.NAME, "Abrir ...");
        this.putValue(
            Action.ACCELERATOR_KEY,
            KeyStroke.getAWTKeyStroke('A', Event.CTRL_MASK));
    }

    /**
     * Le el fichero que se le pasa y pone el contenido en el JTextArea.
     *
     * @param fichero Fichero a leer
     *
     * @throws FileNotFoundException No se puede abrir el fichero.
     */
    @Override
    protected void actuarSobreElFichero(File fichero)
        throws FileNotFoundException
    {
    	// Se prepara el reader para leer el fichero. Un StringBuffer para compener el
    	// texto total de forma eficiente, que diría rfilgueiras.
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        StringBuffer bufferTexto = new StringBuffer();

        try
        {
            String linea = reader.readLine();

            while (linea != null)
            {
            	// Se va añadiendo las líneas que se leen y un separador de línea
            	// adecuado para el sistema operativo. Este último puede ser /n o /r/n
            	// dependiendo de si es unix o windows. System.getProperty("line.separator")
            	// nos da el adecuado.
                bufferTexto.append(linea);
                bufferTexto.append(System.getProperty("line.separator"));
                
                // Siguiente linea.
                linea = reader.readLine();
            }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(
                componenteTexto, e, "Error al leer fichero",
                JOptionPane.ERROR_MESSAGE);
        }

        // Se pone el texto leido en el JTextArea.
        componenteTexto.setText(bufferTexto.toString());
    }
}
