package edu.unl.raikes.BinarySearchTreeLab;

import java.util.ArrayList;
import java.util.List;

/**
 * class for tree object
 * @author evmelchior
 *
 */
public class BinarySearchTree {
	boolean verbose = true;
	private BinarySearchNode root = null;
	private int size = 0;

	/**
	 * inserts person object into tree
	 * @param data	object to insert
	 */
	public void insert(Person data) {
		boolean inserted = false;
		// if root is null, set data in root
		if (root == null) {
			root = new BinarySearchNode(data);
			inserted = true;
		} // else recurse 
		else {
			inserted = root.insert(data);
		} // add to size if you inserted
		if (inserted) {
			size++;
		}
	}

	/**
	 * searches for node with int key value
	 * @param key	int to search for
	 * @return node if found
	 */
	public Person search(int key) {
		// if root is null, return nothing
		if (root == null) {
			return null;
		}
		// set found node to result of search function
		BinarySearchNode found = root.search(key);
		// if found is present
		if (found != null) {
			return found.person;
		} else {
			return null;
		}

	}

	/**
	 * delete node with int key value
	 * @param key	int to search and delete
	 * @return node deleted if found, otherwise nothing
	 */
	public Person delete(int key) {
		Person deleted = null;

		// if root is null, return nothing
		if (root == null) {
			return null;
		} // else, continue search
		else {
			// if root key is same as key passed in
			if (root.person.key == key) {
				// add fake root in case the element to be removed is the root.
				// (simplifies pointer logic)
				BinarySearchNode auxRoot = new BinarySearchNode(null);
				auxRoot.setLeftChild(root);
				// set deleted to node deleted
				deleted = root.delete(key);
				// retrieve the root from the fake root (in case it changed)
				root = auxRoot.leftChild;
				// is root if present, set parent null
				if (root != null)
					root.parent = null;
			} // if key is not same, delete root
			else {
				deleted = root.delete(key);
			} // if deleted is present (deleted something), subtract from size
			if (deleted != null)
				size--;
			return deleted;
		}
	}

	/**
	 * toString method that prints tree size and root
	 */
	public String toString() {
		String toReturn = "Binary Search Tree of Size: " + size + "\n";
		// if root is present, print
		if (root != null) {
			toReturn += root.toString();
		}
		return toReturn;
	}
	
//	public List<BinarySearchNode> inOrderTraversal() {
//		ArrayList<BinarySearchNode> traversalList = new ArrayList<BinarySearchNode>();
//		
//		inOrderTraversal(this.root);
//		
//		return traversalList;
//	}
//	
//	private void inOrderTraversal(BinarySearchNode node) {
//		if (node == null) {
//			return;
//		}
//		inOrderTraversal(node.leftChild);
//		
//	}

}
