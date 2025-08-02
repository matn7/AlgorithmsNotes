package july_2025;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();
        ListNode result = middleOfTheLinkedList.middleNode(head);
        System.out.println(result);
    }

    // Intuition:
    // - What Data Structure use?
    // - singly LL or doubly LL? singly
    // - check len, iterate half way
    // - slow + fast pointers
    // - dummy node
    // Approach:
    // - slow, fast. Fast speed = 2x slow
    // - slow position is a result
    // - consider even len
    // Complexity:
    // - O(n) time | O(1) space
    // Code:

    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
