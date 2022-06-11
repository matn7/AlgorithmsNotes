package hard;

public class ReverseLinkedListREPEAT {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);

        LinkedList linkedList = reverseLinkedList(head);

        traverse(linkedList);
    }

    public static void traverse(LinkedList head) {
        LinkedList current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    //   head
    // <-- 0 <-- 1 <-- 2 <-- 3 <-- 4 <-- 5    null
    //                                   p     c
    // O(n) time | O(1) space
    // OK - repeated 29/01/2022
    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.
        if (head == null) {
            return null;
        }
        LinkedList prev = null;
        LinkedList current = head;
        while (current != null) {
            LinkedList next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}