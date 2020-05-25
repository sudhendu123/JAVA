


package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxInBinaryTreeLevelOrder {
    public int maxInBinaryTreeLevelOrder(BinaryTreeNode root){
    	if(root == null)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
        	if (tmp.getData() > max){
        		max = tmp.getData();
        	}
            if(tmp != null){
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.right != null)
                    q.offer(tmp.right);
            }
        }
        return max;
    }
}
