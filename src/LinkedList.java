/**
 * An implementation of the List interface based on a singly Linked List. Written
 * as part of coursework 2 for the 2015 Programming in Java module at Birkbeck.
 *
 * @author Chris Grocott
 */

public class LinkedList implements List {
	private LinkedListItem head;

	public LinkedList() {
		this.head = null;
	}

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		int count = 0;
		if(!this.isEmpty()) {
			count = head.size();
		}
		return count;
	}

	/**
	 * Returns the elements at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index) {
		ReturnObject getReturn;
		LinkedListItem currentItem = null;
		int currentIndex = 0; // changed from 1 debug
		if(this.isEmpty()) {
			getReturn = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
		}
		else if(!this.validIndex(index, "get")) {
			getReturn = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			currentItem = this.head;
			while(currentIndex < (index)) { // changed from index debug
				currentItem = currentItem.getNext();
				currentIndex++;
			}
			getReturn = new ReturnObjectImpl(currentItem.getListItem(), ErrorMessage.NO_ERROR);
		}
		return getReturn;
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index) {
		ReturnObject remReturn = this.get(index);
		if(!remReturn.hasError()) {
			//remove the returned object
			//int currentIndex
			if((index == 0) && (this.size() == 1)) {
				this.head = null;
			}
			else if(index == 1) {
				this.head = this.head.getNext();
			}
			else {
				//work through and re-assign pointers
				int currentIndex = 0; // changed from 1 debug // changed from 1 debug
				LinkedListItem currentItem = this.head;
				while(currentIndex < (index - 1)) { // changed from 1 debug
					currentItem = currentItem.getNext();
					currentIndex++;
				}
				currentItem.setNext(currentItem.getNext().getNext()); // debug used to be just .getNext()
			}
		}
		return remReturn;
	}

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(int index, Object item) {
		ReturnObject addReturn;
		if(item == null) {
			//System.out.println("No good, null element"); // debug
			addReturn = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
		}
		else if(!this.validIndex(index, "add")) {
			//System.out.println("No good, out of bounds"); // debug
			addReturn = new ReturnObjectImpl(item, ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else if(this.head == null) {
			//System.out.println("First Element"); // debug
			this.head = new LinkedListItem(item);
			addReturn = new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
		}
		else {
			//System.out.println("Adding to the list at index " + index); // debug
			LinkedListItem newItem = new LinkedListItem(item);
			LinkedListItem currentItem = this.head;
			int currentIndex = 0; // changed from 1 debug //changed from 1
			while(currentIndex < (index - 1)) { // changed from index, you get NPEs otherwise
				currentItem = currentItem.getNext();
				currentIndex++;
			}
			//System.out.println("Current object is " + currentItem.toString()); //debug
			if(currentItem.hasNext()) { // this was throwing a NPE
				newItem.setNext(currentItem.getNext());
			}
			currentItem.setNext(newItem);
			addReturn = new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
		}
		return addReturn;
	}

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(Object item) {
		//System.out.println("Adding at " + this.size()); //debug
		return this.add(this.size(), item);
	}

	
	// Helper methods
	// detect whether an index is out of bounds - this differs depending on whether you're looking up an index or adding
	private boolean	validIndex(int index, String oper) {
		int maxIndex = this.size();
		if(oper.equals("add")) {
			maxIndex++;
		}
		if((index < 0) || (index >= maxIndex)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Get a string representation of the items currently in the list. If the list is
	 * empty an empty string is returned.
	 * @return a string representing the objects currently in the list
	 */
	public String toString() {
		String returnString = "";
		LinkedListItem currentItem = head;
		if(this.size() > 0) {
			do {
				returnString = returnString + currentItem.toString() + ", ";
				currentItem = currentItem.getNext();
			} while(currentItem != null);
		}
		if(returnString.length() > 0) {
			returnString = returnString.substring(0, (returnString.length() - 2));
		}
		return returnString;
	}

}
