import java.io.File;
import java.util.Scanner;

import structure5.AbstractStack;

public class CalculadoraPrincipal {
    public static <E> void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        int b;
        E resultado;
        Calculadora calculadora = new Calculadora();
        StackFactory<E> factory = new StackFactory<>();

        System.out.println("Escoja el tipo de pila que quiera usar: (indique el numero)");
        System.out.println("\n1. SingledLinkedList\n2. DoublyLinkedList\n3. ArrayLits\n4. Vector\n\nOpción:");
        try {
            int opcion = in.nextInt();
            in.nextLine();
            
            AbstractStack<E> stack = factory.getInstance(opcion);


            System.out.println("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
            
            String fpath = in.nextLine();
            
        } catch (Exception e) {
            // TODO: handle exception
            in.nextLine();
            System.out.println("\nOpción inválida");
        }

        
    }}
//       try {
//         File myObj = new File(fpath);
//         Scanner myReader = new Scanner(myObj);
//         while (myReader.hasNextLine()) {
//           String data = myReader.nextLine();
//           System.out.println(data);
//           //calculadora.getItems(data);
//           String[] listaStrings = data.split(" ");
//           for (int i = 0; i<listaStrings.length; i++){
//               if (listaStrings[i].matches("[0-9]*")){
//                   factory.getItems(listaStrings[i]);
//                   //listaPostFix = calculadora.getItems(data);
//               } else if (listaStrings[i].matches("[+,-,*,/]")){
//                   if (calculadora.count() > 1){
//                   switch (listaStrings[i]) {
//                       case "+":
//                           b = Integer.valueOf((String) calculadora.peek());
//                           calculadora.pull();
//                           a = Integer.valueOf((String) calculadora.peek());
//                           calculadora.pull();
//                           resultado = (T) String.valueOf(calculadora.suma(a, b));
//                           calculadora.push(resultado);
  
//                           if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
//                               System.out.println("Resultado: " + resultado);
//                               calculadora.pull();
//                           }
//                           break;
//                       case "-":
//                           b = Integer.valueOf((String) calculadora.peek());
//                           calculadora.pull();
//                           a = Integer.valueOf((String) calculadora.peek());
//                           calculadora.pull();
//                           resultado = (T) String.valueOf(calculadora.resta(a, b));
//                           calculadora.push(resultado);
  
//                           if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
//                               System.out.println("Resultado: " + resultado);
//                               calculadora.pull();
//                           }
//                           break;
//                       case "*":
//                           b = Integer.valueOf((String) calculadora.peek());
//                           calculadora.pull();
//                           a = Integer.valueOf((String) calculadora.peek());
//                           calculadora.pull();
//                           resultado = (T) String.valueOf(calculadora.multiplicacion(a, b));
//                           calculadora.push(resultado);
  
//                           if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
//                               System.out.println("Resultado: " + resultado);
//                               calculadora.pull();
//                           }
//                           break;
//                       case "/":
//                           b = Integer.valueOf((String) calculadora.peek());
//                           calculadora.pull();
//                           a = Integer.valueOf((String) calculadora.peek());
//                           calculadora.pull();
                          
//                           if (b == 0){
//                               System.out.println("No se puede realizar la división entre 0");
//                               break;
//                           } else {
//                               resultado = (T) String.valueOf(calculadora.division(a, b));
//                               calculadora.push(resultado);
  
//                               if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
//                                   System.out.println("Resultado: " + resultado);
//                                   calculadora.pull();
//                               }
//                           }
  
//                           break;
//                       default:
//                           break;
//                       }
//                   } else {
//                       System.out.println("Insuficientes operandos para el operador");
//                   }
//                   }
              
//               }
//           }
        
//         myReader.close();
//       } catch (FileNotFoundException e) {
//         System.out.println("An error occurred.");
//         e.printStackTrace();
//       }
//     }
//   }
// }
