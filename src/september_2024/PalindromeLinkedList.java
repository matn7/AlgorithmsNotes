package september_2024;

import java.util.List;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean palindrome = palindromeLinkedList.isPalindrome(head);
        System.out.println(palindrome);
    }

    // O(n) time | O(1) space
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        if (fast == null) {
            return true;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        slow.next = null;

        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }

        return true;
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
