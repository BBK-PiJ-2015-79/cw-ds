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
		assertEquals(aList.toString(), lList.toString());

		aList.add(new Integer(4));
		lList.add(new Integer(4));

		assertEquals(aList.toString(), lList.toString());

		aList.add(new Integer(6));
		lList.add(new Integer(6));

		assertEquals(aList.toString(), lList.toString());

		aList.add("Hello");
		lList.add("Hello");

		assertEquals(aList.toString(), lList.toString());

		aList.add(new Integer(4));
		lList.add(new Integer(4));

		assertEquals(aList.toString(), lList.toString());

		aList.add("Four candles");
		lList.add("Four candles");

		assertEquals(aList.toString(), lList.toString());

		aList.remove(2);
		lList.remove(2);

		assertEquals(aList.toString(), lList.toString());
	}
}
