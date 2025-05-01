package april_2025;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    // O(n) time | O(n) space
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        helper(curr, l1, l2, 0);
        return dummy.next;
    }

    private void helper(ListNode curr, ListNode l1, ListNode l2, int carry) {
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
        int val = l1.val + l2.val + carry;
        curr.next = new ListNode(val % 10);
        carry = val / 10;
        curr = curr.next;
        l1 = l1.next;
        l2 = l2.next;
        helper(curr, l1, l2, carry);
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
            int val = l1.val + l2.val + carry;
            curr.next = new ListNode(val % 10);
            carry = val / 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
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
