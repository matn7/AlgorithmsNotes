package october_2024;

public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        PartitionList partitionList = new PartitionList();
        ListNode node = partitionList.partition(head, 3);

        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }


    }

    // O(n) time | O(1) space
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode smaller = new ListNode(0);
        ListNode sCurr = smaller;
        ListNode greaterOrEqual = new ListNode(0);
        ListNode gCurr = greaterOrEqual;

        while (curr != null) {
            if (curr.val < x) {
                sCurr.next = curr;
                sCurr = sCurr.next;
            } else {
                gCurr.next = curr;
                gCurr = gCurr.next;
            }
            curr = curr.next;
        }
        gCurr.next = null;
        sCurr.next = greaterOrEqual.next;

        dummy.next = smaller.next;

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
