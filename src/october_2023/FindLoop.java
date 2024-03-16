package october_2023;

import java.util.HashMap;
import java.util.Map;

public class FindLoop {

    public static void main(String[] args) {
        Node node = new Node(0);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next.next.next.next.next = node.next.next.next.next;

        Node loop = findLoop(node);
        System.out.println(loop.val);
    }

    // O(n) time | O(1) space
    public static Node findLoop(Node node) {

        Node fast = node.next;
        Node slow = node;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        slow = node;
        while (fast.next != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // O(n) time | O(n) space
    public static Node findLoop2(Node node) {
        Map<Node, Boolean> seen = new HashMap<>();
        Node curr = node;
        while (curr != null) {
            if (seen.containsKey(curr)) {
                return curr;
            }
            seen.put(curr, Boolean.TRUE);
            curr = curr.next;
        }
        return null;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
