import java.util.ArrayList;
import java.util.Iterator;

import structure5.AbstractStack;

public class StackArrayList<E> extends AbstractStack<E> {

        private ArrayList<E> miListaInterna;
        
        public StackArrayList() {
            miListaInterna = new ArrayList<E>(); 
        }
        
        @Override
        public boolean isEmpty() {
            return miListaInterna.isEmpty();
        }

        @Override
        public void add(E arg0) {
            // TODO Auto-generated method stub
            miListaInterna.add(0, arg0);   
        }

        @Override
        public E get() {
            // TODO Auto-generated method stub
            return miListaInterna.get(0);
        }

        @Override
        public E remove() {
            // TODO Auto-generated method stub
            return miListaInterna.remove(0);
        }

        @Override
        public int size() {
            // TODO Auto-generated method stub
            return miListaInterna.size();
        }

        @Override
        public void clear() {
            // TODO Auto-generated method stub
            
        }

        @Override
        public Iterator<E> iterator() {
            // TODO Auto-generated method stub
            return null;
        }
    
}

