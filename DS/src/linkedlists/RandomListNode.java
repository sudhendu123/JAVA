

package linkedlists;

public class RandomListNode {
	int data;
	RandomListNode next;
	RandomListNode random;
 
	RandomListNode(int x) {
		data = x;
		next = null;
	}
	public int getData(){
		return this.data;
	}
	public void setData(int data){
		this.data = data;
	}
	public RandomListNode getNext(){
		return this.next;
	}
	public void setNext(RandomListNode node){
		this.next = node;
	}
	public RandomListNode getRandom(){
		return this.random;
	}
	public void setRandom(RandomListNode node){
		this.next = node;
	}
}
