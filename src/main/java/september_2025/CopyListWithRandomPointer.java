package september_2025;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    // O(n) time | O(n) space
    public Node copyRandomList(Node head) {
        Map<Node, Node> origToNewMap = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            origToNewMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node currRandom = curr.random;
            Node currNext = curr.next;

            Node copy = origToNewMap.get(curr);
            Node copyRandom = origToNewMap.get(currRandom);
            Node copyNext = origToNewMap.get(currNext);

            copy.random = copyRandom;
            copy.next = copyNext;

            curr = curr.next;
        }
        return origToNewMap.get(head);
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
