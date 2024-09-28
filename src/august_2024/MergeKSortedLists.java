package august_2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node l3 = new Node(-3);
        l3.next = new Node(5);
        l3.next.next = new Node(9);
        l3.next.next.next = new Node(10);
        l3.next.next.next.next = new Node(11);

        List<Node> nodes = new ArrayList<>();
        nodes.add(l1);
        nodes.add(l2);
        nodes.add(l3);

        Node node = mergedList(nodes);
        System.out.println(node);
    }

    // O(nlog(k)) time | O(n) space
    public static Node mergedList(List<Node> nodes) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < nodes.size(); i++) {
            queue.add(nodes.get(i));
        }

        Node temp = new Node(0);
        Node curr = temp;

        // (0) -> (-3) ->
        //  t       c
        while (!queue.isEmpty()) {
            Node polled = queue.poll(); // (-3)
            curr.next = polled;
            curr = curr.next;

            if (polled.next != null) {
                queue.add(polled.next);
            }
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
