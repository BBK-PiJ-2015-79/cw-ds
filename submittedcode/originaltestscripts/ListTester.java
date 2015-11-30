public class ListTester {
	public static void main(String[] args) {
		ListTester listTest = new ListTester();
		listTest.launch();
	}

	public void launch() {
		
		System.out.println("Welcome, let's create a new ArrayList");
		ArrayList testAL = new ArrayList();
		//System.out.println(Integer.toString(testAL.size()));
		//System.out.println(testAL.toString());
		ReturnObject testObj = testAL.add(0, new Integer(7));
		//System.out.println(testObj.getError());
		testObj = testAL.add(1, "A lovely mug");
		//System.out.println(testObj.getError());
		//System.out.println(Integer.toString(testAL.size()));
		System.out.println(testAL.toString());
		testObj = testAL.add("Four candles");
		testObj = testAL.add(new Boolean(true));
		testObj = testAL.add("BING BING");

		System.out.println(testAL.toString());

		testObj = testAL.add(2, "NEW TWO!");

		System.out.println(testAL.toString());

		testObj = testAL.remove(3);

		System.out.println("Removed " + testObj.toString());

		System.out.println(testAL.toString());
		
		testObj = testAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testAL.size()));
		testObj = testAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testAL.size()));
		testObj = testAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testAL.size()));
		testObj = testAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testAL.size()));
		testObj = testAL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testAL.size()));

		System.out.println(testAL.toString());

		testObj = testAL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testAL.size()));

		testObj = testAL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testAL.size()));

		System.out.println(testAL.toString());
	}
}