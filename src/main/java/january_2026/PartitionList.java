package january_2026;

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
        ListNode partition = partitionList.partition(head, x);
        System.out.println(partition);
    }

    // O(n) time | O(n) space
    public ListNode partition(ListNode head, int x) {
        ListNode lessThanDummy = new ListNode(0);
        ListNode lessThan = lessThanDummy;
        ListNode greaterThanEqualToDummy = new ListNode(0);
        ListNode greaterThanEqualTo = greaterThanEqualToDummy;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                lessThan.next = new ListNode(curr.val);
                lessThan = lessThan.next;
            } else {
                greaterThanEqualTo.next = new ListNode(curr.val);
                greaterThanEqualTo = greaterThanEqualTo.next;
            }

            curr = curr.next;
        }

        lessThan.next = greaterThanEqualToDummy.next;

        return lessThanDummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
