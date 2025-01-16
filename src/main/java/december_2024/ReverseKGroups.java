package december_2024;

public class ReverseKGroups {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;

        ReverseKGroups reverseKGroups = new ReverseKGroups();
        reverseKGroups.reverseKGroup(head, k);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        boolean dummyUpdated = false;
        ListNode a = head;
        ListNode b = head;
        int tempK = k;

        while (b != null) {
            while (b != null && tempK > 1) {
                b = b.next;
                tempK--;
            }
            // what if b == null
            if (b == null) {
                break;
            }
            ListNode next = b.next;
            // reverse
            ListNode[] reversed = reverse(a, next);
            reversed[0].next = next;
            if (!dummyUpdated) {
                dummy.next = reversed[1];
                dummyUpdated = true;
                curr = reversed[0];
            } else {
                curr.next = reversed[1];
                curr = reversed[0];
            }
            b = next;
            a = next;

            tempK = k;
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[] {start, prev};
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
