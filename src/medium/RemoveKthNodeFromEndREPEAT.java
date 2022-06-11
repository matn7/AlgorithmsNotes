package medium;

public class RemoveKthNodeFromEndREPEAT {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next.next = new LinkedList(7);
        head.next.next.next.next.next.next.next.next = new LinkedList(8);
        head.next.next.next.next.next.next.next.next.next = new LinkedList(9);

        removeKthNodeFromEnd(head, 4);
        System.out.println();
    }
    // k = 4
    //                          f                   s
    // 0 -> 1 -> 2 -> 3 -> 4 -> 5 ------> 7 -> 8 -> 9

    // k = 10
    // f                                               s
    // 1 ------> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    // O(n) time | O(1) space
    // OK - repeated 12/02/2022
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList first = head;
        LinkedList second = head;
        int counter = 0;
        // second pointer k node ahead first
        while (second != null && counter < k) {
            second = second.next;
            counter++; // 1
        }
        if (second == null) {
            // update head of the list
            head.value = head.next.value; // overwrites head value
            head.next = head.next.next;
            return;
        }
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
