package veryhard;

public class NodeSwapRepeat {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(2);
        linkedList.next.next.next = new LinkedList(3);
        linkedList.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next = new LinkedList(5);

        NodeSwapRepeat nodeSwapRepeat = new NodeSwapRepeat();
        nodeSwapRepeat.nodeSwap(linkedList);
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

    // O(n) time | O(1) space
    public LinkedList nodeSwap(LinkedList head) {
        // Write your code here.
        LinkedList tempNode = new LinkedList(0);
        tempNode.next = head;

        LinkedList prevNode = tempNode;
        while (prevNode.next != null && prevNode.next.next != null) {
            LinkedList firstNode = prevNode.next;
            LinkedList secondNode = prevNode.next.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode.next = secondNode;

            prevNode = firstNode;
            System.out.println();
        }
        return tempNode.next;
    }

//    // O(n) time | O(n) space
//    public LinkedList nodeSwap(LinkedList head) {
//        // Write your code here.
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        LinkedList nextNode = head.next;
//        head.next = nodeSwap(head.next.next);
//        nextNode.next = head;
//        return nextNode;
//    }

}
