package hard;

public class ShiftLinkedList {

    public static void main(String[] args) {

        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);

        shiftLinkedList(head, 2);
    }

    // O(n) time | O(1) space
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.
        if (k == 0) {
            return head;
        }
        // if k < 0
        LinkedList listTail = head;
        int listLength = 1;
        while (listTail.next != null) {
            listTail = listTail.next;
            listLength++;
        }

        int offset = Math.abs(k) % listLength;
        if (offset == 0) {
            return head;
        }

        int newTailPosition = 0;
        if (k > 0) {
            newTailPosition = listLength - offset;
        } else {
            newTailPosition = offset;
        }

        LinkedList newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        LinkedList newHead = newTail.next;
        newTail.next = null;

        listTail.next = head;

        return newHead;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

}
