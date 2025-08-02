package july_2025;

public class LinkedListCycle2 {

    // Intuition:
    // - Linked List Data Structure -> ListNode
    // - Store seen nodes - brute force
    // - Linked list -> fast slow, dummy node, reverse, pointer manipulation
    // Approach:
    // - Fast, slow until met, then slow2
    // - Edge cases, list empty, no cycle
    // Complexity:
    // - O(n) time | O(1) space
    // Code:

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode slow2 = head;
        while (slow2 != slow) {
            slow2 = slow2.next;
            slow = slow.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
