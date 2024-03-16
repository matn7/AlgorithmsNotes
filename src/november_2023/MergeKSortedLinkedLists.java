package november_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(3);
        a.next.next = new Node(5);

        Node b = new Node(2);
        b.next = new Node(4);
        b.next.next = new Node(6);

        Node c = new Node(5);
        c.next = new Node(9);
        c.next.next = new Node(11);
        c.next.next.next = new Node(13);

        List<Node> lists = new ArrayList<>();
        lists.add(a);
        lists.add(b);
        lists.add(c);

        Node merge = merge(lists);

        while (merge != null) {
            System.out.print(merge.value + " -> ");
            merge = merge.next;
        }
    }

    // O(nlog(k)) time | O(k) space
    public static Node merge(List<Node> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Node temp = new Node(0);
        Node curr = temp;
        for (Node list : lists) {
            queue.add(list);
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            curr.next = poll;
            if (poll.next != null) {
                poll = poll.next;
                queue.add(poll);
            }
            curr = curr.next;
        }

        return temp.next;
    }


    static class Node implements Comparable<Node> {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

}
