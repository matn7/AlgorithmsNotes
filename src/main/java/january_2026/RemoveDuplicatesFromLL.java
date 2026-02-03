package january_2026;

public class RemoveDuplicatesFromLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromLL removeDuplicatesFromLL = new RemoveDuplicatesFromLL();
        ListNode listNode = removeDuplicatesFromLL.deleteDuplicates(head);
        System.out.println(listNode);
    }

    // O(n) time | O(1) space
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
