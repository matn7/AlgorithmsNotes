package october_2023;

public class RotateLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        int k = -3;
        // k > list length?
        // k < 0 ?

        Node result = rotate(node, k);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    // O(n) time | O(1) space
    public static Node rotate(Node node, int k) {
        if (node == null) {
            return null;
        }
        if (k == 0) {
            return node;
        }
        Node curr = node;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        Node tail = curr;
        k = k % length;
        if (k == 0) {
            return node;
        }
        if (k < 0) {
            k = length + k;
        }

        curr = node;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        //           *         t
        // 1 -> 2 -> 3 -> 4 -> 5
        if (curr.next == null) {
            tail.next = node;
            return tail;
        }

        Node newHead = curr.next;
        curr.next = null;
        tail.next = node;

        return newHead;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
