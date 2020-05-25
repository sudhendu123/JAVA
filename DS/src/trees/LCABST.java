

package trees;

public class LCABST {
	public BinarySearchTreeNode LCA(BinarySearchTreeNode root, BinarySearchTreeNode a, BinarySearchTreeNode b) {
		if (root == null)
			return root;
		if (root == a || root == b)
			return root;
		if (Math.max(a.data, b.data) < root.data) // a.data < root.data && b.data < root.data
			return LCA(root.left, a, b);
		else if (Math.min(a.data, b.data) > root.data) // a.data > root.data && b.data > root.data
			return LCA(root.right, a, b);
		else
			return root;
	}
}
