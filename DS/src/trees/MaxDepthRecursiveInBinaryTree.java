

package trees;
public class MaxDepthRecursiveInBinaryTree {
    public static int maxDepthRecursive(BinaryTreeNode root) {
        if(root == null) return 0;
        /* compute the depth of each subtree */
        int leftDepth = maxDepthRecursive(root.getLeft());
        int rightDepth = maxDepthRecursive(root.right);
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }  
}