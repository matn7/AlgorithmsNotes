package december_2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        SortLinkedList sortLinkedList = new SortLinkedList();
        ListNode listNode = sortLinkedList.sortList(head);
        System.out.println(listNode);
    }

    // O(nlog(n)) time | O(n) space
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(secondHalf));
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(-1);
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

    // O(n log(n)) time | O(n) space
    public ListNode sortList2(ListNode head) {
        List<Integer> elements = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            elements.add(curr.val);
            curr = curr.next;
        }
//        quickSort(elements);
        Collections.sort(elements);
        ListNode dummy = new ListNode(-1);
        curr = dummy;
        for (int num : elements) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;
    }

    private void quickSort(List<Integer> array) {
        sort(array, 0, array.size() - 1);
    }

    private void sort(List<Integer> array, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (array.get(s) >= array.get(pivot) && array.get(e) <= array.get(pivot)) {
                swap(array, s, e);
            }
            if (array.get(s) <= array.get(pivot)) {
                s++;
            }
            if (array.get(e) >= array.get(pivot)) {
                e--;
            }
        }
        swap(array, pivot, e);

        // start ------------*------ end
        //                   e
        if (e - 1 - start > end - (e + 1)) {
            sort(array, start, e - 1);
            sort(array, e + 1, end);
        } else {
            sort(array, e + 1, end);
            sort(array, start, e - 1);
        }
    }

    private void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
