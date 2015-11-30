import org.junit.*;
import static org.junit.Assert.*;

public class FunctionalList_UTest {
	FunctionalList aList; // array list object
	FunctionalList lList; // linked list object

	@Before
	public void setup() {
		this.aList = new FunctionalArrayList();
		this.lList = new FunctionalLinkedList();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(aList.isEmpty());
	}

	// Helper method, set up lists with 5 elements
	public void resetInstanceLists() {
		aList = new FunctionalArrayList();
		lList = new FunctionalLinkedList();

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
		resetInstanceLists();

		rObjA = aList.get(-1);
		rObjL = lList.get(-1);
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, rObjA.getError());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, rObjL.getError());

		rObjA = aList.get(8);
		rObjL = lList.get(8);
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, rObjA.getError());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, rObjL.getError());

		rObjA = aList.get(0);
		rObjL = lList.get(0);
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());

		rObjA = aList.get(1);
		rObjL = lList.get(1);

		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());
		rObjA = aList.get(2);
		rObjL = lList.get(2);

		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());
		rObjA = aList.get(3);
		rObjL = lList.get(3);

		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());
		rObjA = aList.get(4);
		rObjL = lList.get(4);

		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());

	}

	@Test
	public void testRemoveAtAllIndices() {
		ReturnObject rObjA;
		ReturnObject rObjL;

		resetInstanceLists();

		rObjA = aList.remove(0);
		rObjL = lList.remove(0);
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());
		assertEquals(4, aList.size());
		assertEquals(4, lList.size());

		resetInstanceLists();

		rObjA = aList.remove(1);
		rObjL = lList.remove(1);
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());
		assertEquals(4, aList.size());
		assertEquals(4, lList.size());
		
		resetInstanceLists();

		rObjA = aList.remove(2);
		rObjL = lList.remove(2);
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());
		assertEquals(4, aList.size());
		assertEquals(4, lList.size());
		
		resetInstanceLists();

		rObjA = aList.remove(3);
		rObjL = lList.remove(3);
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());
		assertEquals(4, aList.size());
		assertEquals(4, lList.size());
		
		resetInstanceLists();

		rObjA = aList.remove(4);
		rObjL = lList.remove(4);
		assertEquals(ErrorMessage.NO_ERROR, rObjA.getError());
		assertEquals(ErrorMessage.NO_ERROR, rObjL.getError());
		assertEquals(4, aList.size());
		assertEquals(4, lList.size());
		
	}

	@Test
	public void testGetHeadEmptyList() {
		ReturnObject rObjA;
		ReturnObject rObjL;

		rObjA = aList.head();
		rObjL = lList.head();

		assertEquals(ErrorMessage.EMPTY_STRUCTURE, rObjA.getError());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, rObjL.getError());
	}

	@Test
	public void testGetRestEmptyList() {
		FunctionalList restA;
		FunctionalList restL;

		restA = aList.rest();
		restL = lList.rest();

		assertEquals(0, restA.size());
		assertEquals(0, restL.size());
	}

	@Test
	public void getRestSingleEntry() {
		FunctionalList restA;
		FunctionalList restL;

		aList.add("Hello");
		lList.add("Hello");

		//System.out.println(aList.toString());
		//System.out.println(lList.toString());

		restA = aList.rest();
		restL = lList.rest();

		//System.out.println(restA.toString());
		//System.out.println(restL.toString());
		assertFalse(aList.head().hasError());
		assertFalse(lList.head().hasError());
		assertEquals(0, restA.size());
		assertEquals(0, restL.size());		
	}

	@Test
	public void testHeadDoesNotChange() {
		aList.add("One");
		lList.add("One");

		assertEquals("One", aList.head().getReturnValue());
		assertEquals("One", lList.head().getReturnValue());

		aList.add("Two");
		aList.add("Two");

		assertEquals("One", aList.head().getReturnValue());
		assertEquals("One", lList.head().getReturnValue());

		aList.add("Three");
		aList.add("Three");

		assertEquals("One", aList.head().getReturnValue());
		assertEquals("One", lList.head().getReturnValue());

		aList.add("Four");
		aList.add("Four");

		assertEquals("One", aList.head().getReturnValue());
		assertEquals("One", lList.head().getReturnValue());

		aList.add("Five");
		aList.add("Five");

		assertEquals("One", aList.head().getReturnValue());
		assertEquals("One", lList.head().getReturnValue());

		aList.add("Six");
		aList.add("Six");

		assertEquals("One", aList.head().getReturnValue());
		assertEquals("One", lList.head().getReturnValue());
	}
}
