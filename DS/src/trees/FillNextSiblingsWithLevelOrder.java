

package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FillNextSiblingsWithLevelOrder {
    public static void fillNextSiblings(SiblingBinaryTreeNode root) {
    	SiblingBinaryTreeNode tmp = null;
    	if (root == null)
			return;
		// Initialization
		Queue<SiblingBinaryTreeNode> q = new LinkedList<SiblingBinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			tmp = q.poll();
			if (tmp != null) {
				tmp.setNextSibling(q.peek());
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				// completion of a level;
				if (!q.isEmpty())
					q.offer(null);
			}
		}
    }
}
