/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code ="Applet_ex.class" width=200 height=200> </applet>
*/


public class AppletDaCuadrado extends Applet implements ActionListener {
TextField t;
Button b;



    public AppletDaCuadrado() {
        Label lNumero= new Label("Numero: ");
        lNumero.setBounds(0,0,0,0);
        t = new TextField();
        b = new Button("Calcular");
        add(t);
        add(b);
        b.addActionListener(this);
        }

    public void paint(Graphics g){
    int num = Integer.parseInt(t.getText());
    g.drawString ("Cuadrado = "+num*num,100,100);
    }
    
   public void actionPerformed(ActionEvent ae){
   repaint();
   }
// TODO overwrite start(), stop() and destroy() methods
}
