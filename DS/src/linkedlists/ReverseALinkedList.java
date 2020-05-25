

package linkedlists;
public class ReverseALinkedList{
    public static void reverseLinkedListRecursive(ListNode current, ListNode[] head){
        if (current == null) {
            return;
        }
        //base case
        ListNode next = current.getNext();
        if (next == null) {
            head[0] = current;
            return;
        }
        reverseLinkedListRecursive(next, head);
        //Make next node points to current node
        next.setNext(current);
        //Remove existing link
        current.setNext(null);
    }

    public static ListNode reverseListIterative(ListNode head){
        //initially Current is head
        ListNode current = head;
        //initially previous is null
        ListNode prev = null;
        while (current != null) {
            //Save the next node
            ListNode next = current.getNext();
            //Make current node points to the previous
            current.setNext(prev);
            //update previous
            prev = current;
            //update current
            current = next;
        }
        return prev;
    }
}
