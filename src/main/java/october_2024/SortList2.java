package october_2024;

public class SortList2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        SortList2 sortList = new SortList2();

        ListNode listNode = sortList.sortList(head);
        System.out.println(listNode);
    }

    // O(nlog(n)) time | O(log(n)) space
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode curr = node;
        ListNode slow = curr;
        ListNode fast = curr.next;

        if (fast == null) {
            return slow;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = node;
        ListNode right = slow.next;
        slow.next = null;

        return merge(mergeSort(left), mergeSort(right));
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        while (left != null) {
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }
        while (right != null) {
            curr.next = right;
            right = right.next;
            curr = curr.next;
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
