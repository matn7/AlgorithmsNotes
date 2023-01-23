package udemy.faang.leetcode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
//        ListNode list1 = new ListNode(2);
//        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(4);
//        list1.next.next.next = new ListNode(24);
//        list1.next.next.next.next = new ListNode(224);
//
//        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(3);
//        list2.next.next = new ListNode(4);
//        list2.next.next.next = new ListNode(8);
//        list2.next.next.next.next = new ListNode(9);

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);


        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        mergeTwoSortedLists.mergeTwoLists(list1, list2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p1p = null;

        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                System.out.println();
                if (p1p == null) {
                    p1p = p2;
                    p2 = p2.next;
                    p1p.next = p1;
                } else {
                    p1p.next = p2;
                    p1p = p2;
                    p2 = p2.next;
                    p1p.next = p1;
                }
            } else {
                System.out.println();
                p1p = p1;
                p1 = p1.next;
            }
        }
        if (p1 == null) {
            p1p.next = p2;
        }

        if (list1.val <= list2.val) {
            return list1;
        }

        return list2;

    }

}
