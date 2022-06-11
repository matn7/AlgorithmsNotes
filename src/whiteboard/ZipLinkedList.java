package whiteboard;

public class ZipLinkedList {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(2);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next = new LinkedList(6);

        ZipLinkedList zip = new ZipLinkedList();
        zip.zipLinkedList(linkedList);
    }

    // O(n) time | O(1) space
    public LinkedList zipLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList first = linkedList;
        LinkedList second = linkedList;
        while (first.next != null && second.next != null) {
            first = first.next;
            second = second.next;
            if (second.next != null) {
                second = second.next;
            }
        }

        LinkedList secondHead = first.next;
        if (secondHead == null) {
            return linkedList;
        }
        first.next = null;
        first = linkedList;
        LinkedList reversedLinkedList = reverse(secondHead);

        second = reversedLinkedList;
        LinkedList anchor = first;
        LinkedList firstPrev = null;
        while (first.next != null && second.next != null) {
            firstPrev = first;
            first = first.next;
            firstPrev.next = second;
            firstPrev = second;
            second = second.next;
            firstPrev.next = first;
        }

        if (second.next == null) {
            firstPrev = first;
            first = first.next;
            firstPrev.next = second;
            second.next = first;
        }

        return anchor;
    }

    private LinkedList reverse(LinkedList head) {
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
