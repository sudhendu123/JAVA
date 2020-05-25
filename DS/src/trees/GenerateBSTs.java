

package trees;

import java.util.ArrayList;

public class GenerateBSTs {
    public ArrayList<BinarySearchTreeNode> generateTrees(int n) {
        if(n == 0) return generateTrees(1, 0);
        return generateTrees(1, n);
        
    }
    public ArrayList<BinarySearchTreeNode> generateTrees(int start, int end) {
        ArrayList<BinarySearchTreeNode> subTrees = new ArrayList<BinarySearchTreeNode>();
        if(start > end){
            subTrees.add(null);
            return subTrees;
        }          
        for(int i = start; i <= end; i++){
            for(BinarySearchTreeNode left : generateTrees(start, i - 1)){
                for(BinarySearchTreeNode right : generateTrees(i + 1, end)){
                	BinarySearchTreeNode aTree = new BinarySearchTreeNode(i);
                    aTree.left = left;
                    aTree.right = right;
                    subTrees.add(aTree);
                }
            }
        }
        return subTrees;
    } 
}
