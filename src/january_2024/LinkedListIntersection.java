package january_2024;

import easy.NodeDepths;

public class LinkedListIntersection {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);

        Node node2 = new Node(6);
        node2.next = node1.next.next;

        intersection(node1, node2);
    }

    // O(n + m) time | O(1) space
    public static Node intersection(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        Node curr1 = node1;
        Node curr2 = node2;

        while (curr1 != curr2) {

            if (curr1.next == null) {
                curr1 = node2;
            } else {
                curr1 = curr1.next;
            }

            if (curr2.next == null) {
                curr2 = node1;
            } else {
                curr2 = curr2.next;
            }
        }

        return curr1;

    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
