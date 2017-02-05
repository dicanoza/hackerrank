package tree.binary;

public class Node {
	private int data;
	private Node left;
	private Node right;

	// constructor
	public Node(int data) {
		this.setData(data);
	}

	// tree methods
	public void insert(Node node) {
		if (node.getData() <= this.getData()) {
			this.setLeft(node);
		} else {
			this.setRight(node);
		}
	}

	// prints
	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.println(data);
		if (right != null) {
			right.printInOrder();
		}
	}

	public void printPreOrder() {
		System.out.println(data);
		if (left != null) {
			left.printPreOrder();
		}
		if (right != null) {
			right.printPreOrder();
		}
	}

	public void printPostOrder() {
		if (left != null) {
			left.printPostOrder();
		}
		if (right != null) {
			right.printPostOrder();
		}
		System.out.println(data);
	}

	// getters and setters
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
