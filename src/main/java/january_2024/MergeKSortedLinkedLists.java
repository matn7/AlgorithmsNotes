package january_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(5);

        Node node2 = new Node(2);
        node2.next = new Node(4);
        node2.next.next = new Node(6);

        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);

        mergeLinkedList(nodes);
    }

    // O(nlog(k)) time | O(k) space
    public static Node mergeLinkedList(List<Node> nodes) {
        Node temp = new Node(0);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Node node : nodes) {
            queue.add(node);
        }
        Node curr = temp;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            curr.next = poll;
            if (poll.next != null) {
                queue.add(poll.next);
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
            return value - o.value;
        }
    }

}
