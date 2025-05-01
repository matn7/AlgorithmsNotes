package april_2025;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        ListNode head = new ListNode(1);
        SwapPairs swapPairs = new SwapPairs();
        ListNode result = swapPairs.swapPairs(head);
        System.out.println();

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode nxtPair = curr.next.next;
            ListNode second = curr.next;

            second.next = curr;
            curr.next = nxtPair;
            prev.next = second;

            prev = curr;
            curr = nxtPair;
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
