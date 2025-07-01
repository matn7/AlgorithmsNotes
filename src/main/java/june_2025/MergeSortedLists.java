package june_2025;

public class MergeSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(6);
        

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeSortedLists mergeSortedLists = new MergeSortedLists();
        ListNode listNode = mergeSortedLists.mergeTwoLists(list1, list2);
        System.out.println(listNode);
    }

    // O(n) time | O(1) space
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        helper(dummy, list1, list2);
        return dummy.next;
    }

    private void helper(ListNode curr, ListNode list1, ListNode list2) {
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
        helper(curr, list1, list2);
    }

    // O(n) time | O(1) space
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list2 == null) {
            curr.next = list1;
        }
        if (list1 == null) {
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
