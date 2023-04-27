package whiteboard;

public class RearrangeLinkedList {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(-9000);
        head.next = new LinkedList(3);
        head.next.next = new LinkedList(0);
        head.next.next.next = new LinkedList(5);
        head.next.next.next.next = new LinkedList(2);
        head.next.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next.next = new LinkedList(4);

        rearrangeLinkedList(head, 3);
    }

    // ********
    //
    // * STAR *
    // ********

    // O(n) time | O(1) space
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        // Write your code here.
        LinkedList smallerHead = null;
        LinkedList smallerTail = null;
        LinkedList equalHead = null;
        LinkedList equalTail = null;
        LinkedList greaterHead = null;
        LinkedList greaterTail = null;

        LinkedList node = head;
        while (node != null) {
            if (node.value < k) {
                LinkedListInfo smallerInfo = growLinkedList(smallerHead, smallerTail, node);
                smallerHead = smallerInfo.newHead;
                smallerTail = smallerInfo.newTail;
            } else if (node.value > k) {
                LinkedListInfo greaterInfo = growLinkedList(greaterHead, greaterTail, node);
                greaterHead = greaterInfo.newHead;
                greaterTail = greaterInfo.newTail;
            } else {
                LinkedListInfo equalInfo = growLinkedList(equalHead, equalTail, node);
                equalHead = equalInfo.newHead;
                equalTail = equalInfo.newTail;
            }
//            LinkedList prevNode = node;
            node = node.next;
//            prevNode.next = null;
        }

        LinkedListInfo firstInfo = connectLinkedList(smallerHead, smallerTail, equalHead, equalTail);
        LinkedList firstHead = firstInfo.newHead;
        LinkedList firstTail = firstInfo.newTail;
        LinkedListInfo finalInfo = connectLinkedList(firstHead, firstTail, greaterHead, greaterTail);
        LinkedList finalHead = finalInfo.newHead;

        return finalHead;
    }

    private static LinkedListInfo connectLinkedList(LinkedList headOne, LinkedList tailOne,
                                                    LinkedList headTwo, LinkedList tailTwo) {
        LinkedList newHead = headOne != null ? headOne : headTwo;
        LinkedList newTail = tailTwo != null ? tailTwo : tailOne;

        if (tailOne != null) {
            tailOne.next = headTwo;
        }

        return new LinkedListInfo(newHead, newTail);
    }

    private static LinkedListInfo growLinkedList(LinkedList head, LinkedList tail, LinkedList node) {
        LinkedList newHead = head;
        LinkedList newTail = node;

        if (head == null) {
            newHead = node;
        }
        if (tail != null) {
            tail.next = node;
        }
        return new LinkedListInfo(newHead, newTail);
    }

    static class LinkedListInfo {
        LinkedList newHead;
        LinkedList newTail;

        public LinkedListInfo(LinkedList newHead, LinkedList newTail) {
            this.newHead = newHead;
            this.newTail = newTail;
        }
    }

    // O(n) time | O(1) space
    public static LinkedList rearrangeLinkedList2(LinkedList head, int k) {
        // Write your code here.
        LinkedList smallerListHead = null;
        LinkedList smallerListTail = null;
        LinkedList equalListHead = null;
        LinkedList equalListTail = null;
        LinkedList greaterListHead = null;
        LinkedList greaterListTail = null;

        LinkedList node = head;
        while(node != null) {
            if (node.value < k) {
                smallerListHead = growLinkedList2(smallerListHead, smallerListTail, node).head;
                smallerListTail = growLinkedList2(smallerListHead, smallerListTail, node).tail;
            } else if (node.value > k) {
                greaterListHead = growLinkedList2(greaterListHead, greaterListTail, node).head;
                greaterListTail = growLinkedList2(greaterListHead, greaterListTail, node).tail;
            } else {
                equalListHead = growLinkedList2(equalListHead, equalListTail, node).head;
                equalListTail = growLinkedList2(equalListHead, equalListTail, node).tail;
            }

            LinkedList prevNode = node;
            node = node.next;
            prevNode.next = null;
        }

        LinkedListPair first = connectLinkedList2(smallerListHead, smallerListTail, equalListHead, equalListTail);
        LinkedListPair finalHead = connectLinkedList2(first.head, first.tail, greaterListHead, greaterListTail);
        return finalHead.head;
    }

    private static LinkedListPair connectLinkedList2(LinkedList headOne, LinkedList tailOne, LinkedList headTwo, LinkedList tailTwo) {
        LinkedList newHead = headOne == null ? headTwo : headOne;
        LinkedList newTail = tailTwo == null ? tailOne : tailTwo;

        if (tailOne != null) {
            tailOne.next = headTwo;
        }

        return new LinkedListPair(newHead, newTail);
    }

    private static LinkedListPair growLinkedList2(LinkedList head, LinkedList tail, LinkedList node) {
        LinkedList newHead = head;
        LinkedList newTail = node;

        if (newHead == null) {
            newHead = node;
        }
        if (tail != null) {
            tail.next = node;
        }

        return new LinkedListPair(newHead, newTail);
    }

    static class LinkedListPair {
        LinkedList head;
        LinkedList tail;

        public LinkedListPair(LinkedList head, LinkedList tail) {
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
