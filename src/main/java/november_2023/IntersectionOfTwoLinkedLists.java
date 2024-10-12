package november_2023;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next  = new Node(3);
        head1.next.next.next = new Node(4);

        Node head2 = new Node(6);
        head2.next = head1.next.next;

        intersectionOfLinkedLists(head1, head2);

    }

    // O(n) time | O(1) space
    public static Node intersectionOfLinkedLists(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        while (curr1 != curr2) {
            if (curr1 == null) {
                curr1 = head2;
            } else {
                curr1 = curr1.next;
            }
            if (curr2 == null) {
                curr2 = head1;
            } else {
                curr2 = curr2.next;
            }
        }

        return curr1;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
