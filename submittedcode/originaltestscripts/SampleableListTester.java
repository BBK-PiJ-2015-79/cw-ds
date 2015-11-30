public class SampleableListTester {
	public static void main(String[] args) {
		SampleableListTester listTest = new SampleableListTester();
		listTest.launch();
	}

	public void launch() {
		
		System.out.println("Welcome, let's create a new SampleableList");

		SampleableList sList = new SampleableListImpl();
		ReturnObject testObj = sList.add(0, new Integer(7));
		testObj = sList.add(1, "A lovely mug");
		System.out.println(sList.toString());
		testObj = sList.add("Four candles");
		testObj = sList.add(new Boolean(true));
		testObj = sList.add("BING BING");
		System.out.println(sList.toString());
		System.out.println("Sample: ");
		System.out.println(sList.sample().toString());
	}
}