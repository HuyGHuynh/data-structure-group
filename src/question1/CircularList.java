package question1;

public class CircularList<E> implements Iterable<E> {
	private int current;
	private int size;
	
	public CircularList() {
		
	}
	
	public void add(E item) {
		
	}
	
	public E get() {
		return null;
		
	}
	
	public int size() {
		return 0;
	}
	
	public Iterator<E> iterator() {
		return null;
	}
	
	private class Node<E> {
		E data;
		Node next;
		
		public Node(E item) {
			
		}
	}
	
	private class CircIterator implements Iterator<E> {
		Node<E> next;
		Node<E> previous;
		boolean nextCalled;
		
		public CircIterator() {
			
		}
		
		public boolean hasNext() {
			return false;
		}
		
		public E next() {
			return null;
		}
		
		public void remove() {

		}
	}
}
