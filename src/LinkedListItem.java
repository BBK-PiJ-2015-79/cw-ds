public class LinkedListItem {
	/*
	 * Linked list items defined as an inner class.
	 */
	private Object listObject;
	private LinkedListItem next;

	public LinkedListItem(Object listObject) {
		this.listObject = listObject;
		this.next = null;
	}

	public void setNext(LinkedListItem next) {
		this.next = next;
	}

	public LinkedListItem getNext() {
		return this.next;
	}

	public boolean hasNext() {
		if(this.next == null) {
			return false;
		}
		else {
			return true;
		}
	}

	public Object getListItem() {
		return this.listObject;
	}

	public void add(LinkedListItem newItem) {
		if(this.next == null) {
			this.next = newItem;
		}
		else {
			this.getNext().add(newItem);
		}
	}

	public int size() {
		if(this.next == null) {
			return 1;
		}
		else {
			return 1 + this.size();
		}
	}
}
