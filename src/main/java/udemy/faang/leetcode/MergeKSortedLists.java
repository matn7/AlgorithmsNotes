package udemy.faang.leetcode;

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

        mergeKSortedLists.mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<Element> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            queue.add(new Element(lists[i], i));
        }
        ListNode mergedNodes = new ListNode(0);
        ListNode curr = mergedNodes;

        while (!queue.isEmpty()) {
            Element current = queue.poll();
            ListNode currentNode = current.node;
            int idx = current.idx;
            curr.next = currentNode;
            currentNode = currentNode.next;
            if (currentNode != null) {
                queue.add(new Element(currentNode, idx));
            }
            curr = curr.next;
        }
        ListNode next = mergedNodes.next;
        return next;
    }

    static class Element implements Comparable<Element> {
        ListNode node;
        int idx;

        public Element(ListNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }

        @Override
        public int compareTo(Element o) {
            return this.node.val - o.node.val;
        }
    }
}


