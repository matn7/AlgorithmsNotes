package whiteboard;

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
        LinkedList first = head;
        int length = 1;
        while (first.next != null) {
            first = first.next;
            length++;
        }
        LinkedList tail = first;
        first = head;
        // calculate k
        k = k % length;
        if (k == 0) {
            return head;
        }
        if (k < 0) {
            k = length + k;
        }
        int curr = 1;
        while (curr < length - k) {
            first = first.next;
            curr++;
        }
        LinkedList newTail = first;
        LinkedList newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
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
