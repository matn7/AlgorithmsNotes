package september_2023;

public class LinkedListPalindrome {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(0);

        LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome();
        linkedListPalindrome.linkedListPalindrome(head);
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

    // O(n) time | O(n) space
    public boolean linkedListPalindrome(LinkedList head) {
        LinkedListInfo isPalindromeResults = isPalindrome(head, head);
        return isPalindromeResults.outerNodesAreEqual;
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

    // O(n) time | O(1) space
    public boolean linkedListPalindrome2(LinkedList head) {
        // Write your code here.
        // 0 -> 1 -> 2     0 -> 1 -> 2
        // s               nH
        LinkedList slow = head;
        LinkedList fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList reversed = reverse(slow);
        LinkedList firstHalf = head;
        while (reversed != null) {
            if (firstHalf.value != reversed.value) {
                return false;
            }
            firstHalf = firstHalf.next;
            reversed = reversed.next;
        }
        return true;
    }
    private LinkedList reverse(LinkedList node) {
        //   <- 2 <- 1    0
        //           p    c
        LinkedList prev = null;
        LinkedList curr = node;
        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
