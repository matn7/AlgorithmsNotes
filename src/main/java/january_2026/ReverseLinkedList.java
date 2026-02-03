package january_2026;

public class ReverseLinkedList {

    // O(n) time | O(1) space
    public ListNode reverseList(ListNode head) {
        return rec(head, null);
    }

    private ListNode rec(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return rec(curr, prev);
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


}
