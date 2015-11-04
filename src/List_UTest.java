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
}