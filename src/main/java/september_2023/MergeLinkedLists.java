package september_2023;

public class MergeLinkedLists {

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

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(n) time | O(1) space
    public static LinkedList mergeLinkedLists(
            LinkedList headOne, LinkedList headTwo
    ) {
        // Write your code here.
        //      2 -> 6 -> 7 -> 8                    curr1
        //      *
        //      1 -> 3 -> 4 -> 5 -> 9 -> 10         curr2
        //      *
        //
        //
        LinkedList p1p = null;
        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;


        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p1p = p1;
                p1 = p1.next;
            } else {
                 if (p1p == null) {
                     p1p = p2;
                     p2 = p2.next;
                     p1p.next = p1;
                 } else {
                     p1p.next = p2;
                     p1p = p2;
                     p2 = p2.next;
                     p1p.next = p1;
                 }
            }
        }
        if (p1 == null) {
            p1p.next = p2;
        }

        if (headOne.value < headTwo.value) {
            return headOne;
        }

        return headTwo;
    }

}
