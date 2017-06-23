package onedgame;

import org.junit.Test;

import static org.junit.Assert.*;

public class SizedStackTest {

	@Test
	public void testSizedStack() {
		SizedStack<Integer> st = new SizedStack<Integer>(3);
		st.push(13);
		assertEquals(st.size(), 1);
		assertArrayEquals(st.toArray(new Integer[1]), new Integer[]{13});
		st.push(14);
		assertEquals(st.size(), 2);
		assertArrayEquals(st.toArray(new Integer[2]), new Integer[]{13, 14});
		st.push(15);
		assertEquals(st.size(), 3);
		assertArrayEquals(st.toArray(new Integer[3]), new Integer[]{13, 14, 15});
		st.push(42);
		assertEquals(st.size(), 3);
		assertArrayEquals(st.toArray(new Integer[3]), new Integer[]{14, 15, 42});
	}

}
