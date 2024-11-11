package october_2024;

public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);

        System.out.println();
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newList = slow.next;
        slow.next = null;
        ListNode p1 = head;
        ListNode p2 = reverse(newList);
        while (p1 != null && p2 != null) {
            ListNode p1Next = p1.next;
            p1.next = p2;
            ListNode p2Next = p2.next;
            p2.next = p1Next;
            p1 = p1Next;
            p2 = p2Next;
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
