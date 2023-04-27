package whiteboard;

class ReverseLinkedList {
    // O(n) time | O(1) space
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

    // O(n) time | O(n) space
    public static LinkedList reverseLinkedList2(LinkedList head) {
        return reverseLinkedListRec(head, null);
    }

    private static LinkedList reverseLinkedListRec(LinkedList curr, LinkedList prev) {
        if (curr == null) {
            return prev;
        }
        LinkedList next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

        return reverseLinkedListRec(curr, prev);
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
