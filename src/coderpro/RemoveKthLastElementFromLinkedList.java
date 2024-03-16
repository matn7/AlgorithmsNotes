package coderpro;

public class RemoveKthLastElementFromLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        RemoveKthLastElementFromLinkedList removeKthLastElementFromLinkedList = new RemoveKthLastElementFromLinkedList();
        removeKthLastElementFromLinkedList.removeKthFromLinkedList(head, k);
    }

    // O(n) time | O(1) space
    public ListNode removeKthFromLinkedList(ListNode node, int k) {
        ListNode slow = node;
        ListNode fast = node;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return node.next;
        }

        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = slow.next;
        return node;

    }

    // O(n) time | O(1) space
    public ListNode removeKthLastElementFromLinkedList2(ListNode head, int k) {
        ListNode s = head;
        ListNode f = head;
        int counter = 0;
        while (counter < k) {
            f = f.next;
            counter++;
        }

        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return head;
    }

}
