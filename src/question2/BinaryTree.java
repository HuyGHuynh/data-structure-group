package question2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Class for a binary tree that stores type E objects.
 **/
public class BinaryTree<E> {

    /** Class to encapsulate a tree node. */
    protected static class Node<E>{
        // Data Fields

        /** The information stored in this node. */
        public E data;
        /** Reference to the left child. */
        public Node<E> left;
        /** Reference to the right child. */
        public Node<E> right;

        /** Node Class Constructor */
        public Node(E data) {
        	
        	this.data = data;
        	this.left = null;
        	this.right = null;

        }

        /**
    	 * This method calls the toString method with the associated data type in data
     	 * @return toString of data type
    	 */
        @Override
        public String toString() {
            return data.toString();
        }
    }
   
    // The root of the binary tree
    protected Node<E> root;

    //Constructor
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a BinaryTree with a specified root.
     * Should only be used by subclasses.
     * @param root The node that is the root of the tree.
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree 
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
    
    	this.root = new Node<E>(data);
    	if(leftTree != null) {
    		this.root.left = leftTree.root;
    	}
    	if(rightTree != null) {
    		this.root.right = rightTree.root;
    	}
    }

    /**
	 * This method returns the left sub tree of the binary tree
	 * @return the leftSubTree of root given the root or root.left is not null
	 */    public BinaryTree<E> getLeftSubtree() {
    	
    	BinaryTree<E> leftSubTree = new BinaryTree<E>(root.left);

    	if(root == null || root.left == null) {
    		leftSubTree = null;
    	}
    	
    	return leftSubTree;
	
    }

	 /**
		 * This returns the right sub tree of the binary tree
		 * @return the rightSubTree of root given the root or root.right is not null
		 */
	 
    public BinaryTree<E> getRightSubtree() {
    	
    	BinaryTree<E> rightSubTree = new BinaryTree<E>(root.right);
    	
    	if(root == null || root.right == null) {
    		rightSubTree = null;
    	}
    	
    	return rightSubTree;
    }

    /**
	 * This method returns the data field of the targeted node
	 * @post either the word is added to the tree if it is not in the tree, or if it is in the tree then an occurrence is added.
	 * @return the data of the root/targeted node
	 */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
	 * This method checks if a node is a leaf or not (has no children)
	 * @return whether or not the node is a leaf or not
	 */
    public boolean isLeaf() {
    	boolean isLeaf = false;
        if((root.right == null) & (root.left == null)) {
        	isLeaf = true;
        }
        
        return isLeaf;
    }

    @Override
    /**
	 * This method calls preOrderTraverse and uses a StringBuilder to build a string of the BinaryTree's preorder traversal
	 * @return return BinaryTree's preorder traversal as a string
	 */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    
    /**
     * Method to read a binary tree.
     * @pre The input consists of a preorder traversal
     *      of the binary tree. The line "null" indicates a null tree.
     * @param bR The input file
     * @return The binary tree
     * @throws IOException If there is an input error
     */
    public static BinaryTree<String> readBinaryTree(BufferedReader bR)
            throws IOException {
        // Read a line and trim leading and trailing spaces.
        String data = bR.readLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(bR);
            BinaryTree<String> rightTree = readBinaryTree(bR);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }

    /**
     * Method to return the preorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     * @return A preorder traversal as a string
     */
    public String preorderToString() {
        StringBuilder stb = new StringBuilder();
        preorderToString(stb, root);
        return stb.toString();
    }

    /**
     * Helper Method
     * Recursive preOrder traversal method
     * Builds a StringBuilder to hold the preOrder traversal of a Binary Tree
     *   */;
    private void preorderToString(StringBuilder stb, Node<E> root) {
    	
    	if (root != null) {
    		stb.append(root.data);
    		stb.append(" ");
    		preorderToString(stb, root.left);
    		preorderToString(stb, root.right);
    	}
    }
   

    /**
     * Method to return the postorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     * @return A postorder traversal as a string
     */
    public String postorderToString() {
        StringBuilder stb = new StringBuilder();
        postorderToString(stb, root);
        return stb.toString();
    }
    
    /**
     * Helper Method 
     * Recursive postOrder traversal method
     * Builds a StringBuilder to hold the postOrder traversal of a Binary Tree
     * */
    private void postorderToString(StringBuilder stb, Node<E> root) {
	
    	if (root != null) {
    		postorderToString(stb, root.left);
    		postorderToString(stb, root.right);
    		stb.append(root.data);
    		stb.append(" ");
		}
    }

    /** 
     * A method to display the inorder traversal of a binary tree 
     * placing a left parenthesis before each subtree and a right 
     * parenthesis after each subtree. 
     * @return An inorder string representation of the tree
     */
    public String inorderToString() {
        StringBuilder stb = new StringBuilder();
        inorderToString(stb, root);
        return stb.toString();
    }

/**
 * Helper Method
 *  Recursive inOrder traversal method
 *  Builds a StringBuilder to hold the inOrder traversal of a Binary Tree
 *  */

    private void inorderToString(StringBuilder stb, Node<E> root) {
    	    	if(root != null) {
    		stb.append("(");
    		inorderToString(stb, root.left);
    		stb.append(root.data);
    		stb.append(" ");
    		inorderToString(stb, root.right);
    		stb.append(")");	
    	}
    }
      
}



