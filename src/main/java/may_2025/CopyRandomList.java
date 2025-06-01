package may_2025;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    // O(n) time | O(n) space
    public Node copyRandomList(Node head) {
        Map<Node, Node> newNodes = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            newNodes.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node newCurr = newNodes.get(curr);
            Node newNext = newNodes.get(curr.next);
            Node newRandom = newNodes.get(curr.random);

            newCurr.next = newNext;
            newCurr.random = newRandom;

            curr = curr.next;
        }
        return newNodes.get(head);
    }

    static class Node {
        int val;
        Node random;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
