package december_2023;

public class RemoveKthElement {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        int k = 3;

        removeKthElement(node, k);
    }

    // O(n) time | O(1) space
    public static Node removeKthElement(Node node, int k) {
        if (node == null) {
            return null;
        }
        // 1 -> 2 -> 3 -> 4 -> 5
        //           c
        Node slow = node;
        Node fast = node;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return node.next;
        }

        Node prev = null;
        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = slow.next;

        return node;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
