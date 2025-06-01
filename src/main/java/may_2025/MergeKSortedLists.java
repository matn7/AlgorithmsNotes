package may_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode listNode = mergeKSortedLists.mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    // O(nlog(k)) time | O(k) space
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            queue.add(list);
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            if (node.next != null) {
                queue.add(node.next);
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
