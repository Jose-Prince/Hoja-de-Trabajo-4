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

    public int suma(){
        return 0;
    }

    public int resta() {
        return 0;
    }

    public int multiplicacion() {
        return 0;
    }

    public int division() {
        return 0;
    }

    public String getItems() {
        return "";
    }

    public boolean isOperator() {
        return false;
    }
}
