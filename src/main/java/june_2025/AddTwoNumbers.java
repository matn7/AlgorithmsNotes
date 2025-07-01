package june_2025;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        helper(l1, l2, 0, curr);

        return dummy.next;
    }

    private void helper(ListNode l1, ListNode l2, int carry, ListNode curr) {
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                curr.next = new ListNode(carry);
            }
            return;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int val = carry + l1.val + l2.val;
        int nodeVal = val % 10;
        carry = val / 10;
        curr.next = new ListNode(nodeVal);
        l1 = l1.next;
        l2 = l2.next;
        curr = curr.next;
        helper(l1, l2, carry, curr);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int val = carry + l1.val + l2.val;
            int nodeVal = val % 10;
            carry = val / 10;
            curr.next = new ListNode(nodeVal);
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
