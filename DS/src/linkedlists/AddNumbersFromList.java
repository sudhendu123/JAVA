

package linkedlists;
public class AddNumbersFromList {
	public static void main(String[] args) {
		AddNumbersFromList addss=new AddNumbersFromList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode addTwoNo=addss.addTwoNumbers(l1, l2);
		ListNode addTwoNoRev=addTwoReversedNumbers(l3, l4);
		System.out.println("addTwoNo ="+addTwoNo);
		System.out.println("addTwoNoRev ="+addTwoNoRev);
		
	}
    // NOTE : the input parameters and output LL is reversed.
    public static ListNode addTwoReversedNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode sum = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.data;
                l2 = l2.next;
            }
            sum.next = new ListNode(carry % 10);
            sum = sum.next;
            carry /= 10;
        }
        sum.next = carry == 1 ? new ListNode(1) : null;
        return head.next;
    }
  
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int advance = 0;
        while(l1 != null && l2 != null){
            int sum = l1.data + l2.data + advance;
            advance = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            if(advance != 0)
                cur.next = addTwoNumbers(l1, new ListNode(advance));
            else
                cur.next = l1;
        }else if(l2 != null){
            if(advance != 0)
                cur.next = addTwoNumbers(l2, new ListNode(advance));
            else
                cur.next = l2;
        }else if(advance != 0){
            cur.next = new ListNode(advance);
        }
        return head.next;
    }
}
