package coderpro;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists2 {

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        Node list3 = new Node(5);
        list3.next = new Node(9);
        list3.next.next = new Node(11);
        list3.next.next.next = new Node(11);
        list3.next.next.next.next = new Node(11);
        list3.next.next.next.next.next = new Node(18);

        List<Node> sortedLists = new ArrayList<>();
        sortedLists.add(list1);
        sortedLists.add(list2);
        sortedLists.add(list3);

        MergeKSortedLinkedLists2 mergeKSortedLinkedLists2 = new MergeKSortedLinkedLists2();
        Node result = mergeKSortedLinkedLists2.mergeKSorted(sortedLists);

        Node curr = result;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
    }

    public Node mergeKSorted(List<Node> sortedLists) {
        if (sortedLists.isEmpty()) {
            return null;
        }
        Node temp = new Node(0);
        Node curr = temp;

        PriorityQueue<NodeInfo> queue = new PriorityQueue<>();

        for (int i = 0; i < sortedLists.size(); i++) {
            queue.add(new NodeInfo(i, sortedLists.get(i)));
        }

        while (!queue.isEmpty()) {
            NodeInfo info = queue.poll();
            int index = info.listIdx;
            Node node = info.node;
            curr.next = new Node(node.val);

            if (node.next != null) {
                node = node.next;
                queue.add(new NodeInfo(index, node));
            }
            curr = curr.next;
        }

        return temp.next;
    }

    static class NodeInfo implements Comparable<NodeInfo> {
        int listIdx;
        Node node;

        public NodeInfo(int listIdx, Node node) {
            this.listIdx = listIdx;
            this.node = node;
        }

        @Override
        public int compareTo(NodeInfo o) {
            return node.val - o.node.val;
        }
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
