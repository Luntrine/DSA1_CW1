import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StackTest {

	Stack st;
	@Before
	public void setup()
	{
		st = new Stack(2);
	}
	
	/*
	 * Part1: complete the following test methods as specified. 
	 * Note that you will need to add new methods in order to test that exceptions are thrown
	 */
	
	@Test
	public void testPushEmptySize() {
		// test the size of an empty stack (hint: test st.size() )
		assertEquals("The stack is empty", st.size(), 0);
	}
	
	@Test
	public void testPushNonEmptySize() {
		st.push("A");
		st.push("B");
		// test the size of a non-empty stack
		assertEquals("The stack size is equal to 4", st.size(), 2);
	}
	
	@Test
	public void testPopTwo() throws Exception {
		st.push("A");
		st.push("B");
		// step 1: test what st.pop() returns
		assertEquals("B is returned", st.pop(), "B");
		// step 2: test what st.pop() returns
		assertEquals("A is returned", st.pop(), "A");
	}
	
	@Test
	public void testTopTwo() throws Exception {
		st.push("A");
		// step 1: test what st.top() returns
		assertEquals("A is returned", st.top(), "A");
		// step 2: test what st.top() returns
		assertEquals("A is returned", st.top(), "A");
	}
	
	
	@Test(expected = StackException.class)
	public void testEmptyPop() {
		// try popping from an empty stack
		st.pop();
	}

	@Test(expected = StackException.class)
	public void testFullPush() {
		// try pushing too many elements to the stack
		// (which has a capacity of 2 elements)
		st.push("A");
		st.push("B");
		//pushing a third element which the stack cannot take as it's size is only 2.
		st.push("C");
	}

}
