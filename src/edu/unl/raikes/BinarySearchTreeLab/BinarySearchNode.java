package edu.unl.raikes.BinarySearchTreeLab;

// TODO: ADD JAVADOC COMMENT 
class BinarySearchNode {
	protected BinarySearchNode parent;
	protected BinarySearchNode leftChild;
	protected BinarySearchNode rightChild;
	protected Person person;

	/**
	 * constructor with person parameter
	 * @param person	person object passed in
	 */
	BinarySearchNode(Person person) {
		this.person = person;
	}

	/**
	 * inserts person into tree
	 * @param data	person to add in
	 * @return	boolean corresponding to whether or not it was added
	 */
	boolean insert(Person data) {
		// if data is parameter, do not insert
		if (data == this.person) {
			return false;
		}
		// is person is greater than data value
		else if (Integer.compare(data.key, person.key) < 0) {
			// if there is no left child, add in left child slot
			if (leftChild == null) {
				setLeftChild(new BinarySearchNode(data));
				return true;
			} // else recurse on left child
			else {
				return leftChild.insert(data);
			}
		}
		// if person is less than data value
		else if (Integer.compare(data.key, person.key) > 0) {
			// is there is no right child, add in right  child slot
			if (rightChild == null) {
				setRightChild(new BinarySearchNode(data));
				return true;
			} // else recurse on right child
			else {
				return rightChild.insert(data);
			}
		}
		return false;
	}

	/**
	 * searches for int in tree
	 * @param key	int to search for
	 * @return person where key is present
	 */
	BinarySearchNode search(int key) {
		// is left is present and key is not same as left child, recurse on left child
		if (leftChild != null && Integer.compare(key, person.key) < 0) {
			return leftChild.search(key);
		}
		// same but right child
		else if (rightChild != null && Integer.compare(key, person.key) > 0) {
			return rightChild.search(key);
		}
		// if key is same as current spot being checked
		else if (this.person.key == key) {
			return this;
		}
		// else did not find
		else {
			return null;
		}
	}

	/**
	 * deletes node with key int value
	 * @param key	int value to look for
	 * @return deleted node
	 */
	Person delete(int key) {
		// sets node to search through
		BinarySearchNode node = search(key);
		if (node == null)
			return null;
		Person deleted = node.person;

		// if both children are null, set one to new parent
		if (node.leftChild == null && node.rightChild == null) {
			if (node.parent.leftChild == node)
				node.parent.setLeftChild(null);
			else if (node.parent.rightChild == node)
				node.parent.setRightChild(null);
		}
		// if two children are present, delete min node
		else if (node.leftChild != null && node.rightChild != null) {
			BinarySearchNode min = node.rightChild.getNodeWithMinValue();
			node.person = min.person;
			int minKey = min.person.key;
			min.delete(minKey);
		}
		// if left child is one searching for, set new node on left child
		else if (node.parent.leftChild == node) {
			BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
			node.parent.setLeftChild(newLeftChild);
		}
		// if right child is one searching for, set new node on right child
		else if (node.parent.rightChild == node) {
			BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
			node.parent.setRightChild(newRightChild);
		}

		return deleted;
	}

	/**
	 * gets node with min value 
	 * @return node with min value
	 */
	BinarySearchNode getNodeWithMinValue() {
		if (leftChild == null)
			return this;
		else
			return leftChild.getNodeWithMinValue();
	}

	/**
	 * sets left child of parent
	 * @param child		object to set as left child
	 */
	void setLeftChild(BinarySearchNode child) {
		this.leftChild = child;
		if (child != null)
			child.parent = this;
	}

	/**
	 * sets right child of parent
	 * @param child		object to set as right child
	 */
	void setRightChild(BinarySearchNode child) {
		this.rightChild = child;
		if (child != null)
			child.parent = this;
	}

	// TODO: ADD JAVADOC COMMENT (WHAT KIND OF SEARCH SHOULD THIS BE???)
	public String toString(BinarySearchNode root) {
		// TODO: ADD COMMENT
		toString(root.leftChild);
		System.out.print("  " + person.toString() + "\n");
		toString(root.rightChild);
		return "";
	}

}