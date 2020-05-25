

package trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderIterative {
    public ArrayList<Integer> inorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode currentNode = root;
        boolean done = false;
        while(!done){
            if(currentNode != null){
                s.push(currentNode);
                currentNode = currentNode.getLeft();
            }else{
                if(s.isEmpty())
                    done = true;
                else{
                	currentNode = s.pop();
                    res.add(currentNode.data);
                    currentNode = currentNode.right;
                }
            }
        }
        return res;
    }
}
