package april_2025;

import java.util.PriorityQueue;

public class MergeKLists {

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

        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode = mergeKLists.mergeKLists(lists);
        System.out.println(listNode);
    }
    

    // O(nlog(k)) time | O(k) space
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

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
