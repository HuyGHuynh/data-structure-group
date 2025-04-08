package question1;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class CircularListTest {
	
	@Test
	public void testAdd() { //fills an array using the Add method
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
        assertEquals("Current size of CircularList is 8", (Object) 8, list.size());

	}
	
	@Test
	public void testHasNext() {
		CircularList<Integer> list = new CircularList<>();
		Iterator<Integer> it = list.iterator();
		assertEquals("List is empty, expect false", false, it.hasNext());
		
		list.add(0);
		assertEquals("List have one element, expect true", true, it.hasNext());
	}
	
	@Test
	public void testNextException() {
		CircularList<Integer> list = new CircularList<>();
		Iterator<Integer> it = list.iterator();
		
		//assertEquals("No elements in list, should return 'No element in list' ", "No element in list", it.next());
		NoSuchElementException exception = assertThrows(NoSuchElementException.class, ()->it.next());
	}
	
	@Test
	public void testNextandWrapAround() {
		CircularList<Integer> list = new CircularList<>();
		Iterator<Integer> it = list.iterator();
	
		for(int i = 1; i < 5; i++) {
			list.add(i);
		}
		System.out.println(list.toString());
		
		assertEquals("Next element should be 4 (Next is set to current on first next())", Integer.valueOf(4), it.next());
		assertEquals("Next element should be 1 (4 wraps around the list to 1)", Integer.valueOf(1), it.next());
		assertEquals("Next element should be 2", Integer.valueOf(2), it.next());
		assertEquals("Next element should be 3", Integer.valueOf(3), it.next());
		
	}

	//Tests to see if remove returns exception if next is not called
	@Test
	public void testRemoveException() {
		CircularList<Integer> list = new CircularList<>(); //create list
		Iterator<Integer> it = list.iterator();
		
		IllegalStateException exception = assertThrows(IllegalStateException.class, ()->it.remove());
	}
	
	//Tests to see if remove returns exception if called twice in a row
	@Test
	public void testRemoveExceptionTwo() {
		CircularList<Integer> list = new CircularList<>(); //create list
		Iterator<Integer> it = list.iterator();
		
		for(int i = 1; i < 6; i++) {
			list.add(i);
		}
		
		it.next();
		it.remove();
		IllegalStateException exception = assertThrows(IllegalStateException.class, ()->it.remove());
		
	}
	
	@Test
	//Slightly redundant test due to the testHasNext() case, but makes sure that hasNext() stops remove() method on an empty list.
	public void testRemoveExceptionThree() {
		CircularList<Integer> list = new CircularList<>();
		Iterator<Integer> it = list.iterator();
		
		list.add(1);
		it.next();
		it.remove();
		NoSuchElementException exception = assertThrows(NoSuchElementException.class, ()->it.next());
		
	}
	
	@Test	
	public void testRemove() {
		CircularList<Integer> list = new CircularList<>(); //create list
		Iterator<Integer> it = list.iterator();
		
		
		//fill list
		for(int i = 1; i < 5; i++) {
			list.add(i);
		}
		
		it.next();
		it.remove();
		assertEquals("List after removing 4 should be '1 2 3'", "1 2 3", list.toString());
		it.next(); // iterator goes to 1
		it.remove(); //iterator removes 1
		assertEquals("List after removing 1 should be '2 3'", "2 3", list.toString());
		
	}
	
	@Test
	public void testGetException() {
		CircularList<Integer> list = new CircularList<>();
		
		NoSuchElementException exception = assertThrows(NoSuchElementException.class, ()->list.get());
	}
	
//	Include some Exception test case as well
}

