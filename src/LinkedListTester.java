public class LinkedListTester {
	public static void main(String[] args) {
		LinkedListTester listTest = new LinkedListTester();
		listTest.launch();
	}

	public void launch() {
		/*
		// none of this seemed to be a problem before?
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
		System.out.println("Removed " + testObj.toString());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		System.out.println("=======");

		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Removed " + testObj.toString());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		System.out.println("=======");

		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Removed " + testObj.toString());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		System.out.println("=======");

		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Removed " + testObj.toString());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		System.out.println("=======");

		testObj = testLL.remove(1);
		System.out.println(testObj.getError());
		System.out.println("Removed " + testObj.toString());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		System.out.println("=======");

		System.out.println(testLL.toString());

		testObj = testLL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Removed " + testObj.toString());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		System.out.println("=======");

		testObj = testLL.remove(0);
		System.out.println(testObj.getError());
		System.out.println("Removed " + testObj.toString());
		System.out.println("Size: " + Integer.toString(testLL.size()));
		System.out.println("=======");

		System.out.println(testLL.toString());
		*/
		LinkedList aList = new LinkedList();
		System.out.println(aList.toString());
		//assertEquals(aList.size(), 0);
		//assertTrue(aList.get(0).hasError());
		aList.remove(0);
		System.out.println(aList.toString());
		//assertEquals(aList.size(), 0);
		aList.add(new Integer(0));
		System.out.println(aList.toString());
		//assertEquals(aList.size(), 1);
		//assertFalse(aList.get(0).hasError());
		aList.add(new Integer(1));
		System.out.println(aList.toString());
		//assertEquals(aList.size(), 2);
		aList.add(new Integer(2));
		System.out.println(aList.toString());
		//assertEquals(aList.size(), 3);
		aList.add(new Integer(3));
		System.out.println(aList.toString());
		//assertEquals(aList.size(), 4);
		aList.add(new Integer(4));
		System.out.println(aList.toString());
		//assertEquals(aList.size(), 5);
		aList.add(new Integer(5));
		System.out.println(aList.toString());
		//assertEquals(aList.size(), 6);
		System.out.println("Before: " + aList.toString());
		System.out.println("Size before: " + aList.size());
		ReturnObject rObj = aList.remove(3);
		System.out.println(rObj.getError() + ", " +rObj.toString());
		System.out.println("After: " + aList.toString());
		System.out.println("Size after: " + aList.size());
		//assertEquals(aList.size(), 5);
	}
}