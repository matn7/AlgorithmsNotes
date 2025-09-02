package august_2025;

public class AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumber addTwoNumbers = new AddTwoNumber();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    // O(n) time | O(1) space
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        helper(l1, l2, 0, curr);
        return temp.next;
    }

    private ListNode helper(ListNode l1, ListNode l2, int carry, ListNode curr) {
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                curr.next = new ListNode(carry);
            }
            return curr;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int nodeVal = l1.val + l2.val + carry;
        curr.next = new ListNode(nodeVal % 10);
        carry = nodeVal / 10;
        l1 = l1.next;
        l2 = l2.next;
        curr = curr.next;
        return helper(l1, l2, carry, curr);
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
