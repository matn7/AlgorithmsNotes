package june_2025;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node7.random = null;

        node13.next = node11;
        node13.random = node7;

        node11.next = node10;
        node11.random = node1;

        node10.next = node1;
        node10.random = node11;

        node1.next = null;
        node1.random = node7;

        CopyRandomList copyRandomList = new CopyRandomList();
        copyRandomList.copyRandomList(node7);
    }

    // O(n) time | O(n) space
    public Node copyRandomList(Node head) {
        Map<Node, Node> origToNew = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            origToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node currNext = curr.next;
            Node currRandom = curr.random;

            Node newNode = origToNew.get(curr);
            Node newNodeNext = origToNew.get(currNext);
            Node newNodeRandom = origToNew.get(currRandom);

            newNode.next = newNodeNext;
            newNode.random = newNodeRandom;

            curr = curr.next;
        }

        return origToNew.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

}
