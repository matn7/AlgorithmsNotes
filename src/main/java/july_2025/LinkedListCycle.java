package july_2025;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    // Intuition:
    // - LL, (fast, slow pointer), (reverse), (use dummy node).
    // - Datat Structure - Singly linked list
    // Approach:
    // - brute force, iterate through list and check seen?
    // Complexity:
    // - O(n) time | O(n) space
    // - O(n) time | O(1) space - fast / slow pointers
    // Code:

    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (seen.contains(curr)) {
                return true;
            }
            seen.add(curr);
            curr = curr.next;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
