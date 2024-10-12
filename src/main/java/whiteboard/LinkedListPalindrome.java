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

    // O(n) time | O(n) space
    public boolean linkedListPalindrome2(LinkedList head) {
        // Write your code here.
        LinkedListInfo isPalindromeResult = isPalindrome(head, head);
        return isPalindromeResult.outerNodesAreEqual;
    }

    private LinkedListInfo isPalindrome(LinkedList leftNode, LinkedList rightNode) {
        if (rightNode == null) {
            return new LinkedListInfo(true, leftNode);
        }

        LinkedListInfo recursiveCallResults = isPalindrome(leftNode, rightNode.next);
        LinkedList leftNodeToCompare = recursiveCallResults.leftNodeToCompare;
        boolean outerNodesAreEqual = recursiveCallResults.outerNodesAreEqual;

        boolean recursiveIsEqual = outerNodesAreEqual && leftNodeToCompare.value == rightNode.value;
        LinkedList nextLeftNodeToCompare = leftNodeToCompare.next;

        return new LinkedListInfo(recursiveIsEqual, nextLeftNodeToCompare);
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
