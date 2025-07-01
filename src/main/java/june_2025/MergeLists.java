package june_2025;

public class MergeLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeLists mergeLists = new MergeLists();
        ListNode result = mergeLists.mergeTwoLists(list1, list2);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        merge(list1, list2, curr);

        return dummy.next;
    }

    private void merge(ListNode list1, ListNode list2, ListNode curr) {
        if (list1 == null && list2 == null) {
            return;
        }
        if (list1 == null) {
            curr.next = list2;
            return;
        }
        if (list2 == null) {
            curr.next = list1;
            return;

        }
        if (list1.val <= list2.val) {
            curr.next = list1;
            list1 = list1.next;
        } else {
            curr.next = list2;
            list2 = list2.next;
        }
        curr = curr.next;
        merge(list1, list2, curr);
    }


    public ListNode mergeTwoListsIter(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
//                curr.next = new ListNode(list1.val);
                curr.next = list1;
                list1 = list1.next;
            } else {
//                curr.next = new ListNode(list2.val);
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
