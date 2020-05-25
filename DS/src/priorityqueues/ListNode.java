
package priorityqueues;
class ListNode {
	int data;
	ListNode next;
 
	ListNode(int x) {
		data = x;
		next = null;
	}
	public int getData(){
		return this.data;
	}
	public void setData(int data){
		this.data = data;
	}
	public ListNode getNext(){
		return this.next;
	}
	public void setNext(ListNode node){
		this.next = node;
	}
}