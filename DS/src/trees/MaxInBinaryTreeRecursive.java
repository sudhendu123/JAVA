package trees;



public class MaxInBinaryTreeRecursive {
	public int maxInBinaryTree(BinaryTreeNode root){
	    int maxValue = Integer.MIN_VALUE;
	    if (root != null){
	        int leftMax = maxInBinaryTree(root.getLeft());
	        int rightMax = maxInBinaryTree(root.right);
	         
	        if (leftMax > rightMax)
	        	maxValue = leftMax;
	        else
	        	maxValue = rightMax;
	             
	        if (root.data > maxValue)
	        	maxValue = root.data;
	    }
	    return maxValue;
	}
}
