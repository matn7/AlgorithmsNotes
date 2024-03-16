package october_2023;

public class RemoveKthNodeFromEnd {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 0;

        // k > length? Yes
        // k < 0 ? No
        removeFromEnd(head, k);

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    // O(n) time | O(1) space
    public static void removeFromEnd(Node node, int k) {
        int length = 1;
        Node curr = node;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        if (k == length) {
            node.val = node.next.val;
            node.next = node.next.next;
            return;
        }
        Node fast = node;
        curr = node;
        k = k % length;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            curr = curr.next;
        }
        if (curr.next == null) {
            curr = null;
            return;
        }
        curr.next = curr.next.next;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
