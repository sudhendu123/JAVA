

package trees;

public class LCABinaryTree {
	public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
		BinaryTreeNode left, right;
		if (root == null)
			return root;
		if (root == a || root == b)
			return root;
		left = LCA(root.getLeft(), a, b);
		right = LCA(root.right, a, b);
		if (left != null && right != null)
			return root;// nodes are each on a separate branch
		else
			return (left != null ? left : right);
		// either one node is on one branch,
		// or none was found in any of the branches		
	}
}
