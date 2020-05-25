


package trees;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInBinaryTreeLevelOrder {
    public BinaryTreeNode insertInBinaryTreeLevelOrder(BinaryTreeNode root, int data){
    	if(root == null)
            return null;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                else{
                	tmp.left = new BinaryTreeNode(data);
                	return root;
                }
                if(tmp.right != null)
                    q.offer(tmp.right);
                else{
                	tmp.right = new BinaryTreeNode(data);
                	return root;
                }
            }
        }
		return root;
    }
}
