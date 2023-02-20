/**
 * @author José Prince
 * Algoritmos y estructura de datos
 */
import structure5.AbstractStack;

public class Calculadora {
    
    public static boolean instance_flag = false;
    public static Calculadora miCalculadora;

    //Constructor privado de calculadoa
    private Calculadora() {
        instance_flag = true;
    }

    
    /** 
     * @return Calculadora
     * Crea la instancia de calculadora
     */
    public static Calculadora getInstance(){
        if (instance_flag) {
            return miCalculadora;
        } else {
            miCalculadora = new Calculadora();
            return miCalculadora;
        }
    }

    /**
     * Suma los elemntos del stack de la expresión postfix
     * @param stack
     * @return AbstractStack<String>
     */
    public AbstractStack<String> suma(AbstractStack<String> stack){
        String b = stack.peek();
        int B = Integer.valueOf(b);
        stack.pop();
        String a = stack.peek();
        int A = Integer.valueOf(a);
        stack.pop();

        int resultado = A+B;
        stack.push(String.valueOf(resultado));
        return stack;
    }

    /**
     * Resta los elemntos del stack de la expresión postfix
     * @param stack
     * @return AbstractStack<String>
     */
    public AbstractStack<String> resta(AbstractStack<String> stack) {
        String b = stack.peek();
        int B = Integer.valueOf(b);
        stack.pop();
        String a = stack.peek();
        int A = Integer.valueOf(a);
        stack.pop();

        int resultado = A-B;
        stack.push(String.valueOf(resultado));
        return stack;
    }

    /**
     * Multiplica los elemntos del stack de la expresión postfix
     * @param stack
     * @return AbstractStack<String>
     */
    public AbstractStack<String> multiplicacion(AbstractStack<String> stack) {
        String b = stack.peek();
        int B = Integer.valueOf(b);
        stack.pop();
        String a = stack.peek();
        int A = Integer.valueOf(a);
        stack.pop();

        int resultado = A*B;
        stack.push(String.valueOf(resultado));
        return stack;
    }

    /**
     * Divide los elemntos del stack de la expresión postfix
     * @param stack
     * @return AbstractStack<String>
     */
    public AbstractStack<String> division(AbstractStack<String> stack) {
        int resultado = 0;
        String b = stack.peek();
        int B = Integer.valueOf(b);
        stack.pop();
        String a = stack.peek();
        int A = Integer.valueOf(a);
        stack.pop();


        
        if (B != 0)
            resultado = A/B;

        stack.push(String.valueOf(resultado));
        
        return stack;
    }

    /**
     * Determina la prioridad del operador
     * @param ch
     * @return int
     */
    public int Prec(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;
        
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

    /**
     * Convierte una expresión infix a postfix
     * @param infix
     * @param stack
     * @return String
     */
    public String infixToPostfix(String infix, AbstractStack<String> stack){
        String resultado = "";

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            String s = String.valueOf(c);

            if (Character.isLetterOrDigit(c))
                resultado += c;  
            else if (s == "(")
                stack.push(s);
            else if (s == ")") {
                while (!stack.isEmpty() && stack.peek() != "(") {
                    resultado += stack.peek();
                    stack.pop();
                }

                stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(s) <= Prec(stack.peek())) {
                    resultado += stack.peek();
                    stack.pop();
                    if (!stack.isEmpty())
                        stack.pop();
                }
                stack.push(s);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == "(")
                return "Expresión inválida";
            resultado += stack.peek();
            stack.pop();
            stack.pop();
        }

        return resultado;
    }

    public int operacion(AbstractStack<String> stack, String postfix) {
        int resultado = 0;
        for (int i = 0; i < postfix.length(); i++) {
            char letter = postfix.charAt(i);
            String letra = String.valueOf(letter);
            if (letra.matches("[0-9]*")){
                stack.push(letra);
            } else {
                switch (letter) {
                    case '+':
                        stack = suma(stack);
                        break;
                    case '-':
                        stack = resta(stack);
                        break;
                    case '*':
                        stack = multiplicacion(stack);
                        break;
                    case '/':
                        stack = division(stack);
                        break;
                }
            }
        }
        resultado = Integer.valueOf(stack.peek());
        stack.pop();
        
        if (!stack.isEmpty())
            stack.pop();
        return resultado;
    }
}
