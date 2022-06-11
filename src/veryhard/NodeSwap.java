package veryhard;

public class NodeSwap {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(2);
        linkedList.next.next.next = new LinkedList(3);
        linkedList.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next = new LinkedList(5);

        traverse(linkedList);

        nodeSwap(linkedList);
    }

    public static void traverse(LinkedList linkedList) {
        LinkedList current = linkedList;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static LinkedList nodeSwap(LinkedList head) {
        // Write your code here.
        LinkedList prev = null;
        LinkedList first = head;
        LinkedList second = head.next;

        while (second != null) {
            first.next = second.next;
            second.next = first;
            if (prev == null) {
                prev = first;
                head = prev;
            }

            first = first.next;
            second = second.next.next.next;
            System.out.println();
            traverse(head);
        }

        return null;
    }

    public static class LinkedList {
        public int value;

        public LinkedList next;
        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

    }

}
