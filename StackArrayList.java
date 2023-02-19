/**
 * @author José Prince
 * Algoritmos y Estructura de datos
 */
import java.util.ArrayList;
import java.util.Iterator;

import structure5.AbstractStack;

public class StackArrayList<E> extends AbstractStack<E> {

        private ArrayList<E> miListaInterna;
        
        public StackArrayList() {
            miListaInterna = new ArrayList<E>(); 
        }
        
        
        /** 
         * @return boolean
         * Indica si el stack esta vacia
         */
        @Override
        public boolean isEmpty() {
            return miListaInterna.isEmpty();
        }

        /**
         * Añade un elemento a la primera posición del stack
         */
        @Override
        public void add(E arg0) {
            // TODO Auto-generated method stub
            miListaInterna.add(0, arg0);   
        }

        /**
         * Obtiene el primer elemento del stack
         */
        @Override
        public E get() {
            // TODO Auto-generated method stub
            return miListaInterna.get(0);
        }

        /**
         * Elimina el primer elemento del stack
         */
        @Override
        public E remove() {
            // TODO Auto-generated method stub
            return miListaInterna.remove(0);
        }

        /**
         * Indica el tamanño del stack
         */
        @Override
        public int size() {
            // TODO Auto-generated method stub
            return miListaInterna.size();
        }

        /**
         * Función sin utilizar
         */
        @Override
        public void clear() {
            // TODO Auto-generated method stub
            
        }

        /**
         * Función sin utilizar
         */
        @Override
        public Iterator<E> iterator() {
            // TODO Auto-generated method stub
            return null;
        }
    
}

