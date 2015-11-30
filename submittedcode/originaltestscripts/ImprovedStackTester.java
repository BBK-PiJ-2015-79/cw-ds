public class ImprovedStackTester {
	public static void main(String[] args) {
		ImprovedStackTester iStackTest = new ImprovedStackTester();
		iStackTest.launch();
	}

	public void launch() {
		System.out.println("Welcome, let's create a new Improved Stack");
		ImprovedStack testIStack = new ImprovedStackImpl();

		testIStack.remove(new Integer(8));

		testIStack.push("Alice");
		testIStack.push("Bob");
		testIStack.push("Charlie");
		testIStack.push("Deborah");
		testIStack.push("Eddie");
		testIStack.push("Frederica");
		testIStack.push(new Integer(8));
		System.out.println(testIStack.toString());
		System.out.println(testIStack.reverse().toString());

		System.out.println("Try removing Charlie");
		testIStack.remove("Charlie");
		testIStack.remove(new Integer(4));

		System.out.println(testIStack.toString());
	}
}