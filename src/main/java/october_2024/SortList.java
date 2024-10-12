package october_2024;

import java.util.ArrayList;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        SortList sortList = new SortList();

        ListNode listNode = sortList.sortList(head);
        System.out.println(listNode);
    }

    // O(nlog(n)) time | O(log(n)) space
    public ListNode sortList(ListNode head) {
        List<Integer> array = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            array.add(curr.val);
            curr = curr.next;
        }

        List<Integer> sorted = mergeSort(array);
        ListNode dummy = new ListNode(0);
        curr = dummy;

        for (Integer element : sorted) {
            curr.next = new ListNode(element);
            curr = curr.next;
        }

        return dummy.next;
    }

    private List<Integer> mergeSort(List<Integer> array) {
        if (array.size() <= 1) {
            return array;
        }
        // [4, 2, 1, 3]
        int mid = array.size() / 2;
        List<Integer> leftArray = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftArray.add(array.get(i));
        }
        List<Integer> rightArray = new ArrayList<>();
        for (int i = mid; i < array.size(); i++) {
            rightArray.add(array.get(i));
        }
        return merge(mergeSort(leftArray), mergeSort(rightArray));
    }

    private List<Integer> merge(List<Integer> leftArray, List<Integer> rightArray) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) < rightArray.get(j)) {
                result.add(leftArray.get(i));
                i++;
            } else {
                result.add(rightArray.get(j));
                j++;
            }
        }

        while (i < leftArray.size()) {
            result.add(leftArray.get(i));
            i++;
        }

        while (j < rightArray.size()) {
            result.add(rightArray.get(j));
            j++;
        }

        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
