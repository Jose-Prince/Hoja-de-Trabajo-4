/**
 * 
 */


/**
 * @author MAAG
 *
 */
public class DoubleNode<E> {
	private E value;
	private DoubleNode<E> next;
	private DoubleNode<E> previous;
	
	public DoubleNode(E value) {
		this.setValue(value);
	}
	
	/**
	 * @return the value
	 */
	public E getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(E value) {
		this.value = value;
	}
	/**
	 * @return the next
	 */
	public DoubleNode<E> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(DoubleNode<E> next) {
		this.next = next;
	}
	/**
	 * @return the previous
	 */
	public DoubleNode<E> getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(DoubleNode<E> previous) {
		this.previous = previous;
	}
	
	
}

