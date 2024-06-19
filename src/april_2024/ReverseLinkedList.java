package april_2024;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node reversed = reverseLinkedList(node);
        System.out.println(reversed);
    }

    // O(n) time | O(1) space
    public static Node reverseLinkedList(Node head) {
        //                              prev  curr
        //       <- 1  <- 2 <- 3 <- 4 <- 5
        //                                   next
        Node prev = null;
        Node curr = head;
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
