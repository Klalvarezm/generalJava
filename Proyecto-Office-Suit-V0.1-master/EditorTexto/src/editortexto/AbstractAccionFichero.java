/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import java.awt.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;



public abstract class AbstractAccionFichero extends AbstractAction
{
    /** 
     * Componente con el texto que se quiere salvar o en el que se quiere mostrar el
     * contenido del fichero.
     */
    protected JTextComponent componenteTexto;

    /** 
     * Panel que permite elegir un fichero del disco y navegar.  
     */
    private JFileChooser fileChooser = null;

    /** 
     * Si la acción va a ser para salvar o para cargar. 
     */
    private Opciones opcion;

    /** Enumerado con las posibles opciones para la acción */
    public enum Opciones
    {
    	SALVAR, CARGAR;
    }

    /**
     * Crea un nuevo objeto AbstractAccionFichero.
     *
     * @param componenteTexto Componente de texto sobre el que actuar, salvando su
     * contenido o mostrando en él el contenido de un fichero.
     * @param opcion SALVAR o CARGAR.
     */
    public AbstractAccionFichero(
        JTextComponent componenteTexto, Opciones opcion)
    {
        this.componenteTexto = componenteTexto;
        this.opcion = opcion;
    }

    /**
     * Se ha pulsado el botón y se muestra el File Chooser.
     *
     * @param arg0 Evento de pulsación del botón.
     */
    public void actionPerformed(ActionEvent arg0)
    {
    	// Se crea el FileChooser si no estaba creado.
        if (fileChooser == null)
        {
            fileChooser = new JFileChooser();
        }

        int opcionSeleccionada;

        // Se muestra el FileChooser como dialogo de salvar o de cargar según la opción
        // SALVAR o CARGAR que se haya pasado en el constructor.
        if (opcion == Opciones.SALVAR)
        {
            opcionSeleccionada = fileChooser.showSaveDialog(componenteTexto);
        }
        else
        {
            opcionSeleccionada = fileChooser.showOpenDialog(componenteTexto);
        }

        // Si el usuario elige un fichero y pulsa "OK"...
        if (JFileChooser.APPROVE_OPTION == opcionSeleccionada)
        {
        	// Se obtiene el fichero
            File fichero = fileChooser.getSelectedFile();

            try
            {
            	// Se salva o carga. Las clases hijas deben redefinir este método.
                actuarSobreElFichero(fichero);
            }
            catch (Exception e)
            {
            	// Mensaje de error si se produce.
                JOptionPane.showMessageDialog(
                    componenteTexto, e, "Error en el fichero " + fichero,
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Las clases hijas deben salvar el contenido del area de texto en el fichero que se
     * pasa como parámetro o leer el fichero y meter su contenido en el area de texto.
     *
     * @param fichero Fichero que se debe leer o en el que se debe grabar.
     *
     * @throws FileNotFoundException Excepción si el fichero no existe.
     */
    protected abstract void actuarSobreElFichero(File fichero)
        throws FileNotFoundException;
}