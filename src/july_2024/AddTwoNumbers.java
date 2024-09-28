package july_2024;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(3);

        Node node2 = new Node(5);
        node2.next = new Node(6);
        node2.next.next = new Node(4);

        Node result = addTwoNumbers(node1, node2);
        System.out.println(result);
    }

    // O(max(n,m)) time | O(max(n,m)) space
    public static Node addTwoNumbers(Node node1, Node node2) {
        Node temp = new Node(0);
        Node curr = temp;

        // 2 -> 4 -> 3
        // 5 -> 6 -> 4

        // 2 + 5 + 0 = 7

        int carry = 0;
        while (node1 != null && node2 != null) {
            int sum = node1.value + node2.value + carry;
            carry = sum / 10; // 7 / 10 = 0
            int nodeVal = sum % 10; // 7 % 10 = 7
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
