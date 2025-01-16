package december_2024;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        int n = 1;

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode = removeNthFromEnd.removeNthFromEnd(head, n);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode a = dummy;
        ListNode b = head;

        for (int i = 0; i < n; i++) {
            b = b.next;
        }

        while (b != null) {
            a = a.next;
            b = b.next;
        }
        a.next = a.next.next;

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

}
