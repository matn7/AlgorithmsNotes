package november_2023;

public class SumOfLinkedLists {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(7);
        node1.next.next.next = new Node(1);

        Node node2 = new Node(9);
        node2.next = new Node(4);
        node2.next.next = new Node(5);

        Node result = sumOfLinkedLists(node1, node2);
        System.out.println(result);
    }

    // O(max(n,m)) time | O(max(n,m)) space
    public static Node sumOfLinkedLists(Node node1, Node node2) {

        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        Node c1 = node1;
        Node c2 = node2;
        int carry = 0;
        Node temp = new Node(0);
        Node curr = temp;

        while (c1 != null && c2 != null) {
            int val = c1.value + c2.value + carry;
            int nodeVal = val % 10;
            carry = val / 10;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            c1 = c1.next;
            c2 = c2.next;
        }

        while (c1 != null) {
            int val = c1.value + carry;
            int nodeVal = val % 10;
            carry = val / 10;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            c1 = c1.next;
        }

        while (c2 != null) {
            int val = c2.value + carry;
            int nodeVal = val % 10;
            carry = val / 10;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            c2 = c2.next;
        }

        if (carry > 0) {
            curr.next = new Node(carry);
        }

        return temp.next;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
