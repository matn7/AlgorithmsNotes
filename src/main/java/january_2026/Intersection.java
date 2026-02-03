package january_2026;

public class Intersection {

    // O(n) time | O(1) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2) {
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l1 = headB;
            }
            if (l2 != null) {
                l2 = l2.next;
            } else {
                l2 = headA;
            }
        }

        return l1;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
