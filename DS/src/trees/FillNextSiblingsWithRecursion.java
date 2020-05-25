


package trees;

public class FillNextSiblingsWithRecursion {
	public static void fillNextSiblings(SiblingBinaryTreeNode root) {
		if (root == null) 
			return;
		if (root.getLeft() != null)
			root.getLeft().setNextSibling(root.getRight());
		if (root.getRight() != null)
			if(root.getNextSibling() != null)
				root.getRight().setNextSibling(root.getNextSibling().getLeft());
			else	root.getRight().setNextSibling(null);
		fillNextSiblings(root.getLeft());
		fillNextSiblings(root.getRight());
	}
}
