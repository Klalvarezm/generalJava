package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lamina extends JPanel
{
	boolean punto = true;
	boolean borrar = false;
	JTextArea d_anterior, d_posterior;
	JPanel panelBotones;
	
	public Lamina()
	{
		setLayout(new BorderLayout());
	
		JPanel panelDisplays = new JPanel();
		
		Box boxDisplays = Box.createVerticalBox();
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(5,4));
		
		d_anterior = new JTextArea(2,19);
		d_posterior = new JTextArea(2,19);
		
		d_anterior.setEditable(false);
		d_posterior.setEditable(false);
		
		d_anterior.setFont(new Font("Arial", Font.BOLD, 20));
		d_posterior.setFont(new Font("Arial", Font.BOLD, 20));
		
		d_anterior.setBackground(new Color(76,215,177));
		d_posterior.setBackground(new Color(76,215,177));
		d_anterior.setForeground(Color.WHITE);
		d_posterior.setForeground(Color.WHITE);
		
		JScrollPane scrollDisplay = new JScrollPane(d_posterior,21,30);
		JScrollPane scrollDisplay2 = new JScrollPane(d_anterior,21,30);
		
		boxDisplays.add(scrollDisplay2);
		boxDisplays.add(Box.createVerticalStrut(10));
		boxDisplays.add(scrollDisplay);
		
		panelDisplays.add(boxDisplays);
	
		String[] nombreBotones = {"C","CE","<<<","*","7","8","9","-","4","5","6","+","1","2","3","/","x^2","0",".","="};
		crearComponentes(nombreBotones);
		
		panelDisplays.setBackground(new Color(71,75,79));
		
		add(panelDisplays,BorderLayout.NORTH);
		add(panelBotones, BorderLayout.CENTER);
		
		setBackground(Color.BLACK);
	}
	
	private void crearComponentes(String nombres[])
	{
		for(String i: nombres)
		{
			JButton boton = new JButton(i);
		
			boton.setBackground(new Color(49,167,241));
			boton.setForeground(Color.WHITE);
			
			panelBotones.add(boton);
			
			boton.addActionListener(new GestionaEvento());
		}
	}
	
	private class GestionaEvento implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			char c = e.getActionCommand().charAt(0);
			
			if(!d_posterior.getText().equals("Infinity"))
			{
				if (((c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
						|| c == '8' || c == '9') && borrar)) {
					d_posterior.setText(null);
					d_posterior.setText(e.getActionCommand());
					borrar = false;
					punto = true;
				}
				
				else if ((c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
						|| c == '8' || c == '9'))
					d_posterior.setText(d_posterior.getText() + e.getActionCommand());

				

				else if (c == '*' || c == '+' || c == '-' || c == '/') {
					try {
						operacion(c);
					} catch (ArithmeticException ex) {
						JOptionPane.showMessageDialog(Lamina.this, "No se puede realizar división por cero",
								"Indeterminación", 0);
						d_posterior.setText(null);
					}

				}

				else if (c == '=' && !d_anterior.getText().isEmpty()) {
					try {
						operacion(c);
					} catch (ArithmeticException ex) {
						JOptionPane.showMessageDialog(Lamina.this, "No se puede realizar división por cero",
								"Indeterminación", 0);
						d_posterior.setText(null);
					}
				}

				else if (c == '<' && !d_posterior.getText().isEmpty() && !borrar) {
					if (d_posterior.getText().charAt(d_posterior.getText().length() - 1) == '.')
						punto = true;

					d_posterior.setText(d_posterior.getText().substring(0, d_posterior.getText().length() - 1));
				}

				else if (c == 'x' && !d_posterior.getText().isEmpty())
					d_posterior.setText(String.valueOf(Math.pow(Double.parseDouble(d_posterior.getText()), 2)));

				else if (c == '.' && punto) {
					if(d_posterior.getText().isEmpty())
					{
						d_posterior.setText("0.");
						punto = false;
					}
					else
					{
						d_posterior.setText(d_posterior.getText() + '.');
						punto = false;
					}
				}

				else if (e.getActionCommand().equals("CE"))
					d_posterior.setText(null);

				else if (e.getActionCommand().equals("C")) {
					d_anterior.setText(null);
					d_posterior.setText(null);
					punto = true;
				}
			}
			
			else if(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
						|| c == '8' || c == '9')
			{
				d_posterior.setText(null);
				d_posterior.setText(e.getActionCommand());
			}
			
			else
				d_posterior.setText(null);
		}
		
		private  void operacion(char c) throws ArithmeticException
		{
			if(d_posterior.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(Lamina.this, "Por favor no deje campos vacíos", "Campo vacío", 0);
			}
			
			else if(d_anterior.getText().isEmpty() && c != '=')
			{
				
				d_anterior.setText(d_posterior.getText()+c);
				d_posterior.setText(null);
				punto = true;
			}
			
			else if(d_posterior.getText().equals("0") && d_anterior.getText().charAt(d_anterior.getText().length() - 1) == '/')
				throw new ArithmeticException("División por cero");
			
			else
			{
				double primerNumero = Double.parseDouble(d_anterior.getText().substring(0, d_anterior.getText().length() - 1));
				double segundoNumero = Double.parseDouble(d_posterior.getText());
				char signo = d_anterior.getText().charAt(d_anterior.getText().length() - 1);
				double resultado;
				
				if (signo == '+')
					resultado = primerNumero + segundoNumero;

				else if (signo == '-')
					resultado = primerNumero - segundoNumero;

				else if (signo == '*')
					resultado = primerNumero * segundoNumero;

				else
					resultado = primerNumero / segundoNumero;
				
				
				if(c=='=')
				{
					d_posterior.setText(String.valueOf(resultado));
					d_anterior.setText(null);
					borrar = true;
					punto = false;
					
					try 
					{
						FileWriter writing = new FileWriter("C:\\Users\\juamp\\Documents\\Archivos Programación\\Ejercicios en Eclipse\\Curso Java Pildoras Informáticas\\Ejecutables\\Historial.txt", true);
						BufferedWriter bw = new BufferedWriter(writing);
						PrintWriter pw = new PrintWriter(bw);
						
						bw.write("" + primerNumero+" " + signo + " " + segundoNumero + " = " + resultado);
						bw.newLine();
							
						bw.close();
						pw.close();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				
				else
				{
					d_anterior.setText(String.valueOf(resultado)+c);
					d_posterior.setText(null);
					punto = true;
				}
			}
		}
		
	}
	
}