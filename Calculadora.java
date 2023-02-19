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

    public int suma(AbstractStack<String> stack){
        int b = Integer.valueOf(stack.peek());
        stack.pop();
        int a = Integer.valueOf(stack.peek());
        stack.pop();

        return a + b;
    }

    public int resta(AbstractStack<String> stack) {
        int b = Integer.valueOf(stack.peek());
        stack.pop();
        int a = Integer.valueOf(stack.peek());
        stack.pop();

        return a - b;
    }

    public int multiplicacion(AbstractStack<String> stack) {
        int b = Integer.valueOf(stack.peek());
        stack.pop();
        int a = Integer.valueOf(stack.peek());
        stack.pop();

        return a * b;
    }

    public int division(AbstractStack<String> stack) {
        int b = Integer.valueOf(stack.peek());
        stack.pop();
        int a = Integer.valueOf(stack.peek());
        stack.pop();
        
        return a/b;
    }

    public boolean isOperator(String item) {
        boolean operator = false;
        if (item.matches("[+,-,*,/]"))
            operator = true;
        return operator;
    }

    public int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
        
            case '*':
            case '/':
                break;
        }
        return -1;
    }

    public String infixToPostfix(String infix, AbstractStack<Character> stack){
        String resultado = "";

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c))
                resultado += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    resultado += stack.peek();
                    stack.pop();
                }

                stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    resultado += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Expresión inválida";
            resultado += stack.peek();
            stack.pop();
        }

        return resultado;
    }

    public int operations(String postfix, AbstractStack<String> stack) {            
        for (int i = 0; i < postfix.length(); i++){
            String letter = String.valueOf(postfix.charAt(i));
            if (letter.matches("[0-9]*")){

            } else if (letter.matches("[+,-,*,/]")){
                
            }
        }
        char[] postFix = new char[postfix.length()];
                      
                        for (int i = 0; i < postfix.length(); i++){
                            postFix[i] = postfix.charAt(i);
                        }

        return 0;
    }
}
