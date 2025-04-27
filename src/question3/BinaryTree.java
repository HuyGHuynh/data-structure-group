package question3;

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

        // Constructors  ------------------------------------------------------ Missing code 1
        /**
         * Construct a node with given data and no children.
         * @param data The data to store in this node
         */
        public Node(E data) {
        	this.data = data;
        	this.left = null;
        	this.right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         * @return A string representation of the data fields
         */
        @Override
        public String toString() {
            return data.toString();
        }
    }
    /*</listing>*/
    // Data Field
    /** The root of the binary tree */
    protected Node<E> root;

    /** Construct an empty BinaryTree */
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
     * Constructs a new binary tree with data in its root,leftTree ------------------------------------------------------ Missing code 2
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
    	root = new Node<E>(data);
    	if(leftTree != null) {
    		root.left = leftTree.root;
    	} else {
    		root.left = null;
    	}
	
    	if(rightTree != null) {
    		root.right = rightTree.root;
    	} else {
    		root.right = null;
    	}
    }

    /**
     * Return the left subtree. ------------------------------------------------------ Missing code 3
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {	
    	if(root != null && root.left != null) {
    		return new BinaryTree<E>(root.left);
    	} else {
    		return null;
    	}
    }

    /**
     * Return the right sub-tree ------------------------------------------------------ Missing code 4
     * @return the right sub-tree or
     *         null if either the root or the
     *         right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
    	if(root != null && root.right != null) {
    		return new BinaryTree<E>(root.right);
    	} else {
    		return null;
    	}	
    }

    /**
     * Return the data field of the root
     * @return the data field of the root
     *         or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf. ------------------------------------------------------ Missing code 5
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inorderToString(sb, root);
        return sb.toString();
    }


    private void inorderToString(StringBuilder stb, Node<E> root) {
    	if(root == null) {
    		return;
    	}
    	inorderToString(stb, root.left);
    	stb.append(root.data);
    	stb.append("\n");
    	inorderToString(stb, root.right);

    }
}
