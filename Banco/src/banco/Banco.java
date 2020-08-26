
package banco;
import java.util.*;

public  class Banco {
    Random rand = new Random();
  double balance=0;
  String Nombre;
  int Code;
  void setCode()
      {
      this.Code = rand.nextInt(100000); 
      }       
  int getCode()
  {
  return this.Code;
  }
  
  
  void deposito(double valor)
        {
        this.balance+=valor;
        }
        
         void setName(String name)
         {
         this.Nombre=name;
         }
         String getName()
         {
         return this.Nombre;
         }
         void retirar (double valor1)
         {
          if (valor1>this.balance)
             {
             System.out.println("Operacion ilegal, el valor a retirar no puede exceder el balance");
             }
         else{this.balance-=valor1;}
         }
          double getBalance()
          {
              return this.balance;
          }
  
      public static class Cliente extends Banco
       {
      @Override
       void retirar (double valor1)
         {
          if (valor1>=this.balance)
             {
             System.out.println("Operacion ilegal, el valor a retirar no puede exceder el balance");
             }
         if (this.balance-valor1<500)
         {
             System.out.println("Operacion ilegal, deben quedar minimo $500 en la cuenta");
         }
         else{this.balance-=valor1;}
         }
          
         
      }
           public static class Inversionista extends Banco
           {
            @Override
               void retirar (double valor1)
                {
                 if (valor1>=this.balance)
                 {
                  System.out.println("Operacion ilegal, el valor a retirar no puede exceder el balance");
                 }
                   if (this.balance-valor1<10000)
                   {
                     System.out.println("Operacion ilegal, deben quedar minimo $10000 en la cuenta");
                   }
         else{this.balance-=valor1;}
         }
          
  }
  
    public static class Empleado extends Banco
  {
  
  }
    
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       String name; 
       boolean flag=true, flagCliente=true;
         while (flag)
         {
         System.out.println("\nIngrese 1 para entrar como cliente,2 para entrar como inverionista \n3 para entrar como empleado o 4 para terminar el proceso");
         int opcion;
         opcion=scan.nextInt();
        scan.nextLine();
         if (opcion ==1)
           {
            System.out.println("\nPara tener cuenta cliente, debe hacer un deposito de $1000\nIngrese 1 para aceptar o 2 para cancelar");
            int clienteOpcion=scan.nextInt();
             scan.nextLine();
             if (clienteOpcion==1){ 
             
              flagCliente=true;
             
             Cliente cliente= new Cliente();
             cliente.deposito(1000);
             cliente.setCode();
             System.out.println("Ingrese el nombre del cliente: ");
             name=scan.nextLine();
             cliente.setName(name);
             
             System.out.println("Ingrese el valor de interes anual: ");
             double intCliente=scan.nextDouble();
             int mes=1;   
             while(flagCliente)
                {
                    System.out.println("\n"+"Nombre: "+cliente.getName());
                    System.out.println("Codigo: "+cliente.getCode());
                    System.out.println("Balance actual: $"+cliente.getBalance());
                    System.out.println("Mes Actual: "+mes+"\nIngrese 1 para hacer un deposito, 2 para hacer un retiro,"
                          + " 3 para pasar al siguiente mes o 4 para terminar el proceso");
                  
                  int opcionCliente;
                  opcionCliente=scan.nextInt();
                     if (opcionCliente ==1)
                      {
                      System.out.println("\nIngrese el monto a depositar");
                       double dinero_nuevo = scan.nextDouble();
                       cliente.deposito(dinero_nuevo);
                        
                      } 
                        if (opcionCliente ==2)
                        {
                        System.out.println("\nIngrese el monto a retirar");
                            double dinero_viejo=scan.nextDouble();
                            cliente.retirar(dinero_viejo);
                            
                        }
                          
                        if (opcionCliente ==3)
                        {
                        double interes=(cliente.getBalance()*(intCliente/12));
                        cliente.deposito(interes);
                            mes=mes+1;
                        }
                           
                        if (opcionCliente ==4){flagCliente=false;}
                        
                }
           }
           if (clienteOpcion!=1)
             {
             flagCliente=false;
             }
           }
         
         if (opcion ==2)
         {
         System.out.println("\nPara tener cuenta de inversionista, debe hacer un deposito de $25000\nIngrese 1 para aceptar o 2 para cancelar");
            int inverOpcion=scan.nextInt();
             scan.nextLine();
             if (inverOpcion==1){ 
             
              
             
             Inversionista inversionista= new Inversionista();
             inversionista.deposito(25000);
             System.out.println("Ingrese el nombre del inversionista: ");
             name=scan.nextLine();
             inversionista.setName(name);
             int mes=1;   
             inversionista.setCode();
             flagCliente=true;
             while(flagCliente)
                {
                    System.out.println("\n"+"Nombre: "+inversionista.getName());
                    System.out.println("Codigo: "+inversionista.getCode());
                    System.out.println("Balance actual: $"+inversionista.getBalance());
                    System.out.println("Mes Actual: "+mes+"\nIngrese 1 para hacer un deposito, 2 para hacer un retiro,"
                          + " 3 para pasar al siguiente mes o 4 para terminar el proceso");
                  
                  int opcionCliente;
                  opcionCliente=scan.nextInt();
                     if (opcionCliente ==1)
                      {
                      System.out.println("\nIngrese el monto a depositar");
                       double dinero_nuevo = scan.nextInt();
                       inversionista.deposito(dinero_nuevo);
                        
                      } 
                        if (opcionCliente ==2)
                        {
                        System.out.println("\nIngrese el monto a retirar");
                            double dinero_viejo=scan.nextInt();
                            inversionista.retirar(dinero_viejo);
                            
                        }
                          
                        if (opcionCliente ==3){mes=mes+1;}
                           
                        if (opcionCliente ==4){flagCliente=false;}
                        
                }
           }
           if (inverOpcion!=1)
             {
             flagCliente=false;
             }
          
         }
         if (opcion ==3)
         {
         Empleado empleado= new Empleado();
             System.out.println("Ingrese el nombre del empleado: ");
             name=scan.nextLine();
             empleado.setName(name);
             int mes=1;   
             empleado.setCode();
             flagCliente=true;
             while(flagCliente)
                {
                    System.out.println("Nombre: "+empleado.getName());
                    System.out.println("Codigo: $"+empleado.getCode());
                    System.out.println("Balance actual: $"+empleado.getBalance());
                    System.out.println("Mes Actual: "+mes+"\nIngrese 1 para hacer un pago de salario, 2 para hacer un retiro de dinero,"
                          + " 3 para pasar al siguiente mes o 4 para terminar el proceso");
                  
                  int opcionEmpleado;
                  opcionEmpleado=scan.nextInt();
                     if (opcionEmpleado ==1)
                      {
                      System.out.println("\nIngrese el monto a pagar");
                       double dinero_nuevo = scan.nextInt();
                       empleado.deposito(dinero_nuevo);
                        
                      } 
                        if (opcionEmpleado ==2)
                        {
                        System.out.println("\nIngrese el monto a retirar");
                            double dinero_viejo=scan.nextInt();
                            empleado.retirar(dinero_viejo);
                            
                        }
                          
                        if (opcionEmpleado ==3){mes=mes+1;}
                           
                        if (opcionEmpleado ==4){flagCliente=false;}
                        
                }
         
         
         }
         if (opcion ==4){flag=false;}}
        
    }
    
}
