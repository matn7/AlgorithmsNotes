package september_2024;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode = reverseLinkedList.reverseList2(head);
        System.out.println(listNode);


    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        return helper(null, head);
    }

    private ListNode helper(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return helper(prev, curr);
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
