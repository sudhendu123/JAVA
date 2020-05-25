

package linkedlists;

public class LoopInALinkedList
{
	public static int findLengthOfTheLoop(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        int length = 0;
        if (loopExists) {
            do {
                slowPtr = slowPtr.getNext();
                length++;
            } while (slowPtr != fastPtr);
        }
        return length;
    }

    public static ListNode findBeginofLoop(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
            }
            return fastPtr;
        } else
            return null;
    }

    public static boolean findIfLoopExistsUsingFloyds(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr)
                return true;

        }
        return false;
    }

    public static boolean findIfLoopExistsUsingBrents(ListNode head){
        ListNode movingPtr = head;
        ListNode stationaryPtr = head;
        int stepsTaken = 0;
        int stepLimit = 2;
        while (movingPtr != null) {
            movingPtr = movingPtr.getNext();
            stepsTaken++;
            if (movingPtr == stationaryPtr)
                return true;
            if (stepsTaken == stepLimit) {
                stepLimit = 2 * stepLimit;
                stepsTaken = 0;
                stationaryPtr = movingPtr;
            }
        }
        return false;
    }
}
