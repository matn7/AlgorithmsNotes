package january_2026;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode = swapPairs.swapPairs(head);
        System.out.println(listNode);
    }

    // O(n) time | O(1) space
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode first = head;
        ListNode prev = null;

        while (first != null) {
            ListNode second = first.next;
            if (second == null) {
                return dummy.next;
            }
            ListNode next = second.next;

            second.next = first;
            first.next = next;

            if (dummy.next == null) {
                dummy.next = second;
            }

            if (prev == null) {
                prev = first;
            } else {
                prev.next = second;
                prev = first;
            }
            first = next;
        }

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
