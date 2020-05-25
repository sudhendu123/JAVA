

package trees;

public class CheckAVL {
    public boolean isAVL(BinarySearchTreeNode root, int min, int max) {
        if(root == null)
            return true;
        return root.data > min && root.data < max && isAVL(root.left, min, root.data) && isAVL(root.right, root.data, max) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }
    public int getHeight(BinarySearchTreeNode root){
        int leftHeight, rightHeight;
        if(root == null)
            return 0;
        else{
            leftHeight = getHeight(root.left);
            rightHeight = getHeight(root.right);
            if(leftHeight > rightHeight)
                return leftHeight + 1;
            else
                return rightHeight + 1;
        }
    }
    
    public boolean isAVL(BinarySearchTreeNode root){
        return isAVL(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
