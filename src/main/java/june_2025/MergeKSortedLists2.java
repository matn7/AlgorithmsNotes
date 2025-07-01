package june_2025;

import java.util.Comparator;
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
        System.out.println();
    }

    // O(k log(n)) time | O(k) space
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            queue.add(list);
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            curr.next = poll;

            if (poll.next != null) {
                queue.add(poll.next);
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
