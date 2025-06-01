package may_2025;

public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode result = reverseKGroup.reverseKGroup(head, k);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode c = head;
        ListNode p = head;

        while (c != null) {
            int pos = k;
            while (p != null && pos > 0) {
                p = p.next;
                pos--;
            }
            if (p == null) {
                if (prev.val == -1) {
                    return reverse(head, null)[0];
                }
                if (pos == 0) {
                    ListNode[] reversed = reverse(c, p);
                    prev.next = reversed[0];
                } else {
                    prev.next = c;
                }
                break;
            }
            ListNode n = p;
            ListNode[] reversed = reverse(c, p);
            ListNode groupHead = reversed[0];
            ListNode groupTail = reversed[1];
            prev.next = groupHead;
            prev = groupTail;
            c = n;
            p = n;
        }

        return dummy.next;
    }

    private ListNode[] reverse(ListNode start, ListNode end) {
        ListNode curr = start;
        ListNode prev = null;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[] {prev, start};
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
