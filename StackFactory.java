import structure5.StackList;
import structure5.AbstractStack;
import structure5.StackVector;

public class StackFactory<E> {
  
    public AbstractStack<E> getInstance(int num) {
        AbstractStack<E> stackUsado = null;

        switch (num) {
            //Singled List
            case 1:
                stackUsado = new StackList<E>();
                break;
            //Doubled List
            case 2:
                stackUsado = new DoubleLinkedList<E>();
                break;
            //ArrayList
            case 3:
                stackUsado = new StackArrayList<E>();
                break;
            //Vector
            case 4:
                stackUsado = new StackVector<E>();
                break;
            default:
                break;
        }

        return stackUsado;

    }

}
