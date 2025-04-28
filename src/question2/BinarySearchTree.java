package question2;

public class BinarySearchTree 
		<E extends Comparable <E> > 
		   extends BinaryTree<E>
{
	/**Boolean to keep track of whether or not add method added correctly */
	protected boolean addReturn;
	/**Boolean to keep track of whether or not delete method deleted correctly */
	protected E deleteReturn;
	
	//Need to implement
    public E find(E target) {
        return find(root, target);
    }

    /**
     * Recursive find method.
     *
     * @param localRoot The local subtrees root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {
    	E foundNode;
    	
    	// if the localRoot is null, or not found
    	if (localRoot == null) {
    		foundNode = null;
    	}
    	//If the target equals localRoot.data
    	else if(target.compareTo(localRoot.data) == 0) { 
    		foundNode = localRoot.data;
    	}
    	//If target is greater than localRoot.data
    	else if(target.compareTo(localRoot.data) > 0) {
    		foundNode = find(localRoot.right, target);
    	}
    	//If target is less than localRoot.data
    	else { 
    		foundNode = find(localRoot.left, target);
    	}
 
    	return foundNode;
		    	
    }
	
    /**
	 * This method calls the find method to determine if a node is in a tree
	 * @param target: the node to find
	 * @return return whether or not the tree contains the target
	 */
	public boolean contains(E target) {
        return find(target) != null;
	}
	
	
	/**
	 * This method calls the recursive add method and whether the node was added or not
	 * @param item: the data of the node to be added
	 * @post The node is added correctly, or it already exists and is not added
	 * @return whether the node was added
	 */
	public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    /**
     * Recursive add method.
     *
     * @post The data field addReturn is set true if the item is added to the
     * tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the inserted item
     */
    private Node<E> add(Node<E> localRoot, E item) {
    	Node<E> returnNode = localRoot;
      
            // item is not in the tree insert it.return a new node
    	if(localRoot == null) { 
        	returnNode = new Node<E>(item);
        	addReturn = true;
    	} 
            // item is equal to localRoot.data
    	else if(item.compareTo(localRoot.data) == 0) { 
    		addReturn = false;
    	}
    		//item is greater than localRoot.data
    	else if(item.compareTo(localRoot.data) > 0) { 
    		returnNode.right = add(localRoot.right, item);
    		
    	}
    		//item is less than localRoot.data
    	else {
    		returnNode.left = add(localRoot.left, item);
    	}
          
        return returnNode;    	
    }
    
    /**
	 * This method prints the BinaryTree in alphabetical order. 
	 * @post prints the inorder traversal using a StringBuilder. The String Builder output calls the toString method in the IndexTree class, which prints
	 * the data in the proper format, and in alphabetical order.
	 */
   	
	public void printOrderedData() {
		StringBuilder stb = new StringBuilder();
		inorderTraversal(stb, root);
		String output = stb.toString();
		System.out.println(output);
		
	}
	
	/**Helper method, recursive inorderTraversal method that is called by printOrderedData() */
	private void inorderTraversal(StringBuilder stb, Node<E> root) {
		if(root != null) {
			inorderTraversal(stb, root.left); //Print left subTree
			stb.append(root.data); //Print Root
			stb.append("\n"); //adds the new line identifier so the output is 1 word per line.
			inorderTraversal(stb, root.right); //Print right subTree
		}
	}
}
