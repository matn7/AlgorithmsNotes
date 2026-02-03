package january_2026;

public class LinkedListIntersection {

    // O(n) time | O(1) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while (ptrA != ptrB) {

            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }

        return ptrA;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


}
