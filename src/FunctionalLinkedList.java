public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	
	public FunctionalLinkedList() {
		super();
	}
	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
    public ReturnObject head() {
    	return this.get(0);
    }

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
    public FunctionalList rest() {
    	FunctionalList restList = this.cloneSelf();
    	restList.remove(0);
    	return restList;
    }

    private FunctionalList cloneSelf() {
    	FunctionalList clonedList = new FunctionalLinkedList();
    	if(this.size() > 0) {
    		for(int i = 0; i < this.size(); i++) {
    			clonedList.add(this.get(i).getReturnValue());
    		}
    	}
    	return clonedList;
    }
}