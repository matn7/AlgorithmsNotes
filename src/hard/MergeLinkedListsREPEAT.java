package hard;

public class MergeLinkedListsREPEAT {


    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(2);
        list1.next = new LinkedList(6);
        list1.next.next = new LinkedList(7);
        list1.next.next.next = new LinkedList(8);

        LinkedList list2 = new LinkedList(1);
        list2.next = new LinkedList(3);
        list2.next.next = new LinkedList(4);
        list2.next.next.next = new LinkedList(5);
        list2.next.next.next.next = new LinkedList(9);
        list2.next.next.next.next.next = new LinkedList(10);

        mergeLinkedLists(list1, list2);
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

    // O(n + m) time | O(n + m) space
    // OK - repeated 01/02/2022
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.

        recursiveMerge(headOne, headTwo, null);

        if (headOne.value < headTwo.value) {
            return headOne;
        }
        return headTwo;
    }

    //                    p1p
    //                         p1
    //      2    6 -> 7 -> 8
    //      | \    \------   \
    //      |  \          \   \
    //      1    3 -> 4 -> 5    9 -> 10
    //                          p2
    //
    private static void recursiveMerge(LinkedList p1, LinkedList p2, LinkedList p1Prev) {
        if (p1 == null) {
            p1Prev.next = p2;
            return;
        }
        if (p2 == null) {
            return;
        }

        if (p1.value < p2.value) {
            recursiveMerge(p1.next, p2, p1); // rec(6, 3, 2)
        } else {
            if (p1Prev != null) {
                p1Prev.next = p2;
            }
            LinkedList newP2 = p2.next;
            p2.next = p1;
            recursiveMerge(p1, newP2, p2); // rec(6, 5, 4)
                                           //    p1,p2,p1p
        }
    }

//    // O(n + m) time | O(1) space
//    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
//        // headOne = 2 -> 6 -> 7 -> 8
//        // headTwo = 1 -> 3 -> 4 -> 5 -> 9 -> 10
//        // Write your code here.
//        LinkedList p1 = headOne;
//        LinkedList p1Prev = null;
//        LinkedList p2 = headTwo;
//
//        // p1 = 2
//        // p1Prev = null
//        // p2 = 1
//        //                         p1p
//        //                              p1
//        //          2    6 -> 7 -> 8----+
//        //          | \    \-------     |
//        //          |  \           \    V
//        //          1    3 -> 4 -> 5    9 -> 10
//        //                              p2
//        //
//        while (p1 != null && p2 != null) {
//            if (p1.value < p2.value) {
//                p1Prev = p1;
//                p1 = p1.next;
//            } else {
//                if (p1Prev != null) {
//                    p1Prev.next = p2;
//                }
//                p1Prev = p2;
//                p2 = p2.next;
//                p1Prev.next = p1;
//            }
//        }
//        if (p1 == null) {
//            p1Prev.next = p2;
//        }
//        if (headOne.value < headTwo.value) {
//            return headOne;
//        }
//        return headTwo;
//    }

}
