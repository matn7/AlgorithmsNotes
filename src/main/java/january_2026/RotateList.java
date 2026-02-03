package january_2026;

public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        int k = 1;

        RotateList rotateList = new RotateList();

        ListNode listNode = rotateList.rotateRight(head, k);
        System.out.println(listNode);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        int len = 1;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }
        ListNode tail = fast;
        fast = head;

        k = k % len;
        if (k == 0) {
            return head;
        }

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        tail.next = head;

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
