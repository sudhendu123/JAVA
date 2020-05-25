package trees;

import java.util.LinkedList;
import java.util.Queue;


public class SumOfElementsInBinaryTreeLevelOrder {
	public int addBT(BinaryTreeNode  root) {
		int sum = 0;
    	if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
        	sum += tmp.data;
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
        }
		return sum;
	}
}
