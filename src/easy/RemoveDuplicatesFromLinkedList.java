package easy;

public class RemoveDuplicatesFromLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next.next.next = new LinkedList(6);
        linkedList.next.next.next.next.next.next.next.next = new LinkedList(6);

        RemoveDuplicatesFromLinkedList removeDuplicatesFromLinkedList = new RemoveDuplicatesFromLinkedList();
        removeDuplicatesFromLinkedList.removeDuplicatesFromLinkedList(linkedList);
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6
    //
    //                                    c        n
    // 1    1 -> 3 -> 4    4 -> 4 -> 5 -> 6    6
    // |         A    |              A    |
    // +---------+    +--------------+    +----->
    // OK - repeated 01/03/2022
    // O(n) time | O(1) space
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList currentNode = linkedList;
        while (currentNode != null) {
            LinkedList nextDistinctNode = currentNode.next;
            while (nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return linkedList;
    }
}
