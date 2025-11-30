package november_2025;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    // O(n * log(m)) time | O(m) space
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            curr.next = poll;
            curr = curr.next;
            if (poll.next != null) {
                queue.add(poll.next);
            }
        }

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
