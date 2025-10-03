package september_2025;

public class InsertGcd {

    // O(n * log(min(a,b))) time | O(1) space
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            int n1 = curr.val;
            int n2 = curr.next.val;
            int gcdValue = gcd(n1, n2);
            ListNode newNode = new ListNode(gcdValue, curr.next);
            curr.next = newNode;
            curr = newNode.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
