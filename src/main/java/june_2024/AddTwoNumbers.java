package june_2024;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(3);

        Node node2 = new Node(5);
        node2.next = new Node(6);
        node2.next.next = new Node(4);
        node2.next.next.next = new Node(9);
        node2.next.next.next.next = new Node(8);

        Node node = addTwoNumbers(node1, node2);
        System.out.println();
        Node nodeRec = addTwoNumbers(node1, node2);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static Node addTwoNumbersRec(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node temp = new Node(0);
        Node curr = temp;
        addTwoNumbersHelper(node1, node2, 0, curr);
        return temp.next;
    }

    private static void addTwoNumbersHelper(Node node1, Node node2, int carry, Node curr) {
        if (node1 == null && node2 == null) {
            if (carry != 0) {
                curr.next = new Node(carry);
            }
            return;
        }
        if (node1 == null) {
            node1 = new Node(0);
        }
        if (node2 == null) {
            node2 = new Node(0);
        }
        int sum = node1.val + node2.val + carry;
        carry = sum / 10;
        int nodeVal = sum % 10;
        curr.next = new Node(nodeVal);
        curr = curr.next;
        node1 = node1.next;
        node2 = node2.next;
        addTwoNumbersHelper(node1, node2, carry, curr);
    }

    // O(n) time | O(1) space
    public static Node addTwoNumbers(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node temp = new Node(0);
        Node curr = temp;
        int carry = 0;
        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            int nodeVal = sum % 10;
            curr.next = new Node(nodeVal);
            node1 = node1.next;
            node2 = node2.next;
            curr = curr.next;
        }
        while (node1 != null) {
            int sum = node1.val + carry;
            carry = sum / 10;
            int nodeVal = sum % 10;
            curr.next = new Node(nodeVal);
            node1 = node1.next;
            curr = curr.next;
        }
        while (node2 != null) {
            int sum = node2.val + carry;
            carry = sum / 10;
            int nodeVal = sum % 10;
            curr.next = new Node(nodeVal);
            node2 = node2.next;
            curr = curr.next;
        }
        if (carry != 0) {
            curr.next = new Node(carry);
        }

        return temp.next;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
