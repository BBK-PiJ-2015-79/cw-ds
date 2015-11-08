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
	 * removed frmo the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		ReturnObject topItem = this.top();
		this.internalList.remove(0);
		return topItem;
	}

	public String toString() {
		return this.internalList.toString();
	}
}
