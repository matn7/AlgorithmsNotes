package november_2023;

import java.util.HashMap;
import java.util.Map;

public class FindLoopV2 {

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next.next;

        Node loop = findLoop(head);
        System.out.println(loop);
    }

    public static Node findLoop(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        while (slow != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // O(n) time | O(n) space
    public static Node findLoopV2(Node head) {
        Map<Node, Boolean> seen = new HashMap<>();

        Node curr = head;
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
