package july_2024;

public class MNReversal {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node node = reverseBetween(head, 2, 4);
        System.out.println(node);

    }

    // O(n) time | O(1) space
    public static Node reverseBetween(Node head, int m, int n) {
        int currentPos = 1;
        Node currentNode = head;
        Node start = head;
        while (currentPos < m) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPos++;
        }
        Node newList = null;
        Node tail = currentNode;
        while (currentPos >= m && currentPos <= n) {
            Node next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPos++;
        }
        start.next = newList;
        tail.next = currentNode;
        if (m > 1) {
            return head;
        }
        return newList;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
