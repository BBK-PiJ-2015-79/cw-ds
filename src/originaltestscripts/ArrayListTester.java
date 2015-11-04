public class FunctionalArrayListTester {
	public static void main(String[] args) {
		FunctionalArrayListTester listTest = new FunctionalArrayListTester();
		listTest.launch();
	}

	public void launch() {
		
		System.out.println("Welcome, let's create a new ArrayList");
		FunctionalArrayList testFAL = new FunctionalArrayList();
		//System.out.println(Integer.toString(testFAL.size()));
		//System.out.println(testFAL.toString());
		ReturnObject testObj = testFAL.add(0, new Integer(7));
		//System.out.println(testObj.getError());
		testObj = testFAL.add(1, "A lovely mug");
		//System.out.println(testObj.getError());
		//System.out.println(Integer.toString(testFAL.size()));
		System.out.println(testFAL.toString());
		testObj = testFAL.add("Four candles");
		testObj = testFAL.add(new Boolean(true));
		testObj = testFAL.add("BING BING");

		System.out.println(testFAL.toString());

		testObj = testFAL.add(2, "NEW TWO!");

		System.out.println(testFAL.toString());

		testObj = testFAL.remove(3);

		System.out.println("Removed " + testObj.toString());

		System.out.println(testFAL.toString());
		
		testObj = testFAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFAL.size()));
		testObj = testFAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFAL.size()));
		testObj = testFAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFAL.size()));
		testObj = testFAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFAL.size()));
		testObj = testFAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFAL.size()));

		System.out.println(testFAL.toString());

		testObj = testFAL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFAL.size()));

		testObj = testFAL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testFAL.size()));

		System.out.println(testFAL.toString());
	}
}