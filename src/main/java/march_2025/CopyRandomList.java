package march_2025;

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
    }
    
    public Node copyRandomList(Node head) {
        Map<Node, Node> originalToNewMap = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            originalToNewMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node originalNext = curr.next;
            Node originalRandom = curr.random;

            Node newNode = originalToNewMap.get(curr);
            Node newNext = originalToNewMap.get(originalNext);
            Node newRandom = originalToNewMap.get(originalRandom);
            newNode.next = newNext;
            newNode.random = newRandom;

            curr = curr.next;
        }

        return originalToNewMap.get(head);
    }
    
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}
