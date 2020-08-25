

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
public class AppletGuia3 extends Applet implements ActionListener {
TextField tfEstatura,tfPeso,tfGenero;
Label lEstatura,lPeso,lGenero;
Button boton;
double resultado;
String result;
public AppletGuia3(){
    
    //(Posicion Horizontal texto,Pos Vertical tex, tamaño de ancho, tamaño largo)
    /*
    Se agrega el label, se le asigna una posicion y con add se pone en pantalla
    Se agrega el Text Field, se le asigna una posicion y con add se pone en pantalla
    */
    
    
    this.setLayout((null));
    lEstatura = new Label ("Estatura (mt): ");
    lEstatura.setBounds(20,20,100,20);
    lPeso= new Label ("Peso (kg): ");
    lPeso.setBounds(20,40,100,20);
    tfEstatura = new TextField();
    tfEstatura.setBounds(120,20,100,20);
    tfPeso = new TextField();
    tfPeso.setBounds(120,40,100,20);
    boton = new Button ("Calcular");
    boton.setBounds(120,100,100,20);
    
    lGenero = new Label ("Genero (\"Escriba Hombre O Mujer\")");
    lGenero.setBounds(20,60,200,20);
    tfGenero =new TextField();
    tfGenero.setBounds(120,80,100,20);
    
    add(lGenero);
    add(tfGenero);
    add(lEstatura);
    add(lPeso);
    add(tfEstatura);
   
    add(tfPeso);
    add(boton);
    boton.addActionListener(this);
   
        
}
  public void paint (Graphics g){
  this.setSize(430,300);
  g.drawString("Su Indice de Masa Corporal es :" + resultado, 20, 140);
  g.drawString("Su Estado Corporal es :"+ result, 20, 160);
  }

public void actionPerformed(ActionEvent ae)
{
     //Aqui se obtienen los datos y se hacen las operaciones
     double calcPeso = ParseDouble(tfPeso.getText()); 
     double calcAltura = ParseDouble(tfEstatura.getText()); 
     resultado = calcPeso/(calcAltura*calcAltura);
     String gen =tfGenero.getText();
     
     switch (gen)
     {
         case "Hombre":
         if (resultado<20){result="Bajo Peso";}
         if (resultado>=20&&resultado<=24.9){result="Peso Normal";}
         if (resultado>=25&&resultado<=29.9){result="Obesidad Leve";}
         if (resultado>=30&&resultado<=40){result="Obesidad Severa";}
         if (resultado>40){result="Obesidad Muy Severa";}
         //Este metodo re-genera lo que esta en pantalla, asi que los cambios ocurren aqui.
         repaint();
         break;
         
         case "Mujer":  
         if (resultado<20){result="Bajo Peso";}
         if (resultado>=20&&resultado<=23.9){result="Peso Normal";}
         if (resultado>=24&&resultado<=28.9){result="Obesidad Leve";}
         if (resultado>=29&&resultado<=37){result="Obesidad Severa";}
         if (resultado>37){result="Obesidad Muy Severa";}
         //Este metodo re-genera lo que esta en pantalla, asi que los cambios ocurren aqui.
         repaint();
         break;
         
         case "hombre":
          if (resultado<20){result="Bajo Peso";}
         if (resultado>=20&&resultado<=24.9){result="Peso Normal";}
         if (resultado>=25&&resultado<=29.9){result="Obesidad Leve";}
         if (resultado>=30&&resultado<=40){result="Obesidad Severa";}
         if (resultado>40){result="Obesidad Muy Severa";}
         //Este metodo re-genera lo que esta en pantalla, asi que los cambios ocurren aqui.
         repaint();
         break;
         
         case "mujer":  
          if (resultado<20){result="Bajo Peso";}
         if (resultado>=20&&resultado<=23.9){result="Peso Normal";}
         if (resultado>=24&&resultado<=28.9){result="Obesidad Leve";}
         if (resultado>=29&&resultado<=37){result="Obesidad Severa";}
         if (resultado>37){result="Obesidad Muy Severa";}  
         break;
         default:
         result="Genero No Valido (\"Escriba Hombre O Mujer\")";
         repaint();
         break;
     }
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

