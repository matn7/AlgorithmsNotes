package january_2026;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//
//        int n = 1;

//        ListNode head = new ListNode(1);
//        int n = 1;

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int n = 1;

        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode listNode = removeNthNodeFromEnd.removeNthFromEnd(head, n);
        System.out.println(listNode);

    }

    // O(n) time | O(1) space
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        int i = 0;
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
