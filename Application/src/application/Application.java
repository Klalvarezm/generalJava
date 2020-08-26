
package application;

public class Application {

    
    public static void main(String[] args) {
  /*ConstantSensor ten = new ConstantSensor(10);
  ConstantSensor minusFive = new ConstantSensor(-5);
  System.out.println( ten.measure() );
  System.out.println( minusFive.measure() );
  System.out.println( ten.isOn() );
  ten.off();
  System.out.println( ten.isOn() );
  Thermometer termi=new Thermometer();  
  termi.off();
   */ 
     Sensor kumpula = new Thermometer();
    kumpula.on();
    System.out.println("the temperature in Kumpula is "+kumpula.measure() + " degrees");

    Sensor kaisaniemi = new Thermometer();
    Sensor helsinkiVantaa = new Thermometer();

    AverageSensor helsinkiArea = new AverageSensor();
    helsinkiArea.addSensor(kumpula);
    helsinkiArea.addSensor(kaisaniemi);
    helsinkiArea.addSensor(helsinkiVantaa);

    helsinkiArea.on();
    System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
    System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
    System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");

    System.out.println("readings: "+helsinkiArea.readings()); 
    }
    
}
