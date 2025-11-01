package october_2025;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode head = null;
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();
        ListNode result = middleOfTheLinkedList.middleNode(head);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


}
