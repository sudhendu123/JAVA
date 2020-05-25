


package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindLevelwithMaxSum {
	public int findLevelwithMaxSum(BinaryTreeNode root) {
		int maxSum = 0, currentSum = 0;
		if (root == null)
			return 0;
		// Initialization
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				currentSum += tmp.getData();
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				if (currentSum > maxSum){
					maxSum =  currentSum;
				}
				currentSum = 0;
				// completion of a level;
				if (!q.isEmpty())
					q.offer(null);
			}
		}
		return maxSum;
	}
}
