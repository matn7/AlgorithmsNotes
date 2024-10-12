package whiteboard;

public class RemoveDuplicatesFromLinkedList {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(n) time | O(1) space
    // rang: 15/07/2022
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList first = linkedList;
        while (first != null) {
            LinkedList second = first.next;
            while (second != null && second.value == first.value) {
                second = second.next;
            }
            first.next = second;
            first = second;
        }
        return linkedList;
    }

}
