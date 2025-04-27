package question3;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
	protected boolean addReturn;
	
	public E find(E target) {
		return find(root, target);
	}
	
	private E find(Node<E> localRoot, E target) {
    	// if the localRoot is null, or not found
    	if(localRoot == null) {
    		return null;
    	}
        int compResult = target.compareTo(localRoot.data);


        if(compResult == 0) {
        	return localRoot.data;
        }
        else if(compResult < 0) {
        	return find(localRoot.left, target);
        }
        else {
        	return find(localRoot.right, target);
        }
	}
	
	public boolean contains(E target) {
		return find(target) != null;
	}
	
	public boolean add(E target) {
        root = add(root, target);
        return addReturn;
	}
	
	private Node<E> add(Node<E> localRoot, E item) {
    	if(localRoot == null) {
    		addReturn = true;
    		return new Node<E>(item);
    	}
    	int compResult = item.compareTo(localRoot.data);
    	if (compResult == 0) {
    		addReturn = false;
    		return localRoot;
    	}
    	else if (compResult < 0) {
    		localRoot.left = add(localRoot.left, item);
    		return localRoot;
    	}
    	else {
    		localRoot.right = add(localRoot.right, item);
    		return localRoot;
    	}
	}
}
