

package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthInBinaryTreeWithLevelOrder {
	// Returns the depth of this binary tree. The depth of a binary tree is the
	// length of the longest path from this node to a leaf. The depth of a
	// binary tree with no descendants (that is, just a leaf) is zero.
    public int maxDepthLevelOrder(BinaryTreeNode root){
    	if(root == null)
            return 0;
        int maxDepth = 1;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.right != null)
                    q.offer(tmp.right);
            }else{
                if(!q.isEmpty()){
                    ++maxDepth;
                    q.offer(null);
                }
            }
        }
        return maxDepth;
    }
}
