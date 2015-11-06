import org.junit.*;
import static org.junit.Assert.*;

public class List_UTest {
	List aList; // array list object
	List lList; // linked list object

	@Before
	public void setup() {
		this.aList = new ArrayList();
		this.lList = new LinkedList();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(aList.isEmpty());
	}

	@Test
	public void testAddingRemovingArrayList() {
		assertEquals(aList.size(), 0);
		assertTrue(aList.get(0).hasError());
		aList.remove(0);
		assertEquals(aList.size(), 0);
		aList.add(new Integer(0));
		assertEquals(aList.size(), 1);
		assertFalse(aList.get(0).hasError());
		aList.add(new Integer(0));
		assertEquals(aList.size(), 2);
		aList.add(new Integer(0));
		assertEquals(aList.size(), 3);
		aList.add(new Integer(0));
		assertEquals(aList.size(), 4);
		aList.add(new Integer(0));
		assertEquals(aList.size(), 5);
		aList.add(new Integer(0));
		assertEquals(aList.size(), 6);
		//System.out.println("Before: " + aList.toString());
		//System.out.println("Size before: " + aList.size());
		ReturnObject rObj = aList.remove(3);
		//System.out.println(rObj.getError());
		//System.out.println("After: " + aList.toString());
		//System.out.println("Size after: " + aList.size());
		assertEquals(aList.size(), 5);
		//System.out.println(aList.toString());
	}
	@Test
	public void testAddingRemovingLinkedList() {
		assertEquals(lList.size(), 0);
		assertTrue(lList.get(0).hasError());
		lList.remove(0);
		assertEquals(lList.size(), 0);
		lList.add(new Integer(0));
		assertEquals(lList.size(), 1);
		assertFalse(lList.get(0).hasError());
		lList.add(new Integer(0));
		assertEquals(lList.size(), 2);
		lList.add(new Integer(0));
		assertEquals(lList.size(), 3);
		lList.add(new Integer(0));
		assertEquals(lList.size(), 4);
		lList.add(new Integer(0));
		assertEquals(lList.size(), 5);
		lList.add(new Integer(0));
		assertEquals(lList.size(), 6);
		//System.out.println("Before: " + lList.toString());
		//System.out.println("Size before: " + lList.size());
		ReturnObject rObj = lList.remove(3);
		//System.out.println(rObj.getError());
		//System.out.println("After: " + lList.toString());
		//System.out.println("Size after: " + lList.size());
		assertEquals(lList.size(), 5);
		//System.out.println(lList.toString());
	}
	@Test
	public void testBothListsTheSameAfterAddingAndRemoving() {
		//assertEquals(aList.toString(), lList.toString());
		testListStringsMatch();
		ReturnObject rObjA;
		ReturnObject rObjL;

		rObjA = aList.add(new Integer(4));
		rObjL = lList.add(new Integer(4));

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(aList.toString(), lList.toString());
		testListStringsMatch();

		rObjA = aList.add(new Integer(6));
		rObjL = lList.add(new Integer(6));

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(aList.toString(), lList.toString());
		testListStringsMatch();

		rObjA = aList.add("Hello");
		rObjL = lList.add("Hello");

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(aList.toString(), lList.toString());
		testListStringsMatch();

		rObjA = aList.add(new Integer(4));
		rObjL = lList.add(new Integer(4));

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(aList.toString(), lList.toString());
		testListStringsMatch();

		rObjA = aList.add("Four candles");
		rObjL = lList.add("Four candles");

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(aList.toString(), lList.toString());
		testListStringsMatch();

		rObjA = aList.remove(2);
		rObjL = lList.remove(2);

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(aList.toString(), lList.toString());
		testListStringsMatch();
	}
	@Test
	public void returnObjectsSameFromBothLists() {
		ReturnObject rObjA = aList.get(0);
		ReturnObject rObjL = lList.get(0);
		//assertEquals(rObjA.hasError(), rObjL.hasError());
		//assertEquals(rObjA.getError(), rObjL.getError());
		//assertEquals(rObjA.getReturnValue(), rObjL.getReturnValue());
		testReturnObjectsMatch(rObjA, rObjL);
	}

	public void testReturnObjectsMatch(ReturnObject rObjA, ReturnObject rObjL) {
		assertEquals(rObjA.hasError(), rObjL.hasError());
		assertEquals(rObjA.getError(), rObjL.getError());
		assertEquals(rObjA.getReturnValue(), rObjL.getReturnValue());
	}

	public void testListStringsMatch() {
		assertEquals(aList.toString(), lList.toString());
	}

	@Test
	public void testInvalidIndexReturnsError() {
		ReturnObject rObjA;
		ReturnObject rObjL;

		// set up instance lists
		aList.add(new Integer(4));
		lList.add(new Integer(4));
		aList.add(new Integer(6));
		lList.add(new Integer(6));
		aList.add("Hello");
		lList.add("Hello");
		aList.add(new Integer(4));
		lList.add(new Integer(4));
		aList.add("Four candles");
		lList.add("Four candles");

		rObjA = aList.get(-1);
		rObjL = lList.get(-1);
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, rObjA.getError());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, rObjA.getError());

		rObjA = aList.get(8);
		rObjL = lList.get(8);
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, rObjA.getError());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, rObjA.getError());

		rObjA = aList.get(0);
		rObjL = lList.get(0);
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());

		rObjA = aList.get(1);
		rObjL = lList.get(1);

		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		rObjA = aList.get(2);
		rObjL = lList.get(2);

		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		rObjA = aList.get(3);
		rObjL = lList.get(3);

		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		rObjA = aList.get(4);
		rObjL = lList.get(4);

		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());

	}
/*
	public void addToBothLists(Object someObject) {
		aList.add(someObject);
		lList.add(someObject);
	}

	public void removeFromBothLists(int someIndex) {

	}
*/
}
