package april_2025;

public class IntersectionNode {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        IntersectionNode intersectionNode = new IntersectionNode();
        ListNode result = intersectionNode.getIntersectionNode(headA, headB);
        System.out.println(result.val);
    }

    // O(n) time | O(n) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode currA = headA;
        while (currA != null) {
            currA = currA.next;
            lenA++;
        }
        ListNode currB = headB;
        while (currB != null) {
            currB = currB.next;
            lenB++;
        }
        currA = headA;
        currB = headB;
        if (lenA > lenB) {
            while (lenA > lenB && currA != null) {
                lenA--;
                currA = currA.next;
            }
        } else if (lenB > lenA) {
            while (lenB > lenA && currB != null) {
                lenB--;
                currB = currB.next;
            }
        }
        while ((currA != null && currB != null) || lenA > 0) {
            if (currA == currB) {
                return currA;
            }
            if (currA == null || currB == null) {
                return null;
            }
            currA = currA.next;
            currB = currB.next;
            lenA--;
        }
        if (lenA < 0) {
            return null;
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
