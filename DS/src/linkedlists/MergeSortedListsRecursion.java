

package linkedlists;

public class MergeSortedListsRecursion {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                curr.next = head1;
                head1 = head1.next;
            }else{
                curr.next = head2;
                head2 = head2.next;
            }
        }
        if(head1 != null)
            curr.next = head1;
        else if(head2 != null)
            curr.next = head2;
        return head.next;
    }
}
