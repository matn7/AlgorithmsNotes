package november_2025;

import java.util.PriorityQueue;

public class MergeKSortedLists2 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};
        MergeKSortedLists2 mergeKSortedLists2 = new MergeKSortedLists2();
        ListNode listNode = mergeKSortedLists2.mergeKLists(lists);
        System.out.println(listNode);

    }

    // O(nlog(k)) time | O(k) space
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // O(k)
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            minHeap.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();
            curr.next = current;
            if (current.next != null) {
                minHeap.add(current.next);
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
