

package trees;

public class CheckValidBSTRecursiveSingleVariable {
	private int prev = Integer.MIN_VALUE;
	public boolean checkValidBST(BinarySearchTreeNode root) {
		//Reference<Integer> prev = new Reference<Integer>(Integer.MIN_VALUE);
		return isBST(root);
	}
	public boolean isBST(BinarySearchTreeNode root) {
		if (root == null)
			return true;
   		if(!isBST(root.left)) 
            return false;
   		if(root.data < prev) 
   			return false;
   		prev = root.data;
	   	return isBST(root.right);
	}
}
