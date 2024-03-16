package november_2023;

public class RemoveDuplicatesFromLinkedList {

    public static void main(String[] args) {
        LinkedList node = new LinkedList(1);
        node.next = new LinkedList(1);
        node.next.next = new LinkedList(3);
        node.next.next.next = new LinkedList(4);
        node.next.next.next.next = new LinkedList(4);
        node.next.next.next.next.next = new LinkedList(4);
        node.next.next.next.next.next.next = new LinkedList(5);
        node.next.next.next.next.next.next.next = new LinkedList(6);
        node.next.next.next.next.next.next.next.next = new LinkedList(6);

        LinkedList result = removeDuplicatesFromLinkedList(node);
        System.out.println();
    }

    // O(n) time | O(1) space
    public static LinkedList removeDuplicatesFromLinkedList(LinkedList node) {
        if (node == null || node.next == null) {
            return node;
        }

        LinkedList first = node;
        LinkedList second = node;
        while (second != null) {
            while (second != null && first.value == second.value) {
                second = second.next;
            }
            first.next = second;
            if (second == null) {
                break;
            }
            first = second;
            second = second.next;
        }
        return node;
    }


    static class LinkedList {
        int value;
        LinkedList next;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
