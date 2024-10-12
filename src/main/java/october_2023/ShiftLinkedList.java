package october_2023;

public class ShiftLinkedList {

    public static void main(String[] args) {
        Node node = new Node(0);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(5);

        int k = -2;

        Node result = shiftList(node, k);
        System.out.println();
    }

    public static Node shiftList(Node node, int k) {
        if (k == 0) {
            return node;
        }
        int length = 1;
        Node curr = node;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        Node tail = curr;

        int offset = Math.abs(k) % length;
        if (offset == 0) {
            return node;
        }
        int newTailPos = 0;
        if (k > 0) {
            newTailPos = length - offset;
        } else {
            newTailPos = offset;
        }
        curr = node;
        for (int i = 1; i < newTailPos; i++) {
            curr = curr.next;
        }
        Node newHead = curr.next;
        curr.next = null;
        tail.next = node;
        return newHead;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
