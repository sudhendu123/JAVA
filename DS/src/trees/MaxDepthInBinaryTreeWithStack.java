

package trees;
import java.util.Stack;
public class MaxDepthInBinaryTreeWithStack {
    // Returns the depth of this binary tree. The depth of a binary tree is the
    // length of the longest path from this node to a leaf. The depth of a
    // binary tree with no descendants (that is, just a leaf) is zero.
    public int maxDepthIterative(BinaryTreeNode root){
        if(root == null) return 0;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        int maxDepth = 0;
        BinaryTreeNode prev = null;
        while(!s.isEmpty()){
        	BinaryTreeNode curr = s.peek();
            if(prev == null || prev.getLeft() == curr || prev.right == curr){
                if(curr.getLeft() != null) s.push(curr.getLeft());
                else if(curr.right != null) s.push(curr.right);
            }else if(curr.getLeft() == prev){
                if(curr.right != null) s.push(curr.right);
            }else
                s.pop();
            prev = curr;
            if(s.size() > maxDepth)
                maxDepth = s.size();
        }
        return maxDepth;
    }
}
