package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedListsV2 {

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(8);
        l2.next.next = new Node(13);

        Node l3 = new Node(4);
        l3.next = new Node(9);
        l3.next.next = new Node(11);
        l3.next.next.next = new Node(11);

        Node l4 = new Node(1);
        l4.next = new Node(6);
        l4.next.next = new Node(10);

        List<Node> nodes = new ArrayList<>();
        nodes.add(l1);
        nodes.add(l2);
        nodes.add(l3);
        nodes.add(l4);

        Node node = mergeSortedLists(nodes);
        System.out.println(node);
    }

    // O(nlog(k)) time | O(n) space
    public static Node mergeSortedLists(List<Node> nodes) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Node node : nodes) {
            queue.add(node);
        }
        Node temp = new Node(0);
        Node curr = temp;

        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            curr.next = new Node(polled.value);
            if (polled.next != null) {
                queue.add(polled.next);
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
