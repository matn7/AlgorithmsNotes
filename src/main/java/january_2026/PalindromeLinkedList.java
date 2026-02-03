package january_2026;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean result = palindromeLinkedList.isPalindrome(head);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow.next);
        slow = head;

        while (reversed != null) {
            if (slow.val != reversed.val) {
                return false;
            }
            slow = slow.next;
            reversed = reversed.next;
        }
        return true;
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
