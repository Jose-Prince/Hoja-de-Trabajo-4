/**
 * @author José Prince
 * Algoritmos y Estructura de datos
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import structure5.AbstractStack;

public class CalculadoraPrincipal {
    
    /** 
     * @param args
     */
    public static <E> void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculadora calculadora = Calculadora.getInstance();
        int resultado = 0;

        StackFactory<String> factory = new StackFactory<>();

        System.out.println("Escoja el tipo de pila que quiera usar: (indique el numero)");
        System.out.println("\n1. SingledLinkedList\n2. DoublyLinkedList\n3. ArrayList\n4. Vector\n\nOpción:");
        try {
            int opcion = in.nextInt();
            in.nextLine();
            AbstractStack<String> stack = factory.getInstance(opcion);

            System.out.println("\nIngrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
            
            String fpath = in.nextLine();
            
                  try {
                    File myObj = new File(fpath);
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String infix = myReader.nextLine();
                        System.out.println("Infix: " + infix);

                        String postfix = calculadora.infixToPostfix(infix, stack);
                        System.out.println("Postfix: " + postfix);

                        for (int i = 0; i < postfix.length(); i++) {
                            char letter = postfix.charAt(i);
                            String letra = String.valueOf(letter);
                            if (letra.matches("[0-9]*")){
                                stack.push(letra);
                            } else {
                                switch (letter) {
                                    case '+':
                                        stack = calculadora.suma(stack);
                                        break;
                                    case '-':
                                        stack = calculadora.resta(stack);
                                        break;
                                    case '*':
                                        stack = calculadora.multiplicacion(stack);
                                        break;
                                    case '/':
                                        stack = calculadora.division(stack);
                                        break;
                                }
                            }
                        }
                        resultado = Integer.valueOf(stack.peek());
                        stack.pop();
                        
                        if (!stack.isEmpty())
                            stack.pop();

                        System.out.println("Resultado: " + resultado + "\n");    

                    }
                    
                    myReader.close();
                  } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }       
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("\nOpción inválida");
        }  
    }
}
