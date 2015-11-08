/**
 * A class to hold an object as an item in a (singly) Linked List.
 *
 * Objects of this class wrap around any other object and maintain a pointer to
 * the next item in the list.
 * @author Chris Grocott
 */
public class LinkedListItem {
	
	private Object listObject;
	private LinkedListItem next;

	/**
	 * Constructor requires an object as the wrapped list item.
	 */
	public LinkedListItem(Object listObject) {
		this.listObject = listObject;
		this.next = null;
	}

	/**
	 * Add the next item in the list.
	 */
	public void setNext(LinkedListItem next) {
		this.next = next;
	}

	/**
	 * Returns the next item in the list
	 * @return the next item in the list
	 */
	public LinkedListItem getNext() {
		return this.next;
	}

	/**
	 * Returns true if there is a next item in the list, false otherwise.
	 * @return true if there is a next item in the list, false otherwise.
	 */
	public boolean hasNext() {
		if(this.next == null) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Get the object wrapped by this Linked List item
	 * @return the wrapped object.
	 */
	public Object getListItem() {
		return this.listObject;
	}

	/**
	 * Recursively adds an item to the list. Note that for this assignment
	 * adding was eventually implemented within the LinkedList class itself.
	 */
	public void add(LinkedListItem newItem) {
		if(this.next == null) {
			this.next = newItem;
		}
		else {
			this.getNext().add(newItem);
		}
	}

	/**
	 * Recursively get the current size of the linked list.
	 * @return the size of the list
	 */
	public int size() {
		if(this.next == null) {
			return 1;
		}
		else {
			return 1 + this.next.size();
		}
	}
	
	/**
	 * Get a string representation of the wrapped object
	 * @return a string representing the wrapped object
	 */
	public String toString() {
		return this.listObject.toString();
	}
}
