package october_2025;

import java.util.List;

public class MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
//        ListNode head = new ListNode(5);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        ListNode head = new ListNode(1);
        head.next = new ListNode(100000);

        MaximumTwinSumOfALinkedList maximumTwinSumOfALinkedList = new MaximumTwinSumOfALinkedList();
        int result = maximumTwinSumOfALinkedList.pairSum(head);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int pairSum(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);
        slow.next = null;
        slow = head;
        int max = Integer.MIN_VALUE;
        while (slow != null && rev != null) {
            max = Math.max(max, slow.val + rev.val);
            slow = slow.next;
            rev = rev.next;
        }
        return max;
    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
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
