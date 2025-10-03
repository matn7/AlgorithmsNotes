package september_2025;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode result = mergeKSortedLists.mergeKLists(lists);
        System.out.println(result);
    }

    // O(nlog(k)) time | O(k) space
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            minHeap.add(list);
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            if (node.next != null) {
                minHeap.add(node.next);
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
