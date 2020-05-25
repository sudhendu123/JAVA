

package linkedlists;
public class SkipListsTest{ 
	public static void main(String [] args){
		SkipList<Integer, Integer> s = new SkipList<Integer, Integer>();
		s.add(1,100);
		System.out.println(s.get(1));
	}
}