public class AddAMillion {
	private List myAL;

	public AddAMillion() {
		this.myAL = new ArrayList();
	}

	public static void main(String[] args) {
		AddAMillion testCase = new AddAMillion();
		testCase.launch();
	}

	public void launch() {
		for(int i = 0; i < 1000000; i++) {
			myAL.add(new Object());
		}
	}
}
