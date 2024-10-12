package september_2024;

public class RemoveKthFromEnd {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(5);
        node.next.next = new Node(1);
//        node.next.next.next = new Node(4);
//        node.next.next.next.next = new Node(3);
//        node.next.next.next.next.next = new Node(4);
//        node.next.next.next.next.next.next = new Node(4);
//        node.next.next.next.next.next.next.next = new Node(5);
//        node.next.next.next.next.next.next.next.next = new Node(1);

        RemoveKthFromEnd removeKthFromEnd = new RemoveKthFromEnd();
        removeKthFromEnd.removeKth(node, 3);
        System.out.println(node);
    }

    public void removeKth(Node node, int k) {
        Node slow = node;
        Node fast = node;

        while (k > 0) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            node.value = node.next.value;
            node.next = node.next.next;
            return;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
    }


    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // Book
    int printKthToLast(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.value);
        }
        return index;
    }

    Node kthToLast(Node head, int k) {
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    Node kthToLast(Node head, int k, Index idx) {
        if (head == null) {
            return null;
        }
        Node node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }

    // O(n) time | O(1) space
    Node nthToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        // Move p1 k nodes into the list
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        // Move them at the same pace. When p1 hits the end, p2 will be at the right element
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}

class Index {
    public int value = 0;
}
