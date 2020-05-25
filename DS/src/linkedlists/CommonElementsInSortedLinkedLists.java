

package linkedlists;

public class CommonElementsInSortedLinkedLists {
	public static ListNode commonElement(ListNode list1, ListNode list2) {
		ListNode temp =  new ListNode(0);
		ListNode head = temp;
		while (list1 != null && list2 != null) {
			if (list1.data == list2.data) {
				head.next = new ListNode(list1.data); // Copy common element.
				list1 = list1.next;
				list2 = list2.next;
				head = head.next;
			} else if (list1.data > list2.data) {
				list2 = list2.next;	
			} else { // list1.data < list2.data
				list1 = list1.next;	
			}
		}
		return temp.next;	
	}
}
