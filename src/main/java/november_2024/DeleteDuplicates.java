package november_2024;

public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(1);

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode = deleteDuplicates.deleteDuplicates(head);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = new ListNode(0);
        ListNode a = head;
        temp.next = a;

        while (a != null) {
            ListNode b = a;
            while (b != null && b.val == a.val) {
                b = b.next;
            }
            a.next = b;
            a = b;
        }
        return temp.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
