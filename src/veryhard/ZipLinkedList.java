package veryhard;

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

    // O(n) time | O(1) space
    public LinkedList zipLinkedList(LinkedList linkedList) {
        // Write your code here.
        // 1. Split LL
        // 2. Reverse LL2
        // 3. Inter weave
        if (linkedList.next == null || linkedList.next.next == null) {
            return linkedList;
        }
        LinkedList firstHalfHead = linkedList;
        LinkedList secondHalfHead = splitLinkedList(linkedList);

        LinkedList reversedSecondHalfHead = reverseLinkedList(secondHalfHead);
        return interweaveLinkedList(firstHalfHead, reversedSecondHalfHead);
    }

    private LinkedList splitLinkedList(LinkedList linkedList) {
        LinkedList slowIterator = linkedList;
        LinkedList fastIterator = linkedList;
        while (fastIterator != null && fastIterator.next != null) {
            slowIterator = slowIterator.next;
            fastIterator = fastIterator.next.next;
        }

        LinkedList secondHalfHead = slowIterator.next;
        slowIterator.next = null;
        return secondHalfHead;
    }

    private LinkedList reverseLinkedList(LinkedList linkedList) {
        LinkedList previousNode = null;
        LinkedList currentNode = linkedList;

        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    private LinkedList interweaveLinkedList(LinkedList linkedList1, LinkedList linkedList2) {
        LinkedList linkedList1Iterator = linkedList1;
        LinkedList linkedList2Iterator = linkedList2;
        while (linkedList2Iterator != null) {
            LinkedList linkedList1IteratorNext = linkedList1Iterator.next;
            LinkedList linkedList2IteratorNext = linkedList2Iterator.next;

            linkedList1Iterator.next = linkedList2Iterator;
            linkedList2Iterator.next = linkedList1IteratorNext;

            linkedList1Iterator = linkedList1IteratorNext;
            linkedList2Iterator = linkedList2IteratorNext;
        }

        return linkedList1;
    }


}
