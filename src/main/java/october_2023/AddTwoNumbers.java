package october_2023;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        l2.next.next.next = new Node(9);
        l2.next.next.next.next = new Node(9);
        l2.next.next.next.next.next = new Node(9);

        Node node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
    }

    // O(n) time | O(1) space
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node curr1 = l1;
        Node curr2 = l2;

        Node temp = new Node(0);
        Node curr = temp;
        int carry = 0;

        while (curr1 != null && curr2 != null) {
            int val = curr1.value + curr2.value + carry; // 2 + 7 + 0
            int nodeVal = val % 10; // 7 % 10 = 7
            carry = val / 10; // 7 / 10 = 0;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int val = curr1.value + carry; // 2 + 7 + 0
            int nodeVal = val % 10; // 7 % 10 = 7
            carry = val / 10; // 7 / 10 = 0;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int val = curr2.value + carry; // 2 + 7 + 0
            int nodeVal = val % 10; // 7 % 10 = 7
            carry = val / 10; // 7 / 10 = 0;
            curr.next = new Node(nodeVal);
            curr = curr.next;
            curr2 = curr2.next;
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
