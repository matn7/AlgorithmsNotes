package veryhard;

public class LinkedListPalindrome {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(0);

        LinkedListPalindrome listPalindrome = new LinkedListPalindrome();
        listPalindrome.linkedListPalindrome(head);
    }

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
        LinkedList slowNode = head;
        LinkedList fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        LinkedList reversedSecondHalfNode = reverseLinkedList(slowNode);
        LinkedList firstHalfNode = head;

        while (reversedSecondHalfNode != null) {
            if (reversedSecondHalfNode.value != firstHalfNode.value) {
                return false;
            }
            reversedSecondHalfNode = reversedSecondHalfNode.next;
            firstHalfNode = firstHalfNode.next;
        }
        return true;
    }

    private LinkedList reverseLinkedList(LinkedList head) {
        LinkedList previoudNode = null;
        LinkedList currentNode = head;

        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = previoudNode;
            previoudNode = currentNode;
            currentNode = nextNode;
        }
        return previoudNode;
    }

    // O(n) time | O(n) space
    public boolean linkedListPalindrome2(LinkedList head) {
        // Write your code here.
        LinkedListInfo isPalindromeResults = isPalindrome(head, head);
        return isPalindromeResults.outerNodesAreEqual;
    }

    public LinkedListInfo isPalindrome(LinkedList leftNode, LinkedList rightNode) {
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
