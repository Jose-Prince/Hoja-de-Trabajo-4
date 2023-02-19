import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import structure5.AbstractStack;

public class CalculadoraPrincipal {
    public static <E> void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String resultado;
        Calculadora calculadora = Calculadora.getInstance();
        
        StackFactory<Character> factory = new StackFactory<>();

        System.out.println("Escoja el tipo de pila que quiera usar: (indique el numero)");
        System.out.println("\n1. SingledLinkedList\n2. DoublyLinkedList\n3. ArrayList\n4. Vector\n\nOpción:");
        try {
            int opcion = in.nextInt();
            in.nextLine();
            AbstractStack<Character> stack = factory.getInstance(opcion);
            System.out.println("\nIngrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
            
            String fpath = in.nextLine();
            
                  try {
                    File myObj = new File(fpath);
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                      String expresion = "";
                      String infix = myReader.nextLine();
                      System.out.println("InFix: " + infix);

                      String postfix = calculadora.infixToPostfix(infix, stack);
                      System.out.println("PostFix: " + postfix);
                      
                      for (int i = 0; i< postfix.length; i++){
                          if (postfix[i].matches("[0-9]*")){
                              stack.push(postfix[i]);
                         
                          } else if (postfix[i].matches("[+,-,*,/]")){
                              if (stack.size() > 1){
                              switch (postfix[i]) {
                                  case "+":
                                      resultado = String.valueOf(calculadora.suma(stack));
                                      stack.push(resultado);
              
                                      if (postfix[postfix.length - 1] == postfix[i]){
                                          System.out.println("Resultado: " + resultado);
                                          stack.pop();
                                      }
                                      break;
                                  case "-":
                                      resultado = String.valueOf(calculadora.resta(stack));
                                      stack.push(resultado);
              
                                      if (postfix[postfix.length - 1] == postfix[i]){
                                          System.out.println("Resultado: " + resultado);
                                          stack.pop();
                                      }
                                      break;
                                  case "*":
                                      resultado = String.valueOf(calculadora.multiplicacion(stack));
                                      stack.push(resultado);
              
                                      if (postfix[postfix.length - 1] == postfix[i]){
                                          System.out.println("Resultado: " + resultado);
                                          stack.pop();
                                      }
                                      break;
                                  case "/":
                                        try {
                                            resultado = String.valueOf(calculadora.division(stack));
                                            stack.push(resultado);
                  
                                            if (postfix[postfix.length - 1] == postfix[i]){
                                                System.out.println("Resultado: " + resultado);
                                                stack.pop();
                                            }
                                        } catch (Exception e) {
                                            // TODO: handle exception
                                            System.out.println("No se puede realizar una división entre 0");
                                        }
                                      
              
                                      break;
                                  default:
                                      break;
                                  }
                              } else {
                                  System.out.println("Insuficientes operandos para el operador");
                              }
                              }
                          
                          }
                      }
                    
                    myReader.close();
                  } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }       
            
        } catch (Exception e) {
            // TODO: handle exception
            in.nextLine();
            System.out.println("\nOpción inválida");
        }  
    }
}
