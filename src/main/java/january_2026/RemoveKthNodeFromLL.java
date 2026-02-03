package january_2026;

public class RemoveKthNodeFromLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        int n = 1;

        RemoveKthNodeFromLL removeKthNodeFromLL = new RemoveKthNodeFromLL();
        ListNode listNode = removeKthNodeFromLL.removeNthFromEnd(null, n);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    // O(n) time | O(1) space
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            second = second.next;
        }

        while (second != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;

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
