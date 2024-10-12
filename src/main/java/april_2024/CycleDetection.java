package april_2024;

public class CycleDetection {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next.next = node.next.next;
    }

    // O(n) time | O(1) space
    public static Node cycleDetection(Node head) {
        Node hare = head;
        Node tortoise = head;

        while (true) {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare == null || hare.next == null) {
                return null;
            }
            hare = hare.next;
            if (tortoise == hare) {
                break;
            }
        }
        Node p1 = head;
        Node p2 = hare;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
