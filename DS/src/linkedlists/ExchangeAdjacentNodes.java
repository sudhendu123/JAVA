

package linkedlists;

public class ExchangeAdjacentNodes {
    public ListNode exchangeAdjacentNodes(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp, curr = head;
        while(curr != null && curr.next != null){
            ListNode tmp = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = tmp;
            prev = curr;
            curr = prev.next;
        }
        return temp.next;
    }
}
