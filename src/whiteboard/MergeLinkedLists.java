package whiteboard;

public class MergeLinkedLists {

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList headOne = new LinkedList(2);
        headOne.next = new LinkedList(6);
        headOne.next.next = new LinkedList(7);
        headOne.next.next.next = new LinkedList(8);

        LinkedList headTwo = new LinkedList(1);
        headTwo.next = new LinkedList(3);
        headTwo.next.next = new LinkedList(4);
        headTwo.next.next.next = new LinkedList(5);
        headTwo.next.next.next.next = new LinkedList(9);
        headTwo.next.next.next.next.next = new LinkedList(10);

        mergeLinkedLists(headOne, headTwo);
    }

    // O(n + m) time | O(1) space
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList first = headOne;
        LinkedList second = headTwo;
        LinkedList firstPrev = null;

        while (first != null && second != null) {
            if (first.value < second.value) {
                firstPrev = first;
                first = first.next;
            } else {
                if (firstPrev == null) {
                    firstPrev = second;
                    second = second.next;
                    firstPrev.next = first;
                } else {
                    firstPrev.next = second;
                    firstPrev = second;
                    second = second.next;
                    firstPrev.next = first;
                }
            }
        }
        if (first == null) {
            firstPrev.next = second;
        }

        if (headOne.value < headTwo.value) {
            return headOne;
        }
        return headTwo;
    }

}
