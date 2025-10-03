package september_2025;

public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);

        System.out.println();
    }

    // O(n) time | O(1) space
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow.next);
        slow.next = null;

        ListNode curr = head;

        while (curr != null && reversed != null) {
            ListNode next = curr.next;
            curr.next = reversed;
            curr = reversed;
            reversed = reversed.next;
            curr.next = next;
            curr = next;
        }

    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
