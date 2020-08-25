/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.lang.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//Este codigo comentariado sirve para ejecutar el applet desde netBeans
//Con Shitf izquierdo + F6
/*
<applet code ="Applet_ex.class" width=200 height=200> </applet>
*/

public class AppletCuatroNumeros extends Applet implements ActionListener {

TextField tfN1,tfN2,tfN3,tfN4;
Label lN1,lN2,lN3,lN4;
Button boton;
double resultado;
    
    public AppletCuatroNumeros(){
    this.setLayout((null));
    //(Posicion Horizontal texto,Pos Vertical tex, tamaño de ancho, tamaño largo)
    /*
    Se agrega el label, se le asigna una posicion y con add se pone en pantalla
    Se agrega el Text Field, se le asigna una posicion y con add se pone en pantalla
    */
    
    
    lN1 = new Label ("Numero A: ");
    lN1.setBounds(20,20,100,20);
    add(lN1);
    
    tfN1 = new TextField();
    tfN1.setBounds(120,20,100,20);
    add(tfN1);
    
    
    lN2= new Label ("Numero B: ");
    lN2.setBounds(20,40,100,20);
    add(lN2);
    
    
    tfN2 = new TextField();
    tfN2.setBounds(120,40,100,20);
    add(tfN2);
    
   lN3= new Label ("Numero C: ");
    lN3.setBounds(20,60,100,20);
    add(lN3);
    
    
    tfN3 = new TextField();
    tfN3.setBounds(120,60,100,20);
    add(tfN3);
    
    
    lN4= new Label ("Numero D: ");
    lN4.setBounds(20,80,100,20);
    add(lN4);
    
    
    tfN4 = new TextField();
    tfN4.setBounds(120,80,100,20);
    add(tfN4);
    
    
    
    
    
    
    boton = new Button ("Calcular Promedio");
    boton.setBounds(120,120,120,20);
    add(boton);
   
   
   
   
   
    boton.addActionListener(this);
   
       }
    
     public void paint (Graphics g){
  this.setSize(300,300);
  g.drawString("El promedio de estos numeros es :" + resultado, 20, 160);
  }
     
     public void actionPerformed(ActionEvent ae)
{
     double cN1 = ParseDouble(tfN1.getText()); 
     double cN2 = ParseDouble(tfN2.getText()); 
     double cN3 = ParseDouble(tfN3.getText()); 
     double cN4 = ParseDouble(tfN4.getText()); 
     
     resultado = (cN1+cN2+cN3+cN4)/4;
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

    // TODO overwrite start(), stop() and destroy() methods
}
