/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BT<T> {

	int size;
	BTNode<T> root = null;

	BT() {
		root = null;
		size = 0;
	}

	BT(T data) {
		this(new BTNode<T>(data));
	}

	BT(BTNode<T> root) {
		this.root = root;
		size = 1;
	}

	BT(BTNode<T> root, BT<T> Lsubtree, BT<T> Rsubtree) {
		this.root = root;
		root.left = Lsubtree.root;
		root.right = Rsubtree.root;
		size = Lsubtree.size + Rsubtree.size + 1;
	}

	int findHeight() {
		return findHeight(root);
	}

	int findHeight(BTNode<T> root) {
		// Exercise 1 ////////////////
		if (root == null) {
			return 0;
		} else if (isLeaf(root)) {
			return 1;
		} else {
			return 1 + Math.max(findHeight(root.left), findHeight(root.right));
		}
	}

	boolean isLeaf(BTNode<T> root) {
            return root != null && root.left == null && root.right == null;
	}

	boolean isBalanced() {
		return isBalanced(root);
	}

	boolean isBalanced(BTNode<T> root) {
		if (root == null) {
			return true;
		}
		int LH = findHeight(root.left);
		int RH = findHeight(root.right);
		int B = Math.abs(LH - RH);

		if (B <= 1) {
			return (isBalanced(root.left) && isBalanced(root.right));
		} else {
			return false;
		}
	}

	/* Inorder traversal from the root */
	public void inorder() {
		inorder(root);
	}

	/* Inorder traversal from a subtree */
	protected void inorder(BTNode<T> root) {
		// Exercise 2 (a) Complete this method
		if (root != null) {
			if (isLeaf(root)) {
				System.out.print(root.element + " ");
			} else {
				inorder(root.left);
				System.out.print(root.element + " ");
				inorder(root.right);
			}
		}
	}

	/* Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	/* Postorder traversal from a subtree */
	protected void postorder(BTNode<T> root) {
		// Exercise 2 (b) Complete this method
		if (root != null) {
			if (isLeaf(root)) {
				System.out.print(root.element + " ");
			} else {
				postorder(root.left);
				postorder(root.right);
				System.out.print(root.element + " ");
			}
		}
	}

	/* Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	/* Preorder traversal from a subtree */
	protected void preorder(BTNode<T> root) {
		if (root != null) {
			if (isLeaf(root)) {
				System.out.print(root.element + " ");
			} else {
				System.out.print(root.element + " ");
				preorder(root.left);
				preorder(root.right);
			}
		}
	}

	void PrintDFT() {
		// Exercise 3 ////////////////
		Stack<BTNode<T>> S = new Stack<BTNode<T>>();
		S.push(root);
		while(!S.isEmpty()) {
			BTNode<T> tmp = S.pop();
			if (tmp.right != null) {
				S.push(tmp.right);
			}
			if (tmp.left != null) {
				S.push(tmp.left);
			}
			System.out.print(tmp.element + " ");
		}
	}

	void PrintBFT() {
		// Exercise 4 ////////////////
		Queue<BTNode<T>> Q = new Queue<BTNode<T>>();
		Q.enqueue(root);
		while(!Q.isEmpty()) {
			BTNode<T> tmp = Q.dequeue();
			if (tmp.left != null) {
				Q.enqueue(tmp.left);
			}
			if (tmp.right != null) {
				Q.enqueue(tmp.right);
			}
			System.out.print(tmp.element + " ");
		}
	}

	static boolean hasHigherPriority(String sign1, String sign2) {
		if (sign2.equals("("))
			return true;
		else if (sign1.equals("*") && sign2.equals("+"))
			return true;
		else if (sign1.equals("*") && sign2.equals("-"))
			return true;
		else if (sign1.equals("/") && sign2.equals("+"))
			return true;
		else if (sign1.equals("/") && sign2.equals("-"))
			return true;
		else if (sign1.equals("%") && sign2.equals("+"))
			return true;
		else if (sign1.equals("%") && sign2.equals("-"))
			return true;
		else
			return false;

	}

	// Exercise 5 ///////////////////////////////////////////////
	public static boolean isOperator(String item) {
		if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/") || item.equals("%"))
			return true;
		else
			return false;
	}

	public static BT<String> makeExpressionTree(String[] infixArr) {
		Stack<BT<String>> BTStack = new Stack<BT<String>>();
		Stack<BTNode<String>> parent = new Stack<BTNode<String>>(); // for keeping parent nodes
		String item;
		int i = 0;
		while (i != infixArr.length) {
			item = infixArr[i]; // read item from array

			// Case 1: if item it is an open parenthesis
			if (item.equals("(")) {
				parent.push(new BTNode<String>(item));

			// Case 2: item is an operator
			} else if (isOperator(item)) {
				BTNode<String> temp = new BTNode<String>(item);
				if (parent.isEmpty()) { // stack is empty
					parent.push(new BTNode<String>(item));
				} else { // stack is not empty

					if (hasHigherPriority(item, parent.peek().element)) {
						parent.push(new BTNode<String>(item));

					} else {
						do {
							BTNode<String> operator = parent.pop();
							BT<String> rightSubTree = BTStack.pop();
							BT<String> leftSubTree = BTStack.pop();

							BT<String> newBT = new BT<String>(operator, leftSubTree, rightSubTree);
							BTStack.push(newBT);

						} while (!parent.isEmpty() && !hasHigherPriority(item, parent.peek().element));
						parent.push(temp);
					}
				}
			}

			// Case3: if item is a close parenthesis
			else if (item.equals(")")) {
				while (!parent.peek().element.equals("(")) {
					BTNode<String> root = parent.pop();
					BT<String> Rsubtree = BTStack.pop();
					BT<String> Lsubtree = BTStack.pop();
					BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
					BTStack.push(newBT);
				}
				parent.pop();

			// Case 4: it is not an operator
			} else {
				BT<String> newTree = new BT<String>(item);
				BTStack.push(newTree);
			}

			i++;
		}
		
		while (!parent.isEmpty()) {
			BTNode<String> root = parent.pop();
			BT<String> Rsubtree = BTStack.pop();
			BT<String> Lsubtree = BTStack.pop();
			BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
			BTStack.push(newBT);
		}
		return BTStack.pop();
	}
}
