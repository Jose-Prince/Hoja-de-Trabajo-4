import static org.junit.Assert.assertEquals;

import org.junit.Test;

import structure5.AbstractStack;

public class TestCalculadora {
    
    Calculadora calculadora = Calculadora.getInstance();
    StackFactory<String> factory = new StackFactory<>();

    @Test
    public void conversionTest(){
        String infix = "(1+2)*9";
        String expectedPostfix = "12+9*";
        AbstractStack<String> stack = factory.getInstance(1);
        String postfix = calculadora.infixToPostfix(infix, stack);
        assertEquals(expectedPostfix, postfix);
    }

    @Test
    public void sumaTest() {
        AbstractStack<String> stack = factory.getInstance(1);
        stack.push(String.valueOf(1));
        stack.push(String.valueOf(2));
        calculadora.suma(stack);
        String valor = stack.peek();
        assertEquals("3", valor);
    }

    @Test
    public void sumaNegativaTest() {
        AbstractStack<String> stack = factory.getInstance(1);
        stack.push(String.valueOf(1));
        stack.push(String.valueOf(-2));
        calculadora.suma(stack);
        String valor = stack.peek();
        assertEquals("-1", valor);
    }

    @Test 
    public void restaTest() {
        AbstractStack<String> stack = factory.getInstance(1);
        stack.push(String.valueOf(1));
        stack.push(String.valueOf(2));
        calculadora.resta(stack);
        String valor = stack.peek();
        assertEquals("-1", valor);
    }

    @Test 
    public void restaNegativaTest() {
        AbstractStack<String> stack = factory.getInstance(1);
        stack.push(String.valueOf(1));
        stack.push(String.valueOf(-2));
        calculadora.resta(stack);
        String valor = stack.peek();
        assertEquals("3", valor);
    }

    @Test
    public void multiplicación() {
        AbstractStack<String> stack = factory.getInstance(1);
        stack.push(String.valueOf(1));
        stack.push(String.valueOf(2));
        calculadora.multiplicacion(stack);
        String valor = stack.peek();
        assertEquals("2", valor);
    }

    @Test
    public void division() {
        AbstractStack<String> stack = factory.getInstance(1);
        stack.push(String.valueOf(10));
        stack.push(String.valueOf(2));
        calculadora.division(stack);
        String valor = stack.peek();
        assertEquals("5", valor);
    }

    @Test
    public void divisionCeroTest() {
        AbstractStack<String> stack = factory.getInstance(1);
        stack.push(String.valueOf(10));
        stack.push(String.valueOf(0));
        calculadora.division(stack);
        String valor = stack.peek();
        assertEquals("0", valor);
    }
}
