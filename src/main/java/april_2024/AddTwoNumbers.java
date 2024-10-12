package april_2024;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(3);

        Node node2 = new Node(5);
        node2.next = new Node(6);
        node2.next.next = new Node(4);

        Node result = addTwoNumbers2(node1, node2);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static Node addTwoNumbers(Node num1, Node num2) {
        Node temp = new Node(0);
        Node curr = temp;
        int carry = 0;

        while (num1 != null && num2 != null) {
            int sum = num1.value + num2.value + carry;
            int nodeSum = sum % 10;

            curr.next = new Node(nodeSum);
            curr = curr.next;
            num1 = num1.next;
            num2 = num2.next;

            carry = sum / 10;
        }
        while (num1 != null) {
            int sum = num1.value + carry;
            int nodeSum = sum % 10;

            curr.next = new Node(nodeSum);
            curr = curr.next;
            num1 = num1.next;

            carry = sum / 10;
        }
        while (num2 != null) {
            int sum = num2.value + carry;
            int nodeSum = sum % 10;

            curr.next = new Node(nodeSum);
            curr = curr.next;
            num2 = num2.next;

            carry = sum / 10;
        }
        if (carry > 0) {
            curr.next = new Node(carry);
        }

        return temp.next;
    }

    // O(max(n,m)) time | O(max(n,m)) space
    public static Node addTwoNumbers2(Node num1, Node num2) {
        Node answer = new Node(0);
        Node pointer = answer;
        int carry = 0;
        int sum = 0;

        while (num1 != null || num2 != null) {
            sum = carry;
            if (num1 != null) {
                sum += num1.value;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.value;
                num2 = num2.next;
            }
            carry = sum / 10;
            pointer.next = new Node(sum % 10);
            pointer = pointer.next;
        }

        if (carry > 0) {
            pointer.next = new Node(carry);
        }

        return answer.next;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
