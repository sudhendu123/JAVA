

package linkedlists;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null)
            return head;
        ListNode rotateStart = head, rotateEnd = head;
        while(n-- > 0){
            rotateEnd = rotateEnd.next;
            if(rotateEnd == null){
                rotateEnd = head;
            }
        }
        if(rotateStart == rotateEnd)
            return head;
        while(rotateEnd.next != null){
            rotateStart = rotateStart.next;
            rotateEnd = rotateEnd.next;
        }
        ListNode temp = rotateStart.next;
        rotateEnd.next = head;
        rotateStart.next = null;
        return temp;
    }
}