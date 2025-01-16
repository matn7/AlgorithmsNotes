package december_2024;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
//        ListNode headA = new ListNode(1);
//        headA.next = new ListNode(2);
//        headA.next.next = new ListNode(3);
//        headA.next.next.next = new ListNode(4);
//        headA.next.next.next.next = new ListNode(5);
//
//        ListNode headB = new ListNode(1);
//        headB.next = new ListNode(2);
//        headB.next.next = new ListNode(3);
//        headB.next.next.next = headA.next.next;

        ListNode headA = new ListNode(3);

        ListNode headB = new ListNode(2);
        headB.next = headA;


        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode result = intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB);
        System.out.println(result);
    }

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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        int lenA = 0;
        while (a != null) {
            lenA++;
            a = a.next;
        }
        int lenB = 0;
        while (b != null) {
            lenB++;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (lenB > lenA) {
            for (int i = 0; i < lenB - lenA; i++) {
                b = b.next;
            }
        } else {
            for (int i = 0; i < lenA - lenB; i++) {
                a = a.next;
            }
        }
        while (a != null && b != null && a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
