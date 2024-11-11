package october_2024;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean result = linkedListCycle.hasCycle(head);
        System.out.println();
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast.next) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Map<ListNode, Boolean> cache = new HashMap<>();

        ListNode curr = head;
        while (curr != null) {
            if (cache.containsKey(curr)) {
                return true;
            }
            cache.put(curr, Boolean.TRUE);
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
