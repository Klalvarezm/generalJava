package arraylistejemplo;
import java.util.*;

public class ArrayListejemplo {

    public static void main(String[] args) {
        ArrayList<String> teachers = new ArrayList<String>();

    teachers.add("Anthony");
    teachers.add("Paul");
    teachers.add("John");
    teachers.add("Martin");
    teachers.add("Matt");

    /*int place = 0;
    //Lo que hay aqui abajo es como un for ordinario, bota salidas para cada dato.
    //solo que sin especificar el numero
    System.out.println( teachers.get(place) );
    place++;
    System.out.println( teachers.get(place) );  // place = 1
    place++;
    System.out.println( teachers.get(place) );  // place = 2
    place++;
    System.out.println( teachers.get(place) );  // place = 3*/
     int place = 0;
    //con un while, asi no sepamos cuantos datos hayan, podremos imprimirlos todos
    //Recordar que como empieza en cero, debemos colocar menor y no menor e igual
    //por que si colocamos menor e igual diriamos que tiene uno mas del tamaño.
     while ( place < teachers.size() ){  
        System.out.println( teachers.get(place) );
        place++;}
    }
    
}
