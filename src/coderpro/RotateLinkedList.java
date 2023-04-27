package coderpro;

public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        RotateLinkedList rotate = new RotateLinkedList();
        ListNode result = rotate.rotate(node, 4);
        System.out.println();
    }

    // O(n) time | O(1) space
    public ListNode rotate(ListNode node, int n) {
        int length = 0;
        ListNode curr = node;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        n = n % length;
        ListNode slow = node;
        ListNode fast = node;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = node;
        ListNode head = slow.next;
        slow.next = null;
        return head;
    }

    // O(n) time | O(1) space
    public ListNode rotate2(ListNode node, int k) {
        int len = 1;
        ListNode tail = node;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        int newK = k % len;
        if (newK == 0) {
            return node;
        }
        ListNode newTail = node;
        int counter = 1;
        while (counter < newK) {
            newTail = newTail.next;
            counter++;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = node;

        return newHead;
    }

}
