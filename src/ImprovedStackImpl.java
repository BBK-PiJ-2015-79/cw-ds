/**
 * An implementation of a stack with additional methods. 
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
public class ImprovedStackImpl implements ImprovedStack {
	private FunctionalList stackList;

	/**
	 * No argument constructor creates an empty stack
	 */
	public ImprovedStackImpl() {
		this.stackList = new FunctionalArrayList();
	}	

	// Methods from interface Stack

	/**
	 * Returns true if the stack is empty, false otherwise. 
	 * 
	 * @return true if the stack is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return this.stackList.isEmpty();
	}

	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size() {
		return this.stackList.size();
	}

	/**
	 * Adds an element at the top of the stack. 
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		this.stackList.add(0, item);
	}

	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top() {
		return this.stackList.get(0);
	}

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed frmo the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		return this.stackList.remove(0);
	}

	//methods from interface ImprovedStack

	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	public ImprovedStack reverse() {
		ImprovedStack reverseStack = new ImprovedStackImpl();
		int stackSize = this.size();
		for(int i = 0; i < stackSize; i++) {
			reverseStack.push(this.stackList.get(i).getReturnValue());
		}
		return reverseStack;
	}

	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * Classes implementing this method must use method .equals() to
	 * check whether the item is in the stack or not.
	 * 
	 * @param object the object to remove
	 */
	public void remove(Object object) {
		FunctionalList newStackList = new FunctionalArrayList();
		int stackSize = this.size();
		for(int i = 0; i < stackSize; i++) {
			if(!this.stackList.get(i).getReturnValue().equals(object)) {
				newStackList.add(this.stackList.get(i));
			}
		}
		this.stackList = newStackList;
		return;
	}

	/**
	 * Returns a string consisting of the elements of the stack separated by commas.
	 * 
	 * @return a string representation of the stack
	 */
	public String toString() {
		return this.stackList.toString();
	}
}
