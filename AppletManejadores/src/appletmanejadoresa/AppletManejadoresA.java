/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package appletmanejadoresa;
import java.applet.Applet;
import java.lang.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.*;

/*
<applet code ="Applet_ex.class" width=300 height=300> </applet>
*/

public class AppletManejadoresA extends Applet implements ActionListener {
TextField t1,t2,t3,t4;
Button botonSuma,botonResta,botonMultiplicacion,botonDivision,botonRaizX,botonRaizY,
        botonXalaY, botonYalaX,botonXmodY;
double X=0.000,Y=0.000,Resultado=0.000;

 public AppletManejadoresA()
  {
  this.setLayout((null));
  //zonas de texto
  t1=new TextField("",10);
  /*setbound posicion horizontal, vertical, ancho, largo*/
  t1.setBounds(5,22,50,20);
  t2=new TextField("",10);
  t2.setBounds(60,22,50,20);
 
  add (t1);
  add (t2);
  
  
   //Botones
   botonSuma = new Button ("+");
   botonSuma.setBounds(5,60,40,20);
   add(botonSuma);
   
   botonResta = new Button ("-");
   botonResta.setBounds(55,60,40,20);
   add(botonResta);
   
   botonMultiplicacion = new Button ("*");
   botonMultiplicacion.setBounds(105,60,40,20);
   add(botonMultiplicacion);
   
  
   
   botonDivision = new Button ("/");
   botonDivision.setBounds(155,60,40,20);
   add(botonDivision);
   
   botonRaizX = new Button ("Raiz de X");
   botonRaizX.setBounds(5,90,90,20);
   add(botonRaizX);
   
   botonRaizY = new Button ("Raiz de Y");
   botonRaizY.setBounds(110,90,90,20);
   add(botonRaizY);
   
   botonXalaY = new Button ("X^Y");
   botonXalaY.setBounds(5,120,40,20);
   add(botonXalaY);
   
    botonYalaX = new Button ("Y^X");
   botonYalaX.setBounds(50,120,40,20);
   add(botonYalaX);
   
   botonXmodY = new Button ("X mod Y");
   botonXmodY.setBounds(110,120,90,20);
   add(botonXmodY);
  
  botonSuma.addActionListener(this);
  }
    
    public void paint(Graphics g){
    /*this.setSize(500,500);*/
    g.drawString("X", 28, 20);
    g.drawString("Y", 78, 20);   
    g.drawString("Resultado", 120, 20);   
    g.drawString("El promedio de estos numeros es :" + Resultado, 20, 180);
    String Resulta2=String.valueOf(Resultado);
    t3=new TextField(Resulta2,20);
  t3.setBounds(120,22,70,20);
  add (t3);
    }
   
    

    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        String action = ae.getActionCommand();
        if (action.equals("+")) {
            X= ParseDouble(t1.getText());
            Y= ParseDouble(t2.getText());
            Resultado=X+Y;
            repaint();
        }
    }
  
    
    
    
    
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
