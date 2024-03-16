package october_2023;

public class AddTwoNumbersRecursive {

    public static void main(String[] args) {
        Node one = new Node(2);
        one.next = new Node(4);
        one.next.next = new Node(3);

        Node two = new Node(5);
        two.next = new Node(6);
        two.next.next = new Node(6);
        two.next.next.next = new Node(5);

        addTwoNumbers(one, two);
    }

    // O(n) time | O(n) space
    public static Node addTwoNumbers(Node one, Node two) {
        Node temp = new Node(0);
        Node curr = temp;

        addTwoNumbersHelper(one, two, 0, curr);

        return temp.next;
    }

    private static void addTwoNumbersHelper(Node one, Node two, int carry, Node curr) {
        int val = one.val + two.val + carry; // 2 + 5 + 0
        int nodeVal = val % 10;
        int newCarry = val / 10;
        curr.next = new Node(nodeVal);
        curr = curr.next;
        if (one.next == null && two.next == null) {
            if (newCarry != 0) {
                curr.next = new Node(newCarry);
            }
            return;
        }
        if (one.next == null) {
            one.next = new Node(0);
        }
        if (two.next == null) {
            two.next = new Node(0);
        }
        addTwoNumbersHelper(one.next, two.next, newCarry, curr);
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
