package whiteboard;

public class LinkedListPalindrome {

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
    // #2: 02/07/2022
    public boolean linkedListPalindrome(LinkedList head) {
        // Write your code here.
        if (head.next == null) {
            return true;
        }
        LinkedList first = head;
        LinkedList second = first.next;

        while (second.next != null) {
            first = first.next;
            second = second.next;
            if (second.next != null) {
                second = second.next;
            }
        }
        LinkedList secondHead = first.next;
        first.next = null;

        LinkedList reversed = reverseLinkedList(secondHead);

        first = head;

        while (first != null && reversed != null) {
            if (first.value != reversed.value) {
                return false;
            }
            first = first.next;
            reversed = reversed.next;
        }
        return true;
    }

    private LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prev = null;
        LinkedList curr = head;
        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
