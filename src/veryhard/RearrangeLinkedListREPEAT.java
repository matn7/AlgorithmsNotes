package veryhard;

public class RearrangeLinkedListREPEAT {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(3);
        head.next = new LinkedList(0);
        head.next.next = new LinkedList(5);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(4);

        rearrangeLinkedList(head, 3);

        // 3 -> 0 -> 5 -> 2 -> 1 -> 4
        // 0 -> 2 -> 1 -> 3 -> 5 -> 4
    }

    // OK - repeated 22/02/2022
    // O(n) time | O(1) space
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        // Write your code here.
        //                          *
        // 3 -> 0 -> 5 -> 2 -> 1 -> 4           k = 3

        LinkedList smallerListHead = null; // (0)->(2)->(1)
        LinkedList smallerListTail = null; // (1)
        LinkedList equalListHead = null; // (3)
        LinkedList equalListTail = null; // (3)
        LinkedList greaterListHead = null; // (5)->(4)
        LinkedList greaterListTail = null; // (4)

        LinkedList node = head; // 3
        while (node != null) {
            if (node.value < k) { // 4 < 3
                // rec((0)->(2), (2), (1))
                LinkedListInfo smallerInfo = growLinkedList(smallerListHead, smallerListTail, node); // (0->2->1,1)
                smallerListHead = smallerInfo.head;
                smallerListTail = smallerInfo.tail;
            } else if (node.value > k) { // 4 > 3
                // rec((5), (5), (4))
                LinkedListInfo greaterInfo = growLinkedList(greaterListHead, greaterListTail, node);  // ((5)->(4),(4))
                greaterListHead = greaterInfo.head;
                greaterListTail = greaterInfo.tail;
            } else {
                // rec(null, null, (3))
                LinkedListInfo equalInfo = growLinkedList(equalListHead, equalListTail, node); // (3,3)
                equalListHead = equalInfo.head;
                equalListTail = equalInfo.tail;
            }
            LinkedList prevNode = node;
            node = node.next;
            prevNode.next = null;
        }
        // rec((0)->(2)->(1), (1), (3), (3))
        LinkedListInfo firstInfo = connectLinkedList(smallerListHead, smallerListTail,
                equalListHead, equalListTail);
        // ((0)->(2)->(1)->(3),(3))
        LinkedList firstHead = firstInfo.head; // (0)->(2)->(1)->(3)
        LinkedList firstTail = firstInfo.tail; // (3)

        // rec((0)->(2)->(1)->(3), (3), (5)->(4), (4))
        LinkedListInfo finalInfo = connectLinkedList(firstHead, firstTail, greaterListHead, greaterListTail);
        // ((0)->(2)->(1)->(3)->(5)->(4),(4))
        LinkedList finalHead = finalInfo.head;

        return finalHead; // (0)->(2)->(1)->(3)->(5)->(4)
    }

    // rec((0)->(2)->(1)->(3), (3), (5)->(4), (4))
    private static LinkedListInfo connectLinkedList(LinkedList headOne, LinkedList tailOne, LinkedList headTwo,
                                                    LinkedList tailTwo) {
        LinkedList newHead = headOne == null ? headTwo : headOne; // (0)->(2)->(1)->(3)
        LinkedList newTail = tailTwo == null ? tailOne : tailTwo; // (4)

        if (tailOne != null) {
            tailOne.next = headTwo; // (0)->(2)->(1)->(3)->(5)->(4)
        }

        return new LinkedListInfo(newHead, newTail); // ((0)->(2)->(1)->(3)->(5)->(4),(4))
    }

    // rec((5), (5), (4))
    private static LinkedListInfo growLinkedList(LinkedList head, LinkedList tail, LinkedList node) {
        LinkedList newHead = head; // (5)->(4)
        LinkedList newTail = node; // (4)

        if (newHead == null) {
            newHead = node; // (5)
        }
        if (tail != null) {
            tail.next = node;
        }

        return new LinkedListInfo(newHead, newTail);  // ((5)->(4),(4))
    }

    static class LinkedListInfo {
        LinkedList head;
        LinkedList tail;

        public LinkedListInfo(LinkedList head, LinkedList tail) {
            this.head = head;
            this.tail = tail;
        }
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
