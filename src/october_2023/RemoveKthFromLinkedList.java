package october_2023;

public class RemoveKthFromLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        int k = 5;
        // k < 0? No
        // k > ll length ? Yes

        Node node1 = removeKthFromEnd(node, k);
        while (node1 != null) {
            System.out.print(node1.val + " -> ");
            node1 = node1.next;
        }
    }

    // O(n) time | O(1) space
    public static Node removeKthFromEnd(Node node, int k) {
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
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return node;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
