package april_2025;

public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.partition(head, x);
        System.out.println(result);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummySmaller = new ListNode(0);
        ListNode smaller = new ListNode(0);

        ListNode dummyGreater = new ListNode(0);
        ListNode greaterOrEqual = new ListNode(0);

        dummySmaller.next = smaller;
        dummyGreater.next = greaterOrEqual;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                smaller.next = new ListNode(curr.val);
                smaller = smaller.next;
            } else {
                greaterOrEqual.next = new ListNode(curr.val);
                greaterOrEqual = greaterOrEqual.next;
            }
            curr = curr.next;
        }
        smaller.next = dummyGreater.next.next;
        return dummySmaller.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
