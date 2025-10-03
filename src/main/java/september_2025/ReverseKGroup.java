package september_2025;

public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 4;

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode result = reverseKGroup.reverseKGroup(head, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode l1 = head;
        ListNode l2 = head;

        while (l2 != null) {
            System.out.println();
            for (int i = 0; i < k - 1 && l2 != null; i++) {
                l2 = l2.next;
            }
            if (l2 == null) {
                break;
            }
            ListNode next = l2.next;
            l2.next = null;
            ListNode[] reversed = reverse(l1);
            ListNode l2r = reversed[0];
            ListNode l1r = reversed[1];

            prev.next = l2r;

            l1r.next = next;
            prev = l1r;
            l1 = next;
            l2 = next;
            System.out.println();
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
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
