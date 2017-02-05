package tree.binary;

public class BinaryTreeUtils {
	/**
	 * Checks if the tree is balanced
	 * 
	 * @param node
	 * @return
	 */
	public static boolean checkBST(Node node) {
		return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.getData() <= min || node.getData() >= max) {
			return false;
		}
		// any node from the left cant have higher value than the root
		// any node from right cant have lower value than root
		return checkBST(node.getLeft(), min, node.getData()) && checkBST(node.getRight(), node.getData(), max);

	}

}
