package july_2025;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;

        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode listNode = reverseNodesInKGroup.reverseKGroup(head, k);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode groupPrev = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode kth = getKth(curr, k - 1);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            kth.next = null;
            ListNode revHead = reverse(curr)[0];
            ListNode revTail = reverse(curr)[1];

            groupPrev.next = revHead;
            if (dummy.next == null) {
                dummy.next = revHead;
            }

            revTail.next = groupNext;
            curr = groupNext;

            groupPrev = revTail;
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

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
