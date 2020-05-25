

package linkedlists;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	//Refer Priority Queues
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        //PriorityQueue is a sorted queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), (ListNode a, ListNode b) -> {
            if (a.getData() > b.getData()) {
                return 1;
            } else if (a.getData() == b.getData()) {
                return 0;
            } else {
                return -1;
            }
        });
        //add first node of each list to the queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (pq.size() > 0) {
            //poll() retrieves and removes the head of the queue - q.
            ListNode temp = pq.poll();
            p.next = temp;
            //keep adding next element of each list
            if (temp.next != null) {
                pq.add(temp.next);
            }
            p = p.next;
        }
        return head.next;
    }
}
