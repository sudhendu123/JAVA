

package linkedlists;

public class MergeSortedListsIterative {
	public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        ListNode head = new ListNode(0);
        if(head1.data <= head2.data){
            head = head1;
            head.next = mergeTwoLists(head1.next, head2);
        }else{
            head = head2;
            head.next = mergeTwoLists(head2.next, head1);
        }
        return head;
    }
}
