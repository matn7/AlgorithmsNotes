package august_2025;

public class ReverseListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ReverseListII reverseListII = new ReverseListII();
        ListNode listNode = reverseListII.reverseBetween(head, 1, 2);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }

    }

    // O(n) time | O(1) space
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = temp;
        int pos = 1;
        ListNode prev = null;
        ListNode from = null;
        ListNode to = null;
        ListNode next = null;

        while (pos <= right) {
            if (pos == left) {
                prev = curr;
                from = curr.next;
            }
            if (pos == right) {
                to = curr.next;
                next = to.next;
            }
            curr = curr.next;
            pos++;
        }
        prev.next = null;
        to.next = null;
        ListNode[] rev = reverse(from);
        prev.next = rev[0];
        rev[1].next = next;
        return temp.next;
    }

    private ListNode[] reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[] {prev, node};
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
