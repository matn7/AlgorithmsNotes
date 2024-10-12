package udemy.faang;

public class FindCycle {

    public static void main(String[] args) {

    }

    // O(n) time | O(1) space
    public static ListNode findCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while (true) {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare == null || hare.next == null) {
                return null;
            }
            hare = hare.next;
            if (tortoise == hare) {
                break;
            }
        }
        ListNode p1 = head;
        ListNode p2 = tortoise;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    static class ListNode {
        int value;
        ListNode next;
    }

}
