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
			root = new BTNode<T>(newdata);
		} else {
			// Locate the parent node
			BTNode<T> parent = null;
			BTNode<T> current = root;
			// insert your code
			while (current != null) {
				parent = current;
				if (newdata.compareTo(current.element) <= 0) {
					current = current.left;
				} else {
					current = current.right;
				}
			}

			if (newdata.compareTo(parent.element) < 0) {
				parent.left = new BTNode<T>(newdata);
			} else {
				parent.right = new BTNode<T>(newdata);
			}
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
			parent = current;
			if (item.compareTo(current.element) < 0) {
				current = current.left;
				currentIsLeftChild = true;
			} else if (item.compareTo(current.element) > 0) {
				current = current.right;
				currentIsLeftChild = false;
			} else {
				break;
			}
		}

		// Case 0: item is not in the tree
		if (current == null) {
			return null;
		}

		T temp = current.element;
		// Case 1: current is the leave
		if (current.left == null && current.right == null) {
			// insert your code
			if (currentIsLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		// Case 2: If the deleted node has one child
		// Case 2.1: if its child node is on the right
		if ((current.left == null)) { // If only has one right child or no children.
			if (currentIsLeftChild) {
				if (parent == null) {
					root = current.right;
				} else {
					parent.left = current.right;
					current.right = null;
				}
			} else {
				if (parent == null) {
					root = current.right;
				} else {
					parent.right = current.right;
					current.right = null;
				}
			}
		}
		// Case 2.2: If its child node is on the left
		else if (current.right == null) { // Only one left child
			if (currentIsLeftChild) {
				if (parent == null) {
					root = current.left;
				} else {
					parent.left = current.left;
					current.left = null;
				}
			} else {
				if (parent == null) {
					root = current.left;
				} else {
					parent.right = current.left;
					current.left = null;
				}
			} 
		
		} else { // Case 3: Have both children
			BTNode<T> maxleft = current.left;
			BTNode<T> maxleftParent = current;
			while (maxleft.right != null) {
				maxleftParent = maxleft;
				maxleft = maxleft.right;
			}
			current.element = maxleft.element;

			// Case 3.1: if maxleft is a leaf
			if (maxleft.left == null && maxleft.right == null) {
				maxleftParent.right = null;

			// Case 3.2: if maxleft has a left child
			} else if (maxleft.left != null) {
				maxleftParent.right = maxleft.left;
				maxleft.left = null;

			// Case 3.3: if maxleft is left child of node to be deleted
			} else if (maxleftParent == current) {
				current.left = maxleft.left;
				maxleft.left = null;
			}
		}
		size--;
		return temp;
	}
	// ---------------------------------------------------------

	// Search for the data returns true if it finds the data or otherwise false
	public boolean search(T data) {
		// Ex 3: Complete this section.
		BTNode<T> current = root;
		while (current != null) {
			if (data.compareTo(current.element) < 0) {
				current = current.left;
			} else if (data.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				return true;
			}
		}
		return false;
	}

	// ---------------------------------------------------------

	BTNode<T> findSmallest() {
		return findSmallest(root);
	}

	// ----------------------------------------------
	BTNode<T> findSmallest(BTNode<T> start) {
		// Ex 4 a): Complete this section.
		BTNode<T> smallest = start;
		while (smallest.left != null) {
			smallest = smallest.left;
		}
		return smallest;
	}

	// ----------------------------------------------
	BTNode<T> findLargest() {
		return findLargest(root);
	}

	// ----------------------------------------------
	BTNode<T> findLargest(BTNode<T> start) {
		// Ex 4 b): Complete this section.
		BTNode<T> largest = start;
		while (largest.right != null) {
			largest = largest.right;
		}
		return largest;
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
			return closest; 
		}

		// Convert the target and node elements to Double for easier comparison
		Double targetVal = Double.valueOf(target.toString());
		Double nodeVal = Double.valueOf(node.element.toString());
		Double closestVal = Double.valueOf(closest.toString());

		// Update the closest value if the current node's value is closer to the target
		if (Math.abs(targetVal - nodeVal) < Math.abs(targetVal - closestVal)) {
			closest = node.element;
		}

		// Recursively search left or right subtree based on comparison
		// use x.compareTo(y) to check if target is more or lesser than node.element

		if (target.compareTo(node.element) < 0) {
			return findClosestValue(node.left, target, closest);
		} else if (target.compareTo(node.element) > 0) {
			return findClosestValue(node.right, target, closest); 
		} else {
			return node.element; 
		}
	}

}
