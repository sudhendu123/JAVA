


package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSizeLevelOrder {
	// Returns the total number of nodes in this binary tree (include the root in the count).
	public int size(BinaryTreeNode root) {
		int count = 0;
    	if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
        	count++;
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
        }
		return count;
	}
}
