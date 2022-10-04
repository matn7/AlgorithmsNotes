package whiteboard;

public class NodeSwap {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(n) time | O(n) space
    // rand: 24/09/2022
    public LinkedList nodeSwap(LinkedList head) {
        // Write your code here.
        LinkedList temp = new LinkedList(0);
        temp.next = head;
        LinkedList prev = temp;
        while (prev.next != null && prev.next.next != null) {
            LinkedList first = prev.next;
            LinkedList second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }
        return temp.next;
    }

}
