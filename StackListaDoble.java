import java.util.Iterator;

import structure5.AbstractStack;
import structure5.DoublyLinkedList;
import structure5.List;

/**
 * @author José Prince
 * Algoritmos y Estructuras de datos
 */

public class StackListaDoble<E> extends AbstractStack<E> {
    protected List<E> data;

    /**
     * Constructor de la clase StackListDoble
     */
    public StackListaDoble () {
        data = new DoublyLinkedList<E>();
    }

    /**
     * Función que elimina todos los elementos de la lista
     */
    public void clear() {
        data.clear();
    }

    
    /** 
     * @return boolean
     * Indica mediante un booleano si la lista esta vacia o no
     */
    public boolean empty() {
        return data.isEmpty();
    }

    /**
     * @return E 
     * Obtiene el primer objeto de la lista
     */
    public E get() {
        return data.getFirst();
    }

    /**
     * Añade un elemento a la primera posición de la lista
     */
    public void add(E value) {
        data.addFirst(value);
    }

    /**
     * @return E
     *  Remueve el primer elemento de la lista
     */
    public E remove() {
        return data.removeFirst();
    }

    /**
     * @return int
     * Indica el tamaño de la lista
     */
    public int size() {
        return data.size();
    }

    /**
     * @return String
     * Indica la forma de impresión de la lista
     */
    public String toString() {
        return "<Stack: " + data + ">";
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
