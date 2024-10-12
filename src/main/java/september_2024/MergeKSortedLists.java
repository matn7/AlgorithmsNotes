package september_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        //lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = null;
        lists[1] = null;
        lists[2] = null;

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode result = mergeKSortedLists.mergeKLists(lists);
        System.out.println(result);

        ListNode result2 = mergeKSortedLists.mergeKLists2(lists);
        System.out.println(result2);
    }

    // O(nlog(k)) time | O(k) space
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNodeInfo> queue = new PriorityQueue<>();
        ListNode temp = new ListNode(0);
        ListNode curr = temp;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            queue.add(new ListNodeInfo(lists[i]));
        }

        while (!queue.isEmpty()) {
            ListNodeInfo poll = queue.poll();
            curr.next = poll.node;
            if (poll.node != null && poll.node.next != null) {
                queue.add(new ListNodeInfo(poll.node.next));
            }
            curr = curr.next;
        }

        return temp.next;
    }

    static class ListNodeInfo implements Comparable<ListNodeInfo> {
        ListNode node;

        public ListNodeInfo(ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(ListNodeInfo o) {
            return node.val - o.node.val;
        }
    }

    // O(nlog(k)) time | O(k) space
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> listsArr = new ArrayList<>();
        for (ListNode node : lists) {
            listsArr.add(node);
        }

        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();

            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = null;
                if (i + 1 < lists.length) {
                    l2 = lists[i + 1];
                }
                mergedLists.add(mergeList(l1, l2));
            }
            listsArr = mergedLists;
        }
        return listsArr.get(0);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
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
