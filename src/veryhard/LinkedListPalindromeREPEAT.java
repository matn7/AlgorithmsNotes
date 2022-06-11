package veryhard;

public class LinkedListPalindromeREPEAT {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //                      s                   f
    // 0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0

//    // O(n) time | O(1) space
//    public boolean linkedListPalindrome(LinkedList head) {
//        LinkedList slowNode = head;
//        LinkedList fastNode = head;
//
//        while (fastNode != null && fastNode.next != null) {
//            slowNode = slowNode.next;
//            fastNode = fastNode.next.next;
//        }
//
//        // rec(2 ---> 1 ---> 0)
//        LinkedList reversedSecondHalfNode = reverseLinkedList(slowNode);
//        LinkedList firstHalfNode = head;
//
//        // s
//        //   <--- 2 <--- 1 <--- 0
//        // 0 ---> 1 ---> 2 --->
//        //                      f
//        while (reversedSecondHalfNode != null) {
//            if (reversedSecondHalfNode.value != firstHalfNode.value) {
//                return false;
//            }
//            reversedSecondHalfNode = reversedSecondHalfNode.next;
//            firstHalfNode = firstHalfNode.next;
//        }
//        return true;
//    }
//
//    // rec(2 ---> 1 ---> 0)
//    //                    p      c
//    // <--- 2 <--- 1 <--- 0
//    private LinkedList reverseLinkedList(LinkedList head) {
//        LinkedList previousNode = null;
//        LinkedList currentNode = head;
//        while (currentNode != null) {
//            LinkedList nextNode = currentNode.next;
//            currentNode.next = previousNode;
//            previousNode = currentNode;
//            currentNode = nextNode;
//        }
//        return previousNode;
//    }

    // OK - repeated 24/02/2022
    // O(n) time | O(n) space
    public boolean linkedListPalindrome(LinkedList head) {
        // Write your code here.
        LinkedListInfo isPalindromeResult = isPalindrome(head, head);
        return isPalindromeResult.outerNodesAreEqual; // true
    }

    // rec(0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0, null) => (true, 0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0)
    // rec(0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0, 0) => (true, 1 ---> 2 ---> 2 ---> 1 ---> 0)
    // rec(0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0, 1 ---> 0) => (true, 2 ---> 2 ---> 1 ---> 0)
    // rec(0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0, 2 ---> 1 ---> 0) => (true, 2 ---> 1 ---> 0)
    // rec(0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0, 2 ---> 2 ---> 1 ---> 0) => (true, 1 ---> 0)
    // rec(0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0, 1 ---> 2 ---> 2 ---> 1 ---> 0) => (true, 0)
    // rec(0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0, 0 ---> 1 ---> 2 ---> 2 ---> 1 ---> 0) => (true, null)
    private LinkedListInfo isPalindrome(LinkedList leftNode, LinkedList rightNode) {
        if (rightNode == null) {
            return new LinkedListInfo(true, leftNode);
        }

        LinkedListInfo recursiveCallResults = isPalindrome(leftNode, rightNode.next);
        //        *
        // (true, 0)
        LinkedList leftNodeToCompare = recursiveCallResults.leftNodeToCompare; // 0
        boolean outerNodesAreEqual = recursiveCallResults.outerNodesAreEqual; // true

        boolean recursiveIsEqual = outerNodesAreEqual && leftNodeToCompare.value == rightNode.value; // true && 0 == 0
        LinkedList nextLeftNodeToCompare = leftNodeToCompare.next; // null

        return new LinkedListInfo(recursiveIsEqual, nextLeftNodeToCompare); // (true, null)
    }

    static class LinkedListInfo {
        boolean outerNodesAreEqual;
        LinkedList leftNodeToCompare;

        public LinkedListInfo(boolean outerNodesAreEqual, LinkedList leftNodeToCompare) {
            this.outerNodesAreEqual = outerNodesAreEqual;
            this.leftNodeToCompare = leftNodeToCompare;
        }
    }
}
