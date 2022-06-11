package hard;

public class ShiftLinkedListREPEAT {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);

        shiftLinkedList(head, 2);
        System.out.println(Math.abs(2) % 6);
    }

    // 0 -> 1 -> 2 -> 3 -> 4 -> 5

    // O(n) time | O(1) space
    // OK - repeated 03/02/2022
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.
        int listLength = 1; // 6
        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        //                          t
        LinkedList listTail = head;
        while (listTail.next != null) {
            listTail = listTail.next;
            listLength++;
        }
        // |2| % 6 = 2
        int offset = Math.abs(k) % listLength;
        if (offset == 0) {
            return head;
        }

        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        //                n         t
        int newTailPosition;
        if (k > 0) {
            newTailPosition = listLength - offset; // 6 - 2 = 4
        } else {
            newTailPosition = offset;
        }
        LinkedList newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        //                n    h    t
        LinkedList newHead = newTail.next;
        //                  null
        //                 /
        // 0 -> 1 -> 2 -> 3    4 -> 5 -+
        // A              n    h    t  |
        // ----------------------------+
        newTail.next = null;
        listTail.next = head;

        // 4 -> 5 -> 0 -> 1 -> 2 -> 3 -> null
        // h    t                   n
        // n - newTail
        // h - newHead
        // t - listTail
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
