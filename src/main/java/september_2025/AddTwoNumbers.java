package september_2025;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    // O(n + m) time | O(1) space
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
