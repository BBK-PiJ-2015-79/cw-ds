import org.junit.*;
import static org.junit.Assert.*;

public class List_UTest {
	List aList;

	@Before
	public void setup() {
		this.aList = new ArrayList();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(aList.isEmpty());
	}

	@Test
	public void testAddingRemoving() {
		assertEquals(aList.size(), 0);
		aList.remove(0);
		assertEquals(aList.size(), 0);
		aList.add(new Integer(0));
		assertEquals(aList.size(), 1);
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
		aList.remove(0);
		assertEquals(aList.size(), 5);
	}
}