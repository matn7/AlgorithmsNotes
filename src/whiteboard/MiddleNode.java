package whiteboard;

public class MiddleNode {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(n) time | O(1) space
    public LinkedList middleNode(LinkedList linkedList) {
        // Write your code here.
        if (linkedList == null) {
            return null;
        }
        LinkedList slow = linkedList;

        if (slow.next == null) {
            return slow;
        }
        LinkedList fast = linkedList.next;
        
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }

}
