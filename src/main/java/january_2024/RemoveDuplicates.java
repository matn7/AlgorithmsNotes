package january_2024;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(3);

        Node result = removeDuplicates(node);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public static Node removeDuplicates(Node node) {
        Node curr = node;
        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return node;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
