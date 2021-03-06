/**
 * An implementation of the List interface based on Arrays. Written as part
 * of coursework 2 for the 2015 Programming in Java module at Birkbeck.
 *
 * @author Chris Grocott
 */
public class ArrayList implements List {
	private Object[] objArray;
	private static final int MIN_ARRAY_SIZE = 5;
	
	public ArrayList() {
		this.objArray = new Object[5];
	}

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		if(this.size() == 0) {
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
		int objArraySize = this.objArray.length;
		int listSize = 0;
		for(int i=0; i < objArraySize; i++) {
			if(objArray[i] == null) {
				break; // safe assuming no 'gaps'
			}
			else {
				listSize++;
			}
		}
		return listSize;
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
		if(this.isEmpty()) {
			getReturn = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
		}
		else if(!this.validIndex(index, "get")) {
			getReturn = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else {
			getReturn = new ReturnObjectImpl(this.objArray[index], ErrorMessage.NO_ERROR);
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
			this.objArray[index] = null;
			this.removeNulls();
		}
		if((this.size() == ((this.objArray.length / 2) - 1)) && (this.objArray.length > this.MIN_ARRAY_SIZE)) {
			this.shrinkArray();
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
			// SB asked for clarification on the forums, returning null wrapped object for now CG 30/10/15
			this.makeSpace(index);
			addReturn = new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
			this.objArray[index] = item;
		}
		// if the array is now full we need to increase storage
		if(this.size() == this.objArray.length) {
			this.growArray();
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
		ReturnObject addReturn = this.add(this.size(), item);
		return addReturn;
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
	
	// remove any 'gaps' due to null pointers from the objArray field.
	private void removeNulls() {
		int objArraySize = this.objArray.length;
		for(int i = 0; i < objArraySize; i++) {
			if((this.objArray[i] == null) && (i != (objArraySize - 1))) {
				this.objArray[i] = this.objArray[(i + 1)];
				this.objArray[(i + 1)] = null;
			}
		}
	}
	// resize the objArray.
	private void growArray() {
		int objArraySize = this.objArray.length;
		Object[] resizedArray = new Object[(objArraySize * 2)];
		for(int i = 0; i < objArraySize; i++) {
			resizedArray[i] = this.objArray[i];
		}
		this.objArray = resizedArray;
	}
	private void shrinkArray() {
		int objArraySize = this.objArray.length;
		int newObjArraySize = objArraySize / 2;
		Object[] resizedArray = new Object[newObjArraySize];
		for(int i = 0; i < newObjArraySize; i++) {
			resizedArray[i] = this.objArray[i];
		}
		this.objArray = resizedArray;
	}


	// Helper method for adding a new item, makes a 'hole' in the present array
	private void makeSpace(int index) {
		int currentIndex = this.size();
		while(currentIndex > index) {
			this.objArray[currentIndex] = this.objArray[(currentIndex - 1)];
			this.objArray[(currentIndex - 1)] = null;
			currentIndex--;
		}
	}

	/**
	 * Get a string representation of the items currently in the list. If the list is
	 * empty an empty string is returned.
	 * @return a string representing the objects currently in the list
	 */
	public String toString() {
		String returnString = "";
		int currentSize = (this.size());
		ReturnObject currentReturnObj;
		Object currentObj;
		for(int i = 0; i < currentSize; i++) {
			currentReturnObj = this.get(i);
			if(!currentReturnObj.hasError()) {
				returnString = returnString + currentReturnObj.getReturnValue().toString() + ", ";
			}
			else {
				returnString = returnString + "Error at index " + Integer.toString(i) + ", ";
			}
		}
		if(returnString.length() > 0) {
			returnString = returnString.substring(0, (returnString.length() - 2));
		}
		return returnString;
	}
}
