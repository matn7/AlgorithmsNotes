package december_2023;

public class AddTwoNumbersAsLinkedLists {

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

//        System.out.println(sums(node1, node2));
        // 7 -> 0 -> 8 -> 2 -> 9 ->
        // Node node = sums3(node1, node2);
        // 7 -> 0 -> 8 -> 2 -> 9 ->
        Node node = sums2(node1, node2);
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
    }

    // O(n) time | O(n) space
    public static Node addTwoNumbers(Node node1, Node node2) {
        Node node = addTwoNumbersHelper(node1, node2, 0);
        return node;
    }

    private static Node addTwoNumbersHelper(Node l1, Node l2, int c) {
        int val = l1.value + l2.value + c;
        c = val / 10;
        Node ret = new Node(val % 10);

        if (l1.next != null || l2.next != null) {
            if (l1.next == null) {
                l1.next = new Node(0);
            }
            if (l2.next == null) {
                l2.next = new Node(0);
            }
            ret.next = addTwoNumbersHelper(l1.next, l2.next, c);
        }
        return ret;
    }

    // O(n) time | O(n) space
    public static Node sums2(Node node1, Node node2) {
        Node temp = new Node(0);
        Node curr = temp;
        sumsHelper(node1, node2, curr, 0);
        return temp.next;
    }

    private static void sumsHelper(Node node1, Node node2, Node curr, int carry) {
        if (node1.value == 0 && node2.value == 0) {
            return;
        }

        int sum = node1.value + node2.value + carry;
        int nodeVal = sum % 10;
        curr.next = new Node(nodeVal);
        if (node1.next == null) {
            node1.next = new Node(0);
        }
        if (node2.next == null) {
            node2.next = new Node(0);
        }

        curr = curr.next;
        node1 = node1.next;
        node2 = node2.next;
        carry = sum / 10;

        sumsHelper(node1, node2, curr, carry);

    }

    // O(n) time | O(1) space
    public static Node sums(Node node1, Node node2) {
        // 2 -> 4 -> 3
        // 4 -> 6 -> 5
        Node temp = new Node(0);
        Node curr = temp;
        int carry = 0;
        while (node1 != null && node2 != null) {
            int sum = node1.value + node2.value + carry; // 2 + 4 + 0
            carry = sum / 10;
            int nodeVal = sum % 10;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            int sum = node1.value + carry;
            carry = sum / 10;
            int nodeVal = sum % 10;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            node1 = node1.next;
        }

        while (node2 != null) {
            int sum = node2.value + carry;
            carry = sum / 10;
            int nodeVal = sum % 10;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            node2 = node2.next;
        }
        if (carry != 0) {
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
