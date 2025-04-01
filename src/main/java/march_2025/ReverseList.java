package march_2025;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseList reverseList = new ReverseList();
        ListNode result = reverseList.reverseList(head);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return helper(curr, prev);
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
