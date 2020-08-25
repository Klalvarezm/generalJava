
import java.lang.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

//Este codigo comentariado sirve para ejecutar el applet desde netBeans
//Con Shitf izquierdo + F6

/*
<applet code ="Applet_ex.class" width=200 height=200> </applet>
*/
public class AppletGuia2 extends Applet implements ActionListener {
TextField tfEstatura,tfPeso;
Label lEstatura,lPeso;
Button boton;
double resultado;
public AppletGuia2(){
    this.setLayout((null));
    lEstatura = new Label ("Estatura (mt): ");
    lEstatura.setBounds(20,20,100,20);
    lPeso= new Label ("Peso (kg): ");
    lPeso.setBounds(20,40,100,20);
    tfEstatura = new TextField();
    tfEstatura.setBounds(120,20,100,20);
    tfPeso = new TextField();
    tfPeso.setBounds(120,40,100,20);
    boton = new Button ("Calcula");
    boton.setBounds(120,80,100,20);
  
   add(lEstatura);
    add(lPeso);
    add(tfEstatura);
   
    add(tfPeso);
    add(boton);
    boton.addActionListener(this);
   
        
}
  public void paint (Graphics g){
  this.setSize(300,300);
  g.drawString("Su Indice de Masa Corporal es :" + resultado, 20, 120);
  }

public void actionPerformed(ActionEvent ae)
{
double calcPeso = ParseDouble(tfPeso.getText()); 
     double calcAltura = ParseDouble(tfEstatura.getText()); 
  resultado = calcPeso/(calcAltura*calcAltura);
     repaint();
   
}
//Este metodo es obligatorio, por que los TextFields empiezan vacios, sin esto el codigo no ejecuta.
double ParseDouble(String strNumber) {
   if (strNumber != null && strNumber.length() > 0) {
       try {
          return Double.parseDouble(strNumber);
       } catch(Exception e) {
          return -1;   
       }
   }
   else return 0;
}
}