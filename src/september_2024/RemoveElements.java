package september_2024;

public class RemoveElements {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(6);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next.next = new ListNode(6);

//        ListNode head = new ListNode(6);
//        head.next = new ListNode(6);
//        head.next.next = new ListNode(1);

        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);

        RemoveElements removeElements = new RemoveElements();
        ListNode listNode = removeElements.removeElements(head, 6);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    // O(n) time | O(1) space
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
//        while (head != null && head.val == val) {
//            head = head.next;
//        }
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
