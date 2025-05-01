package april_2025;

public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode result = deleteDuplicates.deleteDuplicates(head);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode next = head;

        while (next != null) {
            while (next != null && curr.val == next.val) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
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
