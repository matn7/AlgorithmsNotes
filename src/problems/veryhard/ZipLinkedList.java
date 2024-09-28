package problems.veryhard;

public class ZipLinkedList {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ZipLinkedList zipLinkedList = new ZipLinkedList();
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(2);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next = new LinkedList(6);

        zipLinkedList.zipLinkedList(linkedList);
    }

    // 1 ---> 2 ---> 3 ---> 4 ---> 5 ---> 6

    // OK - repeated 26/02/2022
    // O(n) time | O(1) space
    // rec(1)
    public LinkedList zipLinkedList(LinkedList linkedList) {
        // Write your code here.
        if (linkedList.next == null) {
            return linkedList;
        }

        // f
        // 1 ---> 2 ---> 3 ---> 4 ---> 5 ---> 6
        LinkedList firstHalfHead = linkedList;
        // rec(1)
        LinkedList secondHalfHead = splitLinkedList(linkedList);
        // rec(5 ---> 6)
        LinkedList reversedSecondHalfHead = reverseLinkedList(secondHalfHead); // 6 ---> 5

        // rec(1 ---> 2 ---> 3 ---> 4,  6 ---> 5)
        return interweaveLinkedLists(firstHalfHead, reversedSecondHalfHead);
    }

    // rec(1)
    private LinkedList splitLinkedList(LinkedList linkedList) {
        LinkedList slowIterator = linkedList; // 1
        LinkedList fastIterator = linkedList; // 1
        //                      s
        // 1 ---> 2 ---> 3 ---> 4 ---> 5 ---> 6
        //                                         f
        while (fastIterator != null && fastIterator.next != null) {
            slowIterator = slowIterator.next;
            fastIterator = fastIterator.next.next;
        }

        LinkedList secondHalfHead = slowIterator.next; // 5
        slowIterator.next = null; // 1 ---> 2 ---> 3 ---> 4
        return secondHalfHead;    // 5 ---> 6
    }

    private LinkedList reverseLinkedList(LinkedList linkedList) {
        LinkedList previousNode = null;
        LinkedList currentNode = linkedList;
        // rec(5 ---> 6)
        //            p     c
        //  <--5<-----6
        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    // rec(1 ---> 2 ---> 3 ---> 4,  6 ---> 5)
    private LinkedList interweaveLinkedLists(LinkedList linkedList1, LinkedList linkedList2) {
        LinkedList linkedList1Iterator = linkedList1; // 1
        LinkedList linkedList2Iterator = linkedList2; // 6
        //        f
        // 1 ---> 2 ---> 3 ---> 4
        //        s
        // 6 ---> 5
        while (linkedList2Iterator != null) {
            LinkedList linkedList1IteratorNext = linkedList1Iterator.next; // 3
            LinkedList linkedList2IteratorNext = linkedList2Iterator.next; // null

            linkedList1Iterator.next = linkedList2Iterator; // 1 ---> 6 ---> 2 ---> 5 ---> 3 ---> 4
            linkedList2Iterator.next = linkedList1IteratorNext;

            linkedList1Iterator = linkedList1IteratorNext;
            linkedList2Iterator = linkedList2IteratorNext;
        }

        return linkedList1;
    }
}
