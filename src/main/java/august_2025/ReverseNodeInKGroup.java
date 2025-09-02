package august_2025;

public class ReverseNodeInKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseNodeInKGroup reverseNodeInKGroup = new ReverseNodeInKGroup();
        ListNode result = reverseNodeInKGroup.reverseKGroup(head, 2);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    // GOOD EXAMPLE
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            ListNode curr = prev;
            for (int i = 0; i < k && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) {
                break;
            }
            ListNode next = curr.next;
            curr.next = null;

            ListNode[] rev = reverse(prev.next);
            ListNode start = prev.next;

            prev.next = rev[0];
            rev[1].next = next;
            prev = start;
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[] {prev, node};
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
