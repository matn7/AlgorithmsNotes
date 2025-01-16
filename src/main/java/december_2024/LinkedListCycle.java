package december_2024;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        LinkedListCycle cycle = new LinkedListCycle();
        boolean result = cycle.hasCycle(head);
        System.out.println(result);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode a = head;
        ListNode b = head.next;

        while (b != null && b.next != null) {
            if (a == b) {
                return true;
            }
            a = a.next;
            b = b.next.next;
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
