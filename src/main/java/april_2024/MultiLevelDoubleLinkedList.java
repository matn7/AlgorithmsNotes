package april_2024;

import java.util.Stack;

public class MultiLevelDoubleLinkedList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node2.child = node4;
        node3.prev = node2;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node5.child = node7;
        node6.prev = node5;

        Node result = multiLevelDoublyLinkedList(node1);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static Node multiLevelDoublyLinkedList(Node head) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                curr.child.prev = curr;
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.child = null;
            }
            if (curr.next == null && !stack.isEmpty()) {
                Node top = stack.pop();
                curr.next = top;
                top.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    static class Node {
        int value;
        Node next;
        Node prev;
        Node child;

        public Node(int value) {
            this.value = value;
        }
    }

}
