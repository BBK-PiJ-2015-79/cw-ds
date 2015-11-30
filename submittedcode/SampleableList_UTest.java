import org.junit.*;
import static org.junit.Assert.*;

public class SampleableList_UTest {
	//
	SampleableList sList;

	@Before
	public void setup() {
		this.sList = new SampleableListImpl();
	}

	public void addSomeIntegers(int n) {
		for(int i = 0; i < n; i++) {
			sList.add(new Integer(i));
		}
	}

	@Test
	public void testSampleEmptyList() {
		SampleableList sampledList = sList.sample();
		System.out.println(sampledList.toString());
		assertEquals(0, sampledList.size());
	}

	@Test
	public void testSampleOfTen() {
		addSomeIntegers(10);
		SampleableList sampledList = sList.sample();

		System.out.println(sList.toString());
		System.out.println(sampledList.toString());

		assertEquals((sList.size() / 2), sampledList.size());
	}
}
