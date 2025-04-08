package question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularListTest {
	@Test
	public void testAddandGet() { //fills an array using the Add method
		CircularList<Integer> myList = new CircularList<>();
		
		for(int i = 1; i < 6; i++) {
			myList.add(i);

		}
		
		// Should be "5 1 2 3 4".
		// Refer to question example, if start from current node, output is ghi abc def"
		assertEquals("Print the current list: ", myList.toString(), "5 1 2 3 4"); //I implemented toString() for CircularList
	}
	
	//as apart of the add method functionality, current should equal the newly added element
	//This is a second test of the add method, but it tests the "current" variable
	@Test
	public void testAddCurrent() {
        CircularList<Character> list = new CircularList<>();
        list.add('a');
        assertEquals("Current node is a", (Object) 'a', list.get());
        list.add('b');
        assertEquals("Current node is b", (Object) 'b', list.get());
        list.add('c');
        assertEquals("Current node is c", (Object) 'c', list.get());

	}
	
	@Test
	public void testSize() {
        CircularList<Integer> list = new CircularList<>();
        
        // Add 6 element
        for(int i = 0; i < 6; i++) {
        	list.add(i);
        }
        assertEquals("Current size of ircularList is 6", (Object) 6, list.size());
        
        //Add 2 more
        list.add(5);
        list.add(5);
        assertEquals("Current size of ircularList is 8", (Object) 8, list.size());

	}
	
	@Test
	public void testHasNext() {
		CircularList<Integer> list = new CircularList<>();
		Iterator<Integer> it = list.iterator();
		assertEquals("List is empty, expect false", false, it.hasNext());
		
		list.add(0);
		assertEquals("List have one element, expect true", true, it.hasNext());
	}
	
//	@Test
//	public void testNext() {
//
//	}
//	
//	@Test
//	public void testRemove() {
//
//	}
	
//	Include some Exception test case as well
}

