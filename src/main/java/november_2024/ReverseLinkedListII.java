package november_2024;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode listNode = reverseLinkedListII.reverseBetween(head, 1, 3);
        System.out.println(listNode);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int pos = 1;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = head;
        ListNode prev = null;
        while (pos < left) {
            pos++;
            prev = curr;
            curr = curr.next;
        }
        // prev leave as is
        if (pos >= right) {
            return temp.next;
        }

        ListNode start = curr;
        ListNode p = null;
        while (pos <= right) {
            ListNode next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
            pos++;
        }
        if (prev == null && curr == null) {
            return p;
        }
        if (prev == null) {
            start.next = curr;
            return p;
        }
        prev.next = p;
        start.next = curr;

        return temp.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
