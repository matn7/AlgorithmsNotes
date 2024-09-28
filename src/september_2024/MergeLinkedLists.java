package september_2024;

public class MergeLinkedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(6);

        MergeLinkedLists mergeLinkedLists = new MergeLinkedLists();
        ListNode result = mergeLinkedLists.mergeTwoLists(list1, list2);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //      p1p
        //      1 -> 2 -> 4
        //           p1
        //      1 -> 3 -> 4
        //      p2
        ListNode p1p = null;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p1p = p1;
                p1 = p1.next;
            } else {
                if (p1p == null) {
                    p1p = p2;
                } else {
                    p1p.next = p2;
                    p1p = p2;
                }
                p2 = p2.next;
                p1p.next = p1;
            }
        }
        if (p2 != null) {
            p1p.next = p2;
        }

        return list1.val <= list2.val ? list1 : list2;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
