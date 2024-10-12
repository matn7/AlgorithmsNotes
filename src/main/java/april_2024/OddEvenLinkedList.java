package april_2024;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.next = new Node(2);
        node.next.next = new Node(1);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
    }

    // O(n) time | O(1) space
    public static Node oddEvenList(Node head) {
        if (head == null) {
            return null;
        }
        Node odd = head;
        Node even = odd.next;
        Node evenList = odd.next;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenList;
        return head;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
