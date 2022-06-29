package whiteboard;

class ReverseLinkedList {
    // O(n) time | O(1) space
    // #2: 14/06/2022
    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.
        LinkedList prev = null;
        LinkedList curr = head;

        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
