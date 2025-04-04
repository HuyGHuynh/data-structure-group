import static org.junit.Assert.*;

import org.junit.Test;

public class CircularListTest {

	private CircularList<Integer> myList = new CircularList<>();
	
	@Test
	public void testAddandGet() { //fills an array using the Add method
		
		String result = "";
		
		for(int i = 1; i < 6; i++) {
			//Node<E> newNode = new Node<>(i);
			myList.add(i);
			result = result + String.valueOf(myList.get()) + " ";
			//System.out.println(i);
			//System.out.println(myList.get());
		}
		
		assertEquals("1 2 3 4 5 ", result);
	}
	
	//as apart of the add method functionality, current should equal the newly added element
	//This is a second test of the add method, but it tests the "current" variable
	//public void testAddCurrent() {
	//	return null;
	//}
	
	public void testNextandCurrent() {

	}
	
	public void testWrapAround() {

	}
	
	
	public void testGet() {

	}
	
	
	public void testRemove() {
	

	}

}

