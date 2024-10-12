package september_2024;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(5);
        node.next.next = new Node(1);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next.next.next = new Node(1);

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        Node result = removeDuplicates.removeDuplicates(node);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public Node removeDuplicates(Node node) {
        //      1 -> 5 -> 1 -> 4 -> 3 -> 4 -> 4 -> 5 -> 1
        // p

        Node prev = null;
        Node curr = node;
        Set<Integer> seen = new HashSet<>();
        while (curr != null) {
            while (curr != null && seen.contains(curr.value)) {
                curr = curr.next;
            }
            if (curr == null) {
                prev.next = null;
                break;
            }
            seen.add(curr.value);
            if (prev == null) {
                prev = curr;
            } else {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
            System.out.println();
        }

        return node;
    }

    // Book
    void deleteDups(Node n) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;

        while (n != null) {
            if (set.contains(n.value)) {
                previous.next = n.next;
            } else {
                set.add(n.value);
                previous = n;
            }
            n = n.next;
        }
    }

    void deleteDups2(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
