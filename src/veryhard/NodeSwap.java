package veryhard;

public class NodeSwap {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //
    // 0 ---> 1 ---> 2 ---> 3 ---> 4 ---> 5

    // OK - repeated 27/02/2022
    // O(n) time | O(n) swap
    public LinkedList nodeSwap(LinkedList head) {
        LinkedList tempNode = new LinkedList(0);
        tempNode.next = head;

        // +-------------+
        // |             |      +--------------------+
        // |             V      |                    V
        // 0      0 <--- 1*     2 <--- 3     p4 <--- 5
        //        |                    A      |
        //        +--------------------+      +--------------->
        LinkedList prevNode = tempNode;
        while (prevNode.next != null && prevNode.next.next != null) {
            LinkedList firstNode = prevNode.next;
            LinkedList secondNode = prevNode.next.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode.next = secondNode;

            prevNode = firstNode;
        }

        return tempNode.next;
    }

    // O(n) time | O(n) space
    public LinkedList nodeSwap2(LinkedList head) {
        // Write your code here.
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList nextNode = head.next;
        head.next = nodeSwap2(head.next.next);
        nextNode.next = head;
        return nextNode;
    }

}
