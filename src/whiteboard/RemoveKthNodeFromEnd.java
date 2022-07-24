package whiteboard;

public class RemoveKthNodeFromEnd {

    // O(n) time | O(1) space
    // #2: 29/06/2022
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList first = head;
        LinkedList second = head;

        while (second != null && k > 0) {
            second = second.next;
            k--;
        }

        if (second == null) {
            // means remove first element
            first.value = first.next.value;
            first.next = first.next.next;
            return;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
