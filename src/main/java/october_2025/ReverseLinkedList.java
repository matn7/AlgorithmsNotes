package october_2025;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return helper(curr, prev);
    }

    // O(n) time | O(1) space
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

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
