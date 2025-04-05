package question1;

import java.util.NoSuchElementException;

public class CircularList<E> implements Iterable<E> {
    private Node<E> current;
    private int size;

    public CircularList() {
        this.current = null;
        this.size = 0;
    }

    public void add(E item) {
    	// Create a new Node
        Node<E> newNode = new Node<>(item);

        if (size == 0) { // If the list is empty, point the current to the newNode
            current = newNode;
            current.next = current;
        } else { // Link newNode to next node in the list, update next pointer of current, and update current node
            newNode.next = current.next;
            current.next = newNode;
            current = newNode;
        }
        
        // Increase list size by 1
        size++;
    }

    public E get() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return current.data;
    }

    public int size() {
        return size;
    }
    
    public Iterator<E> iterator() {
    	CircIterator iterator = new CircIterator();
        return iterator;
    }
    
    /** Helper function to print circular linked list.
     * Stop at predecessor of current node to prevent infinite loop
     *
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	Node<E> temp = current;
    	for(int i = 0; i < this.size; i++) {
    		
    		sb.append(temp.data + " ");
    		temp = temp.next;
    	}
    	
    	return sb.toString().trim();
    }

    private class Node<E> {
        E data;
        Node<E> next;

        public Node(E item) {
            this.data = item;
            this.next = null;
        }
    }

    private class CircIterator implements Iterator<E> {
        Node<E> next;
        Node<E> previous;
        boolean nextCalled;

        public CircIterator() {
            this.next = current; 
            this.previous = null;
            this.nextCalled = false;
        }

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E data = next.data;
            previous = next;
            next = next.next;
            nextCalled = true;
            return data;
        }

        @Override
        public void remove() {
            if (!nextCalled) {
                throw new IllegalStateException("next() must be called before remove()");
            }

            if (size == 1) {
                current = null;
                next = null;
                previous = null;
            } else {
                Node<E> temp = current;
                while (temp.next != previous) {
                    temp = temp.next;
                }

                temp.next = next;
                if (previous == current) {
                    current = next;
                }
            }

            size--;
            nextCalled = false;
        }
    }
    
    public static void main(String[] args) {
        
        CircularList<Integer> list = new CircularList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("List size: " + list.size());  // Should print 3
        System.out.println("Current: " + list.get());  // Should print 3
//
//        Iterator<Integer> it = list.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//        it = list.iterator();  
//        while (it.hasNext()) {
//            int value = it.next();
//            if (value == 2) {
//                it.remove();  
//            }
//        }
//
//        System.out.println("List size after removal: " + list.size());  // Should print 2
//        it = list.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
    
    }
}
