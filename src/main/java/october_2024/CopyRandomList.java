package october_2024;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public static void main(String[] args) {
        Node node7 = new Node(7, null, null);
        Node node13 = new Node(13, null, null);
        Node node11 = new Node(11, null, null);
        Node node10 = new Node(10, null, null);
        Node node1 = new Node(1, null, null);

        node7.next = node13;
        node7.random = null;
        node13.next = node11;
        node13.random = node7;
        node11.next = node10;
        node10.random = node11;
        node10.next = node1;
        node1.next = null;
        node1.random = node7;

        CopyRandomList copyRandomList = new CopyRandomList();
        Node node = copyRandomList.copyRandomList(node7);
        System.out.println();
    }

    // O(n) time | O(n) space
    public Node copyRandomList(Node head) {
        Map<Node, Node> listMap = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val, null, null);
            listMap.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node newNode = listMap.get(curr);
            Node currNext = curr.next;
            Node currRandom = curr.random;

            Node newNodeNext = listMap.get(currNext);
            Node newNodeRandom = listMap.get(currRandom);

            newNode.next = newNodeNext;
            newNode.random = newNodeRandom;
            curr = curr.next;
        }

        return listMap.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

}
