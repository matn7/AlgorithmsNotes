package october_2023;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.next = new Node(4);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);
        Node result = reverseLinkedList(node);
        System.out.println();
    }

    // O(n) time | O(1) space
    public static Node reverseLinkedList(Node node) {
        Node prev = null;
        Node curr = node;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
