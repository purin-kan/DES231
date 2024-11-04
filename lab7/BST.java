public class BST<T extends Comparable<T>> extends BT<T> {
	/** Create an empty binary tree */
	public BST() {

	}

	/** Create a binary tree from an object */
	public BST(T object) {
		root.element = object;
	}

	/** Create a binary tree from an array of objects */
	public BST(T[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	// ----------------------------------------------
	/**
	 * Insert newdata into the binary search tree
	 */
	public void insert(T newdata) {
		// Ex1: Complete this program
		if (root == null) {
			// Create a new root
		} else {
			// Locate the parent node
			BTNode<T> parent = null;
			BTNode<T> current = root;
			// insert your code
		}

		size++;
	}

	// ----------------------------------------------
	/**
	 * Delete data from the binary search tree
	 */
	// Ex2. Complete This Program
	public T delete(T item) {
		// Locate the node to be deleted and also locate its parent node
		BTNode<T> parent = null;
		BTNode<T> current = root;

		boolean currentIsLeftChild = true;

		while (current != null) {
			// insert your code
		}

		// Case 0: item is not in the tree
		if (current == null) {
			return null;
		}

		T temp = current.element;
		// Case 1: current is the leave

		if (current.left == null && current.right == null) {
			// insert your code
		}

		// Case 2: If the deleted node has one child
		// Case 2.1: if its child node is on the right
		if ((current.left == null)) { // If only has one right child or no children.
			if (currentIsLeftChild) {
				// insert your code
			} else {
				// insert your code
			}
		}
		// Case 2.2: If its child node is on the left
		else if ((current.right == null)) { // Only one left child
			if (currentIsLeftChild) {
				// insert your code
			} else {
				// insert your code
			}
		} else { // Case 3: Have both children
			BTNode<T> maxleft = current.left;
			BTNode<T> maxleftParent = current;
			while (maxleft.right != null) {
				maxleftParent = maxleft;
				maxleft = maxleft.right;
			}
			current.element = maxleft.element;
			if (maxleft.left == null && maxleft.right == null) { // Case 3.1 if maxleft is a leave, then ..
				//insert your code
			} 
			else if (maxleft.left != null) { // Case 3.2 if maxleft has a left child, then .
				//insert your code
			} 
			else if (maxleftParent == current) { // Case 3.3 if maxleft is leftchild of current, then ..
				//insert your code
			}
		}
		size--;
		return temp;
	}
	// ---------------------------------------------------------

	// Search for the data returns true if it finds the data or otherwise false
	public boolean search(T data) { 
		// Ex 3: Complete this section.
		
		//replace the following line with your code
		return false;
	}

	// ---------------------------------------------------------

	BTNode<T> findSmallest() {
		return findSmallest(root);
	}

	// ----------------------------------------------
	BTNode<T> findSmallest(BTNode<T> start) {
		// Ex 4 a): Complete this section.
		
		//replace the following line with your code
		return null;
	}

	// ----------------------------------------------
	BTNode<T> findLargest() {
		return findLargest(root);
	}

	// ----------------------------------------------
	BTNode<T> findLargest(BTNode<T> start) { 
		// Ex 4 b): Complete this section.
		
		//replace the following line with your code
		return null;
	}

	/** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public BTNode getRoot() {
		return root;
	}

	/** Returns a path from the root leading to the specified element */
	public java.util.ArrayList<BTNode<T>> path(T e) {
		java.util.ArrayList<BTNode<T>> list = new java.util.ArrayList<BTNode<T>>();
		BTNode<T> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array of nodes
	}

	 /** Exercise 5: Implement method to find the closest value in BST */
	public T findClosestValue(T target) {
		return findClosestValue(root, target, root.element);
	}

	private T findClosestValue(BTNode<T> node, T target, T closest) {
		if (node == null) {
			/*base case return value*/; 
		}

		// Convert the target and node elements to Double for easier comparison
		Double targetVal = Double.valueOf(target.toString());
		Double nodeVal = Double.valueOf(node.element.toString());
		Double closestVal = Double.valueOf(closest.toString());

		// Update the closest value if the current node's value is closer to the target
		if (/* complete the condition */) {
			/* update T closest with the current node's value*/;
		}

		// Recursively search left or right subtree based on comparison
		// use x.compareTo(y) to check if target is more or lesser than node.element

		if (/* condition to traverse left subtree*/) {
			return /* recursive call for left subtree */;
		} else if (/*condition to traverse right subtree*/) {
			return /* recursive call for right subtree */; 
		} else {
			return /* Exact match */; 
		}
	}

}