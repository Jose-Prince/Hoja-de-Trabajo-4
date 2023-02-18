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

    public int suma(int a, int b){
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplicacion(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        return a/b;
    }

    public boolean isOperator(String item) {
        boolean operator = false;
        if (item.matches("[+,-,*,/]"))
            operator = true;
        return operator;
    }

    public String[] infixToPostfix(String[] infix, AbstractStack<String> stack){
        String[] postfix = new String[infix.length];
        int i;
        for (i = 0; i < infix.length; i++){

            if (infix[i].matches("[0-9]*")){
                postfix[i] = infix[i];
            } else if (infix[i].matches("[(]")){
                stack.push(infix[i]);
            } else if (infix[i].matches("[*,/]")){
                stack.push(infix[i]);
            } else if (infix[i].matches("[+,-]")){
                int signo = 0;
                for (int u = 0; u < stack.size();u++){
                    if (infix[i].matches("[*,/]")){
                        signo++;
                    } 
                }

                if (signo > 0){
                    while (stack.isEmpty() == false){
                        for (int u = 0; u < stack.size();u++){
                            String operador = stack.peek();
                            stack.pop();
                            postfix[i+u] = operador;                  
                        }
                        stack.push(infix[i]);
                    }
                } else {
                    stack.push(infix[i]);
                }
            } else if (infix[i].matches("[)]")){
                while (stack.isEmpty() == false && stack.peek() != "(") {
                    for (int u = 0; u < stack.size(); u++){
                        if (stack.peek() == "("){
                            stack.pop();
                        } else {
                            String operador = stack.peek();
                            stack.pop();
                            postfix[i+u] = operador;    
                        }
                    }   
                }
            } 
        }

        while (stack.isEmpty() == false) {
            for (int u = 0; u < stack.size(); u++){
                postfix[i] = stack.peek();
            }
        }

        return postfix;
    }
}
