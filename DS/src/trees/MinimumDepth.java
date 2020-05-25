

package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
    public int minDepth(BinaryTreeNode root) {
        if(root == null) return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        int count = 1;
        while(!q.isEmpty()){
            BinaryTreeNode currentNode = q.poll();
            if(currentNode != null){
                if(currentNode.getLeft() == null && currentNode.right == null){
                    return count;
                }
                if(currentNode.getLeft() != null){
                    q.offer(currentNode.getLeft());
                }
                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }   
            }else{
                if(!q.isEmpty()){
                    count++;
                    q.offer(null);
                }
            }
        }
        return count;
    }
}
