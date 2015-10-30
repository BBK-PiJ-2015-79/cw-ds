/**
 * A script for testing the ErrorMessage enumerated type
 *
 * @author Chris Grocott
 */
public class ErrorTest {
	public static void main(String[] args) {
		ErrorTest test = new ErrorTest();
		test.run();
	}
	
	public void run() {
		ErrorMessage myError = ErrorMessage.NO_ERROR;
		System.out.println("Error status: " + myError);
		myError = ErrorMessage.EMPTY_STRUCTURE;
		System.out.println("Error status: " + myError);
		myError = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		System.out.println("Error status: " + myError);
		// you can set an enumerated type to null
		myError = null;
		System.out.println("Error status: " + myError);
		//now let's set it to something else!
		myError = ErrorMessage.INVALID_ARGUMENT;
		System.out.println("Error status: " + myError);
		
		// also need to know about testing equality with enumerated types.
		ErrorMessage anotherError = ErrorMessage.NO_ERROR;
		
		System.out.println(Boolean.toString(anotherError == myError));
		System.out.println(Boolean.toString(anotherError.equals(myError)));
		
		anotherError = ErrorMessage.INVALID_ARGUMENT;
		
		/*
		 * Both of these seem to work, and I think this is something to do with
		 * the fact that you can't ever instantiate an enum. The enum values
		 * themselves are instances, but are static and final(?).
		 */
		System.out.println(Boolean.toString(anotherError == myError));
		System.out.println(Boolean.toString(anotherError.equals(myError)));
		
		
		System.out.println(anotherError.toString());
		System.out.println(anotherError.hashCode());
	}
}
