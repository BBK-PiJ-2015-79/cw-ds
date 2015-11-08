import org.junit.*;
import static org.junit.Assert.*;

public class StackTest_UTest {
	// unit test for stacks
	Stack stAList;
	Stack stLList;

	@Before
	public void setupStacks() {
		stAList = new StackImpl(new ArrayList());
		stLList = new StackImpl(new LinkedList());
	}

	@Test
	public void testAddingElements() {
		ReturnObject rObjA = stAList.pop();
		ReturnObject rObjL = stLList.pop();

		System.out.println(rObjA.getError());
		System.out.println(rObjL.getError());

		stAList.push("one");
		stLList.push("one");

		assertEquals(stAList.toString(), stLList.toString());

		stAList.push("two");
		stLList.push("two");

		assertEquals(stAList.toString(), stLList.toString());

		stAList.push("three");
		stLList.push("three");
		assertEquals(stAList.toString(), stLList.toString());

		assertEquals(stAList.pop().getReturnValue().toString(), stLList.pop().getReturnValue().toString());
	}
}
