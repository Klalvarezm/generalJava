
package application;
import java.util.*;

class Thermometer implements Sensor {

    @Override
    public boolean isOn() {
        return true;
    }

   
    public void on() {
    isOn();
    measure();    
    }

  
    public void off() {
        throw new IllegalStateException("El Ternometro esta apagado"); 
       
    }

    @Override
    public int measure() {
     Random rand=new Random();
        int a=(int)(rand.nextDouble() * 60 + -30);  
        return a;
    }
    
}
