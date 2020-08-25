
package anagram;
import java.util.*;

public class Anagram {
  
           public static boolean compStrings(String s1, String s2)
          {
          int eqcount=0;
              if( s1.length()==s2.length())
            {
               /*char[]c1=s1.toCharArray();
               char[]c2=s2.toCharArray();*/
               //Lo de abajo hace lo mismo de arriba, pero sin necesidad de librerias.
                //Convierte String a un arreglo de Char
                char[] c1=new char[s1.length()];
                for (int i=0;i<s1.length();i++){
               c1[i]=s1.charAt(i);}
                 
               char[] c2=new char[s2.length()];
                 for (int j=0;j<s2.length();j++){
                  c2[j]=s2.charAt(j);}
   
                
               Arrays.sort(c1);
               Arrays.sort(c2);
                    
               
               
               for (int i=0;i<c1.length;i++)
                    {
                     if (c1[i]==c2[i]){eqcount++;}
                    }
               if (eqcount==c1.length){return true;}      
               else {return false;}
            }
           
          else {return false;}
          }
    
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in) ; 
     String a1,a2;
     System.out.println("Enter the first word");
     a1=sc.nextLine();
    System.out.println("Enter the second word");
     a2=sc.nextLine();
    
     
     
     boolean compi=compStrings(a1,a2);
         if(compi==true)
         {
         System.out.println("Anagrams");
         }
          else System.out.println("Not Anagrams");
    }
    
}
