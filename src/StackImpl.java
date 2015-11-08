/**
 * An implementation of a stack, a data structure of type LIFO (Last
 * In, First Out).
 * 
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack. 
 * 
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 * 
 * Implementation by Chris Grocott, original interface by PiJ team
 *
 * @author PiJ
 * @author Chris Grocott
 */
public class StackImpl extends AbstractStack {
	public StackImpl(List list) {
		super(list);
	}

	/**
	 * Returns true if the stack is empty, false otherwise. 
	 * 
	 * @return true if the stack is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return this.internalList.isEmpty();
	}

	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size() {
		return this.internalList.size();
	}

	/**
	 * Adds an element at the top of the stack. 
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		this.internalList.add(0, item);
	}

	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top() {
		return this.internalList.get(0);
	}

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed from the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		ReturnObject topItem = this.top();
		this.internalList.remove(0);
		return topItem;
	}

	/**
	 * Returns a string consisting of the elements of the stack separated by commas.
	 * 
	 * @return a string representation of the stack
	 */
	public String toString() {
		return this.internalList.toString();
	}
}
