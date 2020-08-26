package arrayexample;
import java.util.*;

public class ArrayExample {

   
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);
        int Row = s.nextInt();   
        int Column=s.nextInt();
        int [][]array = new int [Row][Column];
        int [][]array2=new int[Column][Row];  
           for (int i=0;i<Row;i++)
          {
            for(int j=0;j<Column;j++)
             {
              array[i][j]=s.nextInt();
             }
          }
            
          //TO DO
                for (int j=0;j<Column;j++)
                {
                   for(int i=0;i<Row;i++)
                   {
                   array2[j][i]=array[i][j];
                   }
                }  
          
          
          for (int i=0;i<Column;i++)
          {
            for(int j=0;j<Row;j++)
             {
              System.out.print(array2[i][j]+" ");
             }
          System.out.println();
          }
    }
    
}
