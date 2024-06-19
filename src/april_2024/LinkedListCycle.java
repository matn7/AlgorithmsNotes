package april_2024;

public class LinkedListCycle {

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(7);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = head.next.next;

        boolean result = hasCycle(head);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static boolean hasCycle(Node head) {
        Node hare = head;
        Node tortoise = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = head.next.next;
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
