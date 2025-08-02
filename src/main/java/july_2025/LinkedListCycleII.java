package july_2025;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        LinkedListCycleII cycleII = new LinkedListCycleII();
        ListNode listNode = cycleII.detectCycle(head);
        System.out.println(listNode);
    }

    // Intuition:
    // - LL (slow and fast), (reverse), (dummy nodes), (pointer manipulation)
    // Approach:
    // - Seen set - brute force
    // Complexity:
    // - O(n) time | O(n) space
    // - O(n) time | O(n) space
    // Code:

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

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
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (seen.contains(curr)) {
                return curr;
            }
            seen.add(curr);
            curr = curr.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
