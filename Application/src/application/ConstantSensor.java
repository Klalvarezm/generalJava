
package application;


class ConstantSensor implements Sensor {
int n;
    ConstantSensor(int i) {
   this.n = i;
  }

    @Override public int measure ()
    {
    return n;
    }
   

    public boolean isOn() {
        return true;
    }

    public void off() {
       
    }

    @Override
    public void on() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
