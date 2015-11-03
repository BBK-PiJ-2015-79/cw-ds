public class LinkedListTester {
	public static void main(String[] args) {
		LinkedListTester listTest = new LinkedListTester();
		listTest.launch();
	}

	public void launch() {
		
		System.out.println("Welcome, let's create a new LinkedList");
		LinkedList testLL = new LinkedList(); //size 0
		//System.out.println(Integer.toString(testLL.size()));
		//System.out.println(testLL.toString());
		ReturnObject testObj = testLL.add(0, new Integer(7)); //size 1
		//System.out.println(testObj.getError());
		testObj = testLL.add(1, "A lovely mug");
		//System.out.println(testObj.getError());
		//System.out.println(Integer.toString(testLL.size()));
		System.out.println(testLL.toString());
		testObj = testLL.add("Four candles");
		testObj = testLL.add(new Boolean(true));
		testObj = testLL.add("BING BING");

		System.out.println(testLL.toString());

		testObj = testLL.add(2, "NEW TWO!");

		System.out.println(testLL.toString());

		testObj = testLL.remove(3);

		System.out.println("Removed " + testObj.toString());

		System.out.println(testLL.toString());
		
		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testLL.size()));

		System.out.println(testLL.toString());

		testObj = testLL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testLL.size()));

		testObj = testLL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Size: " + Integer.toString(testLL.size()));

		System.out.println(testLL.toString());
	}
}