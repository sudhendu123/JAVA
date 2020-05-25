

package linkedlists;

public class PartitionList {
    public ListNode partition(ListNode head, int K) {
        ListNode root = new ListNode(0);
        ListNode pivot = new ListNode(K);
        ListNode rootNext = root, pivotNext = pivot;
        ListNode currentNode = head;
        while(currentNode != null){
            ListNode next = currentNode.next;
            if(currentNode.data >= K){
                pivotNext.next = currentNode;
                pivotNext = currentNode;
                pivotNext.next = null;
            }else{
                rootNext.next = currentNode;
                rootNext = currentNode;
            }
            currentNode = next;
        }
        rootNext.next = pivot.next;
        return root.next;
    }
}
