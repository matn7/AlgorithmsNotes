package whiteboard;

public class ShiftLinkedList3 {

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.
        if (k == 0) {
            return head;
        }
        LinkedList curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        LinkedList tail = curr;
        k = k % length;
        if (k == 0) {
            return head;
        }
        if (k < 0) {
            k = length + k;
        }
        curr = head;
        int len = 1;
        while (len < length - k) {
            curr = curr.next;
            len++;
        }
        LinkedList newTail = curr;
        LinkedList newHead = curr.next;
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
