

package linkedlists;

import java.util.HashMap;
import java.util.Map;

public class RandomPointerLinkedList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode X = head, Y;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(X != null) {
            Y = new RandomListNode(X.data);
            Y.next = null;
            Y.random = null;
            map.put(X, Y);
            X = X.next;
        }
        X = head;
        while(X != null){
            Y = map.get(X);
            Y.next = map.get(X.next);
            Y.random = map.get(X.random);
            X = X.next;
        }
        return map.get(head);
    }
}