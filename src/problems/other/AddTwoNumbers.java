package problems.other;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbersIterative(l1, l2);
        System.out.println();
    }

    // O(n) time | O(n) space
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int c) {
        int val = l1.val + l2.val + c;
        c = val / 10;
        ListNode ret = new ListNode(val % 10);

        if (l1.next != null || l2.next != null) {
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }
            ret.next = addTwoNumbersHelper(l1.next, l2.next, c);
        }
        return ret;
    }

    // O(n) time | O(n) space
    public ListNode addTwoNumbersIterative(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        int c = 0;
        ListNode ret = null;
        ListNode current = null;

        while (a != null || b != null) {
            int val = a.val + b.val + c;
            c = val / 10;
            if (current == null) {
                ret = new ListNode(val % 10);
                current = ret;
            } else {
                current.next = new ListNode(val % 10);
                current = current.next;
            }
            if (a.next != null || b.next != null) {
                if (a.next == null) {
                    a.next = new ListNode(0);
                }
                if (b.next == null) {
                    b.next = new ListNode(0);
                }
            }
            a = a.next;
            b = b.next;
        }
        return ret;
    }

    // O(n) time | O(1) space
    public ListNode addTwoNumbersMy(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode newList = new ListNode(0);
        ListNode curr = newList;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            if (val >= 10) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + carry;
            if (val >= 10) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(val);
        }

        while (l2 != null) {
            int val = l2.val + carry;
            if (val >= 10) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(val);
        }

        return newList.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}