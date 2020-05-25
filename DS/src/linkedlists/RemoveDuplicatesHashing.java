


package linkedlists;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesHashing {
    // using a temporary buffer O(n)
    public static void removeDuplicates(ListNode head) {
        Map<Integer, Boolean> mapper = new HashMap<Integer, Boolean>();
        ListNode curr = head;
        ListNode next;
        while (curr.getNext() != null) {
            next = curr.getNext();
            if(mapper.get(next.getData()) != null) {
                // already seen it, so delete
                curr.setNext(next.getNext());
            } else {
                mapper.put(next.getData(), true);
                curr = curr.getNext();
            }
        }
    }
}
