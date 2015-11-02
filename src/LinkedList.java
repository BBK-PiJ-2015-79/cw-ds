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
		int currentIndex = 1;
		if(this.isEmpty()) {
			getReturn = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
		}
		else if(!this.validIndex(index, "get")) {
			getReturn = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			currentItem = this.head;
			while(currentIndex < index) {
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
			if((index == 1) && (this.size() == 1)) {
				this.head = null;
			}
			else if(index == 1) {
				this.head = this.head.getNext();
			}
			else {
				//work through and re-assign pointers
				int currentIndex = 1;
				LinkedListItem currentItem = this.head;
				while(currentIndex < (index - 1)) {
					currentItem = currentItem.getNext();
					currentIndex++;
				}
				currentItem.setNext(currentItem.getNext());
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
			addReturn = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
		}
		else if(!this.validIndex(index, "add")) {
			addReturn = new ReturnObjectImpl(item, ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			LinkedListItem newItem = new LinkedListItem(item);
			LinkedListItem currentItem = this.head;
			int currentIndex = 1;
			while(currentIndex < (index - 1)) {
				currentItem = currentItem.getNext();
				currentIndex++;
			}
			if(currentItem.hasNext()) {
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
		return this.add(this.size(), item);
	}

	/*
	 * Helper methods
	 */
	//detect whether an index is out of bounds - however, this differs depending on whether you're looking up an index or adding!
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

}
