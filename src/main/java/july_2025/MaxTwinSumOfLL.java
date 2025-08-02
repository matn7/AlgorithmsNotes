package july_2025;

public class MaxTwinSumOfLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        MaxTwinSumOfLL maxTwinSumOfLL = new MaxTwinSumOfLL();
        int result = maxTwinSumOfLL.pairSum(head);

        System.out.println(result);
    }

    // Intuition:
    // - twins are on borders [0, n - 1] -> [1, n - 2]
    // - DS singly LL
    // Approach:
    // - find mid point (slow and fast pointer pattern)
    // - reverse [mid, end]
    // - Calc sum, and pick max
    // Complexity:
    // O(n) time - O(n) find mid, O(n/2) reverse, O(n/2) calc max sum
    // Code:

    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode toRev = slow.next;
        slow.next = null;

        int maxSum = 0;
        ListNode a = head;
        ListNode b = reverse(toRev);

        while (a != null && b != null) {
            maxSum = Math.max(maxSum, a.val + b.val);
            a = a.next;
            b = b.next;
        }

        return maxSum;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
