package october_2023;

public class MergingLinkedList {

    public static void main(String[] args) {
        Node one = new Node(2);
        one.next = new Node(3);
        one.next.next = new Node(8);
        one.next.next.next = new Node(4);

        Node two = new Node(6);
        two.next = one.next.next;
        two.next.next = one.next.next.next;

        mergingNode(one, two);
    }

    // O(n + m) time | O(1) space
    public static Node mergingNode(Node one, Node two) {
        if (one == null || two == null) {
            return null;
        }
        Node p1 = one;
        Node p2 = two;

        while (p1 != p2) {
            if (p1.next == null) {
                p1 = two;
            }
            if (p2.next == null) {
                p2 = one;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
