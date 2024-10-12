package january_2024;

public class RotateLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node rotate = rotate(node, 2);
        System.out.println(rotate);
    }

    // O(n) time | O(1) space
    public static Node rotate(Node node, int n) {
        int length = 0;
        Node curr = node;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        n = n % length;

        Node slow = node;
        Node fast = node;

        while (fast.next != null) {
            fast = fast.next;
        }

        fast.next = node;
        Node head = slow.next;
        slow.next = null;

        return head;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
