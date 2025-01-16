package december_2024;

public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(null);

        System.out.println(head);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode a = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            a = a.next;
            fast = fast.next.next;
        }

        ListNode b = reverse(a.next);
        a.next = null;
        a = head;

        while (a != null && b != null){
            ListNode aNext = a.next;
            a.next = b;
            a = b;
            b = b.next;
            a.next = aNext;
            a = aNext;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
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
