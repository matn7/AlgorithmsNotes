package january_2026;

import java.util.PriorityQueue;

public class MergeKSortedLists2 {

    // O(nlog(k)) time | O(k) space
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            minHeap.add(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode poll = minHeap.poll();
            curr.next = poll;
            if (poll.next != null) {
                minHeap.add(poll.next);
            }
            curr = curr.next;
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
