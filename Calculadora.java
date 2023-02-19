import structure5.AbstractStack;

public class Calculadora {
    
    public static boolean instance_flag = false;
    public static Calculadora miCalculadora;

    private Calculadora() {
        instance_flag = true;
    }

    public static Calculadora getInstance(){
        if (instance_flag) {
            return miCalculadora;
        } else {
            miCalculadora = new Calculadora();
            return miCalculadora;
        }
    }

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

    public boolean isOperator(String item) {
        boolean operator = false;
        if (item.matches("[+,-,*,/]"))
            operator = true;
        return operator;
    }

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

    public String infixToPostfix(String infix, AbstractStack<String> stack){
        String resultado = "";

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            String s = String.valueOf(c);

            if (Character.isLetterOrDigit(c))
                resultado += c;  
            else if (c == '(')
                stack.push(s);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != "(") {
                    resultado += stack.peek();
                    stack.pop();
                }

                stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(s) <= Prec(stack.peek())) {
                    resultado += stack.peek();
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
        }

        return resultado;
    }

    // public int operations(String postfix, AbstractStack<Character> stack) {
    //     int resultado = 0;            
    //     for (int i = 0; i < postfix.length(); i++){
    //         char letter = postfix.charAt(i);
    //         if (Character.isDigit(letter)){
    //             stack.push(Character.valueOf(letter));
    //         } else {
    //             switch (letter) {
    //                 case '+':
    //                     resultado = suma(stack);
    //                     break;
    //                 case '-':
    //                     resultado = resta(stack);
    //                     break;
    //                 case '*':
    //                     resultado = multiplicacion(stack);
    //                     break;
    //                 case '/':
    //                     resultado = division(stack);
    //                     break;
    //             }
    //         }
    //     }

    //     return resultado;
    // }
}
