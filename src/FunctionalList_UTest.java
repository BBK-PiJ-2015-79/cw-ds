import org.junit.*;
import static org.junit.Assert.*;

public class FunctionalList_UTest {
	FunctionalList fAList; // array list object
	FunctionalList fLList; // linked list object

	@Before
	public void setup() {
		this.fAList = new FunctionalArrayList();
		this.fLList = new FunctionalLinkedList();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(fAList.isEmpty());
	}

	@Test
	public void testAddingRemovingArrayList() {
		assertEquals(fAList.size(), 0);
		assertTrue(fAList.get(0).hasError());
		fAList.remove(0);
		assertEquals(fAList.size(), 0);
		fAList.add(new Integer(0));
		assertEquals(fAList.size(), 1);
		assertFalse(fAList.get(0).hasError());
		fAList.add(new Integer(0));
		assertEquals(fAList.size(), 2);
		fAList.add(new Integer(0));
		assertEquals(fAList.size(), 3);
		fAList.add(new Integer(0));
		assertEquals(fAList.size(), 4);
		fAList.add(new Integer(0));
		assertEquals(fAList.size(), 5);
		fAList.add(new Integer(0));
		assertEquals(fAList.size(), 6);
		//System.out.println("Before: " + fAList.toString());
		//System.out.println("Size before: " + fAList.size());
		ReturnObject rObj = fAList.remove(3);
		//System.out.println(rObj.getError());
		//System.out.println("After: " + fAList.toString());
		//System.out.println("Size after: " + fAList.size());
		assertEquals(fAList.size(), 5);
		//System.out.println(fAList.toString());
	}
	@Test
	public void testAddingRemovingLinkedList() {
		assertEquals(fLList.size(), 0);
		assertTrue(fLList.get(0).hasError());
		fLList.remove(0);
		assertEquals(fLList.size(), 0);
		fLList.add(new Integer(0));
		assertEquals(fLList.size(), 1);
		assertFalse(fLList.get(0).hasError());
		fLList.add(new Integer(0));
		assertEquals(fLList.size(), 2);
		fLList.add(new Integer(0));
		assertEquals(fLList.size(), 3);
		fLList.add(new Integer(0));
		assertEquals(fLList.size(), 4);
		fLList.add(new Integer(0));
		assertEquals(fLList.size(), 5);
		fLList.add(new Integer(0));
		assertEquals(fLList.size(), 6);
		//System.out.println("Before: " + fLList.toString());
		//System.out.println("Size before: " + fLList.size());
		ReturnObject rObj = fLList.remove(3);
		//System.out.println(rObj.getError());
		//System.out.println("After: " + fLList.toString());
		//System.out.println("Size after: " + fLList.size());
		assertEquals(fLList.size(), 5);
		//System.out.println(fLList.toString());
	}
	@Test
	public void testBothListsTheSameAfterAddingAndRemoving() {
		//assertEquals(fAList.toString(), fLList.toString());
		testListStringsMatch();
		ReturnObject rObjA;
		ReturnObject rObjL;

		rObjA = fAList.add(new Integer(4));
		rObjL = fLList.add(new Integer(4));

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(fAList.toString(), fLList.toString());
		testListStringsMatch();

		rObjA = fAList.add(new Integer(6));
		rObjL = fLList.add(new Integer(6));

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(fAList.toString(), fLList.toString());
		testListStringsMatch();

		rObjA = fAList.add("Hello");
		rObjL = fLList.add("Hello");

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(fAList.toString(), fLList.toString());
		testListStringsMatch();

		rObjA = fAList.add(new Integer(4));
		rObjL = fLList.add(new Integer(4));

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(fAList.toString(), fLList.toString());
		testListStringsMatch();

		rObjA = fAList.add("Four candles");
		rObjL = fLList.add("Four candles");

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(fAList.toString(), fLList.toString());
		testListStringsMatch();

		rObjA = fAList.remove(2);
		rObjL = fLList.remove(2);

		testReturnObjectsMatch(rObjA, rObjL);

		//assertEquals(fAList.toString(), fLList.toString());
		testListStringsMatch();
	}
	@Test
	public void returnObjectsSameFromBothLists() {
		ReturnObject rObjA = fAList.get(0);
		ReturnObject rObjL = fLList.get(0);
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
		assertEquals(fAList.toString(), fLList.toString());
	}
/*
	public void addToBothLists(Object someObject) {
		fAList.add(someObject);
		fLList.add(someObject);
	}

	public void removeFromBothLists(int someIndex) {

	}
*/
}
