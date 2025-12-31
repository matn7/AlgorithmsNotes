package december_2025;

public class FlattenMultilevelDLL {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node tail = head;

        // Find the tail of the Linked List at the first level.
        while (tail.next != null) {
            tail = tail.next;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                tail.next = curr.child;
                curr.child = null;
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;
    }

}
