package coderpro;

public class ReverseLinkedList2 {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        Node result = reverseLinkedList2.reverseLinkedList(node);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public Node reverseLinkedList(Node node) {

        //                        p   c
        // <- 1 <- 2 <- 3 <- 4 <- 5   n

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
