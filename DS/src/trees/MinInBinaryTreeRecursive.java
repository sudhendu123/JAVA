


package trees;

public class MinInBinaryTreeRecursive {
	public int minInBinaryTree(BinaryTreeNode root){
	    int minValue = Integer.MAX_VALUE;
	    if (root != null){
	        int leftMin = minInBinaryTree(root.getLeft());
	        int rightMin = minInBinaryTree(root.right);
	         
	        if (leftMin > rightMin)
	        	minValue = leftMin;
	        else
	        	minValue = rightMin;
	             
	        if (root.data < minValue)
	        	minValue = root.data;
	    }
	    return minValue;
	}
}
