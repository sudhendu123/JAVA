

package trees;

public class TreeFromInOrderAndPostOrder {
    public BinaryTreeNode buildBinaryTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || postorder.length != inorder.length)
            return null;
        return buildBT(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public BinaryTreeNode buildBT(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd){
        if(postStart > postEnd || inStart > inEnd)
            return null;
        int val = postOrder[postEnd];
        int offset = inStart;
        BinaryTreeNode cur = new BinaryTreeNode(val);
        // search for the inorder index
        for(; offset < inEnd; offset++){
            if(inOrder[offset] == val)
                break;
        }
        cur.setLeft(buildBT(postOrder, postStart, postStart + offset - inStart - 1, inOrder, inStart, offset - 1));
        cur.right = buildBT(postOrder, postStart + offset - inStart, postEnd - 1, inOrder, offset + 1, inEnd);
        return cur;
    }
}
