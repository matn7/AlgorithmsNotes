package udemy.faang.leetcode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        swapNodesInPairs.swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode temp = p2;

        while (p2 != null) {
            ListNode pN = p2.next;
            p2.next = p1;
            if (pN == null) {
                p1.next = null;
                break;
            } else if (pN.next == null) {
                p1.next = pN;
                break;
            } else {
                p1.next = pN.next;
            }
            p1 = pN;
            p2 = pN.next;
        }
        return temp;
    }

}
