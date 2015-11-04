/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 * Original interface by PiJ team.
 * Implemented by Chris Grocott for Coursework 2. October 2015
 *
 * @author PiJ
 * @author Chris Grocott
 */
public class ReturnObjectImpl implements ReturnObject {
	ErrorMessage error;
	Object wrappedObj;
	
	/**
	 * Two argument constructor for ReturnObjectImpl. Setters have not been included
	 * so the only way to set the instance variables is to pass in parameters when the
	 * ReturnObjectImpl is instantiated. This is handled within the code returning a
	 * ReturnObject.
	 *
	 * @param wrappedObj the object to be wrapped by the new ReturnObjectImpl object
	 * @param error the Error Message associated with the ReturnObjectImpl object
	 */
	public ReturnObjectImpl(Object wrappedObj, ErrorMessage error) {
		this.wrappedObj = wrappedObj;
		this.error = error;
	}

	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError() {
		if(this.error != ErrorMessage.NO_ERROR) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError() {
		return this.error;
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an
	 *         error
	 */
	public Object getReturnValue() {
		return this.wrappedObj;
	}
	
	/**
	 * Returns a String describing the wrapped object. The String
	 * returned is the same as if the toString() method were called
	 * on the wrapped object directly.
	 *
	 * @return a String describing the wrapped object
	 */
	public String toString() {
		if(this.wrappedObj == null) {
			return "NULL";
		}
		else {
			return this.wrappedObj.toString();
		}
	}
}
