public interface iStack<T> {
    int count();
	
	boolean isEmpty();
	
	void push(T value);
	
	T pull();
	
	T peek();
}
