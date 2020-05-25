

package trees;

public class CheckValidBSTRecursive {
	public boolean checkValidBST(BinarySearchTreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBST(BinarySearchTreeNode root, int min, int max) {
		if (root == null)
			return true;
		return (root.data > min && root.data < max && isBST(root.left, min, root.data) && isBST(root.right, root.data, max));
	}
}
