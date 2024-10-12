package october_2024;

public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        RotateList rotateList = new RotateList();
        ListNode listNode = rotateList.rotateRight(head, 1);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    // leetcode 61

    // O(n) time | O(1) space
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the size of the linked list
        ListNode curr = head;
        int size = 1;
        while (curr.next != null) {
            size++;
            curr = curr.next;
        }

        // Connect the tail to the head to make it a circular linked list
        curr.next = head;

        // Normalize k to prevent unnecessary rotations
        k = k % size;
        if (k == 0) {
            curr.next = null; // Break the circle
            return head; // No rotation needed
        }

        // Find the new tail: (size - k - 1) from the beginning
        int newTailIndex = size - k - 1;
        curr = head;
        for (int i = 0; i < newTailIndex; i++) {
            curr = curr.next;
        }

        // Set the new head and break the circle
        ListNode newHead = curr.next;
        curr.next = null;

        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
