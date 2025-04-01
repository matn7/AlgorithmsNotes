package march_2025;

public class PairSum {


    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        PairSum pairSum = new PairSum();
        int result = pairSum.pairSum(head);
        System.out.println(result);
    }

    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode reversedSecondHalf = reverse(secondHalf);
        int res = 0;

        ListNode firstHalf = head;
        while (firstHalf != null && reversedSecondHalf != null) {
            res = Math.max(res, firstHalf.val + reversedSecondHalf.val);
            firstHalf = firstHalf.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }
        return res;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
