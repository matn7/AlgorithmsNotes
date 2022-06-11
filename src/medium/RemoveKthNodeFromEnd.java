package medium;

public class RemoveKthNodeFromEnd {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next.next = new LinkedList(7);
        head.next.next.next.next.next.next.next.next = new LinkedList(8);
        head.next.next.next.next.next.next.next.next.next = new LinkedList(9);

        traverse(head);

        removeKthNodeFromEnd(head, 10);
        traverse(head);
    }

    public static void traverse(LinkedList linkedList) {
        while (linkedList != null) {
            System.out.print(linkedList.value + " ");
            linkedList = linkedList.next;
        }
        System.out.println();
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList first = head;
        int total = 0;
        while (first != null) {
            first = first.next;
            total++;
        }

        LinkedList prev = null;
        int counter = 0;
        int nodeToDelIdx = total - k;
        first = head;
        if (nodeToDelIdx == 0) {
            while (first.next != null) {
                prev = first;
                first.value = first.next.value;
                first = first.next;
            }
            prev.next = null;
            return;
        }
        while (first.next != null && counter < nodeToDelIdx) {
            prev = first;
            first = first.next;
            counter++;
        }

        if (prev == null) {
            // delete head

            first = first.next;
            head = first;
        } else {
            prev.next = first.next;
        }
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
