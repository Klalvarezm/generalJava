package calculadora;

import java.io.*;
import java.util.GregorianCalendar;
import javax.swing.SwingUtilities;

public class Calculadora 
{

	public static void main(String[] args) 
	{
		GregorianCalendar calendar = new GregorianCalendar();
		
		try 
		{
			FileWriter writing = new FileWriter("Historial.txt", true);
			BufferedWriter bw = new BufferedWriter(writing);
			PrintWriter pw = new PrintWriter(bw);
			
			bw.write(calendar.getTime()+"");
			bw.newLine();
				
			bw.close();
			pw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		InterfazUsuario ui = new InterfazUsuario();
        SwingUtilities.invokeLater(ui);
    }

}




