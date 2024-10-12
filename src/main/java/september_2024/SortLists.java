package september_2024;

import java.util.ArrayList;
import java.util.List;

public class SortLists {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(5);

        SortLists sortLists = new SortLists();
        ListNode listNode = sortLists.sortList(head);
        System.out.println(listNode);
    }
    
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        buildHeap(list);

        int idx = 0;
        ListNode sortedNode = new ListNode(0);
        ListNode curr = sortedNode;
        while (idx != list.size()) {
            curr.next = new ListNode(list.get(0).val);
            swap(list, 0, list.size() - 1 - idx);
            swiftDown(list, 0, list.size() - 1 - idx);
            idx++;
            curr = curr.next;
        }

        return sortedNode.next;
    }

    private void swiftDown(List<ListNode> list, int idx, int endIdx) {
        // 8, 4, 1, 3, 2
        // 2, 4, 1, 3, 8
        int leftChildIdx = 2 * idx + 1;
        while (leftChildIdx < endIdx) {
            int rightChildIdx = 2 * idx + 2;
            int idxToSwap;
            if (rightChildIdx < endIdx && list.get(rightChildIdx).val < list.get(leftChildIdx).val) {
                idxToSwap = rightChildIdx;
            } else {
                idxToSwap = leftChildIdx;
            }
            if (list.get(idx).val > list.get(idxToSwap).val) {
                swap(list, idx, idxToSwap);
                idx = idxToSwap;
                leftChildIdx = 2 * idx + 1;
            } else {
                break;
            }
        }

    }

    private void buildHeap(List<ListNode> list) {
        // 4, 2, 1, 3
        // 0  1  2  3
        int idx = list.size() - 1; // 3
        int parentIdx = (idx - 1) / 2;
        for (int currIdx = parentIdx; currIdx >= 0; currIdx--) {
            swiftDown(list, currIdx, list.size());
        }
    }

    private void swap(List<ListNode> list, int i, int j) {
        ListNode temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
