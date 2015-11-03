public class SampleableListImpl extends ArrayList implements SampleableList {
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableList sample() {
		SampleableList sampleList = new SampleableListImpl();
		int sourceListSize = this.size();
		for(int i = 0; i < sourceListSize; i++) {
			if((i % 2) == 0) {
				sampleList.add(this.get(i).getReturnValue());
			}
		}
		return sampleList;
	}
}