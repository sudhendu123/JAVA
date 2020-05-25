


package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalInReverse {
	public static void levelOrderTraversalInReverse(BinaryTreeNode root) {
        if(root == null) 
        	return;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
            s.push(tmp);
        }
        while(!s.isEmpty())
    		System.out.println(s.pop().getData()+ " ");
	}
}
