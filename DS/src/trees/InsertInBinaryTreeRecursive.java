


package trees;


public class InsertInBinaryTreeRecursive {
	public void insert(BinaryTreeNode root, int data) {
		if (root == null) {
			root = new BinaryTreeNode(data);
		} else {
			insertHelper(root, data);
		}
	}

	private void insertHelper(BinaryTreeNode root, int data) {
		if (root.data >= data) {	// It is not compulsory to put this check.
			if (root.left == null) {
				root.left = new BinaryTreeNode(data);
			} else {
				insertHelper(root.right, data);
			}
		} else {
			if (root.right == null) {
				root.right = new BinaryTreeNode(data);
			} else {
				insertHelper(root.right, data);
			}
		}
	}
}
