package october_2023;

public class RemoveDuplicatesFromLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next.next.next = new Node(6);

        Node node1 = removeDuplicates(node);
        while (node1 != null) {
            System.out.print(node1.value + " -> ");
            node1 = node1.next;
        }
    }

    // O(n) time | O(1) space
    public static Node removeDuplicates(Node node) {
        Node first = node;
        Node second = node;

        // 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 ->

        //                      f
        // 1 ->  3 -> 4 -> 5 -> 6 -> 6 ->
        //                                s
        while (second != null) {
            while (second != null && second.value == first.value) {
                second = second.next;
            }
            first.next = second;
            first = second;
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
