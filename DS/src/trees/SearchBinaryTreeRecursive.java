


package trees;

public class SearchBinaryTreeRecursive {
	// Tests whether the root argument contains within itself the data argument.
	public static boolean findInBT(BinaryTreeNode root, int  data) {
		if (root == null)
		    return false;
		if (root.getData() == data)
		    return true;
		return findInBT(root.getLeft(), data)  || findInBT(root.getRight(), data);
	}
}
