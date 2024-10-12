package problems.other;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        Node ll1 = new Node(2);
        ll1.next = new Node(4);
        ll1.next.next = new Node(6);

        Node ll2 = new Node(5);
        ll2.next = new Node(6);
        ll2.next.next = new Node(4);
        ll2.next.next.next = new Node(9);
        ll2.next.next.next.next = new Node(9);

        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        addTwoNumbers2.addTwoNumbers(ll1, ll2);

        addTwoNumbers2.addTwoNumbers2(ll1, ll2);

        addTwoNumbers2.addTwoNumbers3(ll1, ll2);

    }

    // *
    // 2 -> 4 -> 6
    // *
    // 5 -> 6 -> 4 -> 9 -> 9
    // 7 -> 0 -> 1 -> 0 -> 0 -> 1

    // O(n) time | O(1) space
    public Node addTwoNumbers(Node l1, Node l2) {
        Node temp = new Node(0);
        Node curr = temp;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry; // 2 + 5 + 0 = 7
            int newVal = sum % 10; // 7 % 10 = 7
            carry = sum / 10; // 7 / 10 = 0
            curr.next = new Node(newVal);
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry; // 2 + 5 + 0 = 7
            int newVal = sum % 10; // 7 % 10 = 7
            carry = sum / 10; // 7 / 10 = 0
            curr.next = new Node(newVal);
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry; // 2 + 5 + 0 = 7
            int newVal = sum % 10; // 7 % 10 = 7
            carry = sum / 10; // 7 / 10 = 0
            curr.next = new Node(newVal);
            l2 = l2.next;
            curr = curr.next;
        }

        if (carry == 1) {
            curr.next = new Node(carry);
        }

        return temp.next;
    }

    public Node addTwoNumbers2(Node l1, Node l2) {
        Node temp = new Node(0);
        Node curr = temp;

        addTwoNumbersHelper(l1, l2, curr, 0);
        return temp.next;
    }

    private void addTwoNumbersHelper(Node l1, Node l2, Node curr, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 1) {
                curr.next = new Node(carry);
            }
            return;
        }
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int newVal = sum % 10;
            carry = sum / 10;
            curr.next = new Node(newVal);
            addTwoNumbersHelper(l1.next, l2.next, curr.next, carry);
        } else if (l1 != null) {
            int sum = l1.val + carry;
            int newVal = sum % 10;
            carry = sum / 10;
            curr.next = new Node(newVal);
            addTwoNumbersHelper(l1.next, null, curr.next, carry);
        } else {
            int sum = l2.val + carry;
            int newVal = sum % 10;
            carry = sum / 10;
            curr.next = new Node(newVal);
            addTwoNumbersHelper(null, l2.next, curr.next, carry);
        }
    }

    private Node addTwoNumbers3(Node l1, Node l2) {
        return addTwoNumbersHelper3(l1, l2, 0);
    }

    private Node addTwoNumbersHelper3(Node l1, Node l2, int carry) {
        int val = l1.val + l2.val + carry;
        carry = val / 10;
        Node ret = new Node(val % 10);

        if (l1.next != null || l2.next != null) {
            if (l1.next == null) {
                l1.next = new Node(0);
            }
            if (l2.next == null) {
                l2.next = new Node(0);
            }
            ret.next = addTwoNumbersHelper3(l1.next, l2.next, carry);
        } else if (carry == 1) {
            ret.next = new Node(carry);
        }
        return ret;
    }


    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
