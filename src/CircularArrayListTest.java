import static org.junit.Assert.*;

import org.junit.*;
public class CircularArrayListTest {

	
	@Test
	public void test_baseCase() throws Exception {

		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (10);
		//Complete testcase to check elements at few positions
		assertEquals(0, cal.getFront());

		cal.addRear(1);

		cal.addRear(3);
		cal.addRear(2);
		cal.addRear(4);

		assertEquals(0, cal.getFront());
		assertEquals( new Integer(1), cal.remove());
		assertEquals(1, cal.getFront());

		assertEquals(3, cal.getSize());
		assertEquals(3, cal.getRear());

		assertEquals(new Integer(3), cal.remove());
		assertEquals(new Integer(2), cal.remove());
		assertEquals(3, cal.getFront());
		assertEquals(3, cal.getRear());
		assertEquals(new Integer(4), cal.remove());
		assertEquals(4, cal.getFront());

	}

	@Test
	public void test_baseCase2() throws Exception {

		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (10);
		//Complete testcase to check elements at few positions
		cal.addFront(1);
		cal.addFront(3);
		cal.addFront(2);
		cal.addFront(4);

		assertEquals(new Integer(1), cal.get(3));

		try{
			cal.get(6);
		}catch (Exception e) {
			assertEquals("Element doesn’t exist", e.getMessage());
		}
		assertEquals(6, cal.getFront());
		assertEquals( new Integer(4), cal.remove());
		assertEquals(7, cal.getFront());

		assertEquals(3, cal.getSize());
		assertEquals(-1, cal.getRear());

		assertEquals(new Integer(2), cal.remove());
		assertEquals(new Integer(3), cal.remove());
		assertEquals(9, cal.getFront());
		assertEquals(-1, cal.getRear());
		assertEquals(new Integer(1), cal.remove());
		assertEquals(0, cal.getFront());
	}

	@Test
	public void testExtend() throws Exception {

		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (5);
		//Complete testcase to check elements at few positions
		cal.addFront(1);
		cal.addFront(3);
		cal.addFront(2);
		cal.addFront(4);

		assertEquals(4, cal.getSize());
		assertEquals(5, cal.getCapacity());

		cal.addRear(5);

		assertEquals(5, cal.getSize());
		assertEquals(10, cal.getCapacity());

		assertEquals(new Integer(1), cal.get(3));

		try{
			cal.get(6);
		}catch (Exception e) {
			assertEquals("Element doesn’t exist", e.getMessage());
		}
		assertEquals(0, cal.getFront());
		assertEquals( new Integer(4), cal.remove());
		assertEquals(1, cal.getFront());

		assertEquals(4, cal.getSize());
		assertEquals(4, cal.getRear());

		assertEquals(new Integer(2), cal.remove());
		assertEquals(new Integer(3), cal.remove());
		assertEquals(3, cal.getFront());
		assertEquals(4, cal.getRear());
		assertEquals(new Integer(1), cal.remove());
		assertEquals(4, cal.getFront());

		assertEquals(1, cal.getSize());
		assertEquals(10, cal.getCapacity());
	}
	
}
