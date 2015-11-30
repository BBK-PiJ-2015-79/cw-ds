public class FunctionalLinkedListTester {
	public static void main(String[] args) {
		FunctionalLinkedListTester listTest = new FunctionalLinkedListTester();
		listTest.launch();
	}

	public void launch() {
		
		System.out.println("Welcome, let's create a new ArrayList");
		FunctionalLinkedList testFLL = new FunctionalLinkedList();
		//System.out.println(Integer.toString(testFLL.size()));
		//System.out.println(testFLL.toString());
		ReturnObject testObj = testFLL.add(0, new Integer(7));
		//System.out.println(testObj.getError());
		testObj = testFLL.add(1, "A lovely mug");
		//System.out.println(testObj.getError());
		//System.out.println(Integer.toString(testFLL.size()));
		System.out.println(testFLL.toString());
		testObj = testFLL.add("Four candles");
		testObj = testFLL.add(new Boolean(true));
		testObj = testFLL.add("BING BING");

		System.out.println(testFLL.toString());

		testObj = testFLL.add(2, "NEW TWO!");

		System.out.println(testFLL.toString());

		testObj = testFLL.remove(3);

		System.out.println("Removed " + testObj.toString());

		System.out.println("===========");
		System.out.println(testFLL.rest().toString());
		System.out.println("===========");

		System.out.println(testFLL.toString());
		
		testObj = testFLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFLL.size()));
		testObj = testFLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFLL.size()));
		testObj = testFLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFLL.size()));
		testObj = testFLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFLL.size()));
		testObj = testFLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFLL.size()));

		System.out.println(testFLL.toString());

		testObj = testFLL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFLL.size()));

		testObj = testFLL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFLL.size()));

		System.out.println(testFLL.toString());
	}
}