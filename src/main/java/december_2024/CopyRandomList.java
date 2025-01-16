package december_2024;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {


    public Node copyRandomList(Node head) {

        Map<Node, Node> oldNewNodesMap = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            oldNewNodesMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node oldRandom = curr.random;
            Node oldNext = curr.next;

            Node newCurr = oldNewNodesMap.get(curr);
            Node newRandom = oldNewNodesMap.get(oldRandom);
            Node newNext = oldNewNodesMap.get(oldNext);
            newCurr.random = newRandom;
            newCurr.next = newNext;

            curr = curr.next;
        }
        return oldNewNodesMap.get(head);
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
