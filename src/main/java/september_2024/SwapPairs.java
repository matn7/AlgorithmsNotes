package september_2024;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        SwapPairs swapPairs = new SwapPairs();
        swapPairs.swapPairs(head);
    }

    // O(n) time | O(1) space
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        prev.next = curr;
        while (curr != null && curr.next != null) {
            ListNode nxt = curr.next;
            ListNode cache = nxt.next;

            nxt.next = curr;
            curr.next = cache;
            prev.next = nxt;
            prev = curr;
            curr = cache;
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
