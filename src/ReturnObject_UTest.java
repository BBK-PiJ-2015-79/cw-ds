import org.junit.*;
import static org.junit.Assert.*;

public class ReturnObject_UTest {
	ReturnObject rObj1;
	ReturnObject rObj2;
	ReturnObject rObj3;
	ReturnObject rObj4;
	ReturnObject rObj5;
	ReturnObject rObj6;
	ReturnObject rObj7;
	ReturnObject rObj8;

	@Before
	public void setup() {
		rObj1 = new ReturnObjectImpl(new Integer(1), ErrorMessage.NO_ERROR);
		rObj2 = new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
	   
	    rObj3 = new ReturnObjectImpl(new Integer(3), ErrorMessage.EMPTY_STRUCTURE);
	    rObj4 = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);

	    rObj5 = new ReturnObjectImpl(new Integer(5), ErrorMessage.INDEX_OUT_OF_BOUNDS);
	    rObj6 = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);

	    rObj7 = new ReturnObjectImpl(new Integer(7), ErrorMessage.INVALID_ARGUMENT);
	    rObj8 = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);		
	}

	@Test
	public void testNO_ERRORIffHasErrorIsFalse() {
		assertTrue(NEIffNHE(rObj1));
		assertTrue(NEIffNHE(rObj2));
		assertTrue(NEIffNHE(rObj3));
		assertTrue(NEIffNHE(rObj4));
		assertTrue(NEIffNHE(rObj5));
		assertTrue(NEIffNHE(rObj6));
		assertTrue(NEIffNHE(rObj7));
		assertTrue(NEIffNHE(rObj8));
	}

	private boolean NEIffNHE(ReturnObject rObj) {
		boolean hasError = rObj.hasError();
		boolean errorMessageIsNE = (rObj.getError() == ErrorMessage.NO_ERROR);
		return ((hasError && !errorMessageIsNE) || (!hasError && errorMessageIsNE));
	}

	@Test
	public void testObjectReturn() {
		assertNotNull(rObj1.getReturnValue());
		assertNotNull(rObj3.getReturnValue());
		assertNotNull(rObj5.getReturnValue());
		assertNotNull(rObj7.getReturnValue());
	}

	@Test
	public void testNullReturn() {
		assertNull(rObj2.getReturnValue());
		assertNull(rObj4.getReturnValue());
		assertNull(rObj6.getReturnValue());
		assertNull(rObj8.getReturnValue());
	}
}
