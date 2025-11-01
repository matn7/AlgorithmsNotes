package october_2025;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    // O(n log(k)) time | O(k) space
    // n - total number of elems in lists
    // k - num of lists
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            minHeap.add(node);
        }

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
