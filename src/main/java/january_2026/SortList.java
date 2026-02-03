package january_2026;

import java.util.List;

public class SortList {

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3};

        SortList sortList = new SortList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        int[] result = sortList.mergeSort(nums);

        System.out.println();

        ListNode listNode = sortList.sortList(head);
        System.out.println(listNode);
    }

    // O(nlog(n)) time | O(1) space
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        return merge(sortList(dummy.next), sortList(next));
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

        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }

        return dummy.next;
    }



    public int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        int[] right = new int[nums.length - mid];
        int idx = 0;
        for (int i = mid; i < nums.length; i++) {
            right[idx] = nums[i];
            idx++;
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[k] = left[i];
                i++;
            } else {
                res[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            res[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            res[k] = right[j];
            j++;
            k++;
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
