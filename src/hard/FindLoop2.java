package hard;

public class FindLoop2 {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(2);
        linkedList.next.next.next = new LinkedList(3);
        linkedList.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next.next = new LinkedList(6);
        linkedList.next.next.next.next.next.next.next = new LinkedList(7);
        linkedList.next.next.next.next.next.next.next.next = new LinkedList(8);
        linkedList.next.next.next.next.next.next.next.next.next = new LinkedList(9);
        linkedList.next.next.next.next.next.next.next.next.next.next = linkedList.next.next.next.next;

        findLoop(linkedList);
    }

    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList first = head;
        LinkedList second = head.next;

        if (first.equals(second)) {
            return first;
        }

        while (first != null && second.next != null) {
            if (second.next.equals(first)) {
                return first;
            }
            second = second.next;
            if (second.next.equals(first)) {
                return first;
            }
            if (second.next != null) {
                second = second.next;
            }
            if (second.next.equals(first)) {
                return first;
            }
            first = first.next;
        }
        return null;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
