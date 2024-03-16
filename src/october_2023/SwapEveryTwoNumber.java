package october_2023;

public class SwapEveryTwoNumber {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        swap(node);

    }

    // O(n) time | O(1) space
    public static Node swap(Node node) {
        Node curr = node;
        while (curr != null && curr.next != null) {
            int temp = curr.val;
            curr.val = curr.next.val;
            curr.next.val = temp;
            curr = curr.next.next;
        }

        return node;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
