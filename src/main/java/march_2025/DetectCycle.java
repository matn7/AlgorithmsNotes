package march_2025;

public class DetectCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        DetectCycle detectCycle = new DetectCycle();
        ListNode listNode = detectCycle.detectCycle(head);
        System.out.println(listNode.val);
    }
    
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode slow2 = head;
        while (slow2 != slow) {
            slow2 = slow2.next;
            slow = slow.next;
        }
        return slow2;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
