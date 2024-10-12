package september_2024;

public class RemoveMidNode {

    public static void main(String[] args) {
        Node head = new Node('a');
        head.next = new Node('b');
//        head.next.next = new Node('c');
//        head.next.next.next = new Node('d');
//        head.next.next.next.next = new Node('c');
//        head.next.next.next.next.next = new Node('f');

        RemoveMidNode removeMidNode = new RemoveMidNode();
        removeMidNode.removeMid(head);

        System.out.println();
    }

    // O(n) time | O(1) space

    public void removeMid(Node head) {
        if (head == null) {
            return;
        }
        Node prev = null;
        Node slow = head;
        Node fast = head.next;
        if (fast == null) {
            return;
        }
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = slow.next;
        }

    }

    static class Node {
        char c;
        Node next;

        public Node(char c) {
            this.c = c;
        }
    }

    // Book
    boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        Node next = n.next;
        n.c = next.c;
        n.next = next.next;
        return true;
    }

}
