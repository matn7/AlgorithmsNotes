package november_2025;

public class IntersectionOfTwoLinkedLists {

    // O(n) time | O(1) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            currA = currA != null ? currA.next : headB;
            currB = currB != null ? currB.next : headA;
        }
        return currA;
    }

    // O(n + m) time | O(1) space
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if (lenA > lenB) {
            while (lenA != lenB) {
                lenA--;
                currA = currA.next;
            }
        } else {
            while (lenB != lenA) {
                lenB--;
                currB = currB.next;
            }
        }

        while (currA != null && currB != null && currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
