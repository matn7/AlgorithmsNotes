package coderpro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        List<ListNode> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);

        MergeKSortedLinkedLists merge = new MergeKSortedLinkedLists();
        merge.merge(lists);
    }

    // ********
    // * STAR *
    // ********

    // O(klog(n)) time | O(n) space
    public ListNode merge(List<ListNode> lists) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        PriorityQueue<Elem> queue = new PriorityQueue<Elem>();
        for (int i = 0; i < lists.size(); i++) {
            queue.add(new Elem(lists.get(i)));
        }

        while (!queue.isEmpty()) {
            Elem currMin = queue.poll();
            ListNode currNode = currMin.node;
            curr.next = currNode;
            if (currNode.next != null) {
                currNode = currNode.next;
                queue.add(new Elem(currNode));
            }

            curr = curr.next;
        }

        return head.next;
    }

    // O(nlog(n)) time | O(n) space
    public ListNode mergeBruteForce(List<ListNode> lists) {
        List<Integer> arr = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                arr.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(arr);
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        for (Integer elem : arr) {
            curr.next = new ListNode(elem);
            curr = curr.next;
        }
        return temp.next;
    }

}

class Elem implements Comparable<Elem> {
    ListNode node;

    public Elem(ListNode node) {
        this.node = node;
    }

    @Override
    public int compareTo(Elem o) {
        return this.node.val - o.node.val;
    }
}