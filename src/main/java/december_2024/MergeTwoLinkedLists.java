package december_2024;

import java.util.List;

public class MergeTwoLinkedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeTwoLinkedLists mergeTwoLinkedLists = new MergeTwoLinkedLists();
        ListNode listNode = mergeTwoLinkedLists.mergeTwoLists(list1, list2);
        System.out.println(listNode);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode temp = new ListNode(0);
        if (list1.val <= list2.val) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        ListNode p1p = null;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p1p = p1;
                p1 = p1.next;
            } else {
                if (p1p != null) {
                    p1p.next = p2;
                }
                p1p = p2;
                p2 = p2.next;
                p1p.next = p1;
            }
        }
        if (p1 == null) {
            p1p.next = p2;
        }

        return temp.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
