package december_2023;

public class ReverseALinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        reverseLinkedList(node);

    }

    // O(n) time | O(1) space
    public static Node reverseLinkedList(Node node) {
        //      1 -> 2 -> 3 -> 4 -> 5
        //  p   c    n
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
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
