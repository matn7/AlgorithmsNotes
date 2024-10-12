package july_2024;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.setNext(new Node(2));
        node.getNext().setNext(new Node(1));
        node.getNext().getNext().setNext(new Node(3));
        node.getNext().getNext().getNext().setNext(new Node(4));

        oddEventList(node);
    }

    // O(n) time | O(1) space
    public static Node oddEventList(Node head) {
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

    static final class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
