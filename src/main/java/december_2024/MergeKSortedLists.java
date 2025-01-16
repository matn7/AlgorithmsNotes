package december_2024;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        // lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

//        ListNode[] lists = {l1, l2, l3};
        ListNode[] lists = {null};


        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode listNode = mergeKSortedLists.mergeKLists(lists);
        System.out.println();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(new Node(list));
            }
        }

        while (!queue.isEmpty()) {
            Node list = queue.poll();
            curr.next = list.listNode;
            list.listNode = list.listNode.next;
            if (list.listNode != null) {
                queue.add(new Node(list.listNode));
            }
            curr = curr.next;

        }

        return dummy.next;

    }

    static class Node implements Comparable<Node> {
        ListNode listNode;

        public Node(ListNode listNode) {
            this.listNode = listNode;
        }

        @Override
        public int compareTo(Node o) {
            return listNode.val - o.listNode.val;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
