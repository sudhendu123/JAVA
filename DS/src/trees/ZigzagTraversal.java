

package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        boolean leftToRight = true;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                curr.add(tmp.data);
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.right != null)
                    q.offer(tmp.right);
            }else{
                if(leftToRight){
                    ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
        			res.add(c_curr);
    				curr.clear();
                }else{
                    Stack<Integer> s = new Stack<Integer>();
                    s.addAll(curr);
                    ArrayList<Integer> c_curr = new ArrayList<Integer>();
                    while(!s.isEmpty()){
                        c_curr.add(s.pop());
                    }
                    res.add(c_curr);
                    curr.clear();
                }
                if(!q.isEmpty()){
                    q.offer(null);
                    leftToRight = !leftToRight;
                }
            }
        }
        return res;
    }
}
