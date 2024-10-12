package july_2024;

public class AddTwoNumbersV2 {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(3);

        Node node2 = new Node(5);
        node2.next = new Node(6);
        node2.next.next = new Node(4);

    }

    // O(max(n,m)) time | O(max(n,m)) space
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node ans = new Node(0);
        Node pointer = ans;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum = carry;
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }
            carry = sum / 10;
            pointer.next = new Node(sum % 10);
            pointer = pointer.next;
        }
        if (carry > 0) {
            pointer.next = new Node(carry);
        }
        return ans.next;
    }


    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
