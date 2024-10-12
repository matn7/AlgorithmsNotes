package november_2023;

public class LinkedListPalindrome {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(0);

        System.out.println(linkedListPalindrome(head));
    }

    // O(n) time | O(1) space
    public static boolean linkedListPalindrome(LinkedList head) {
        //                          f
        // 0 -> 1 -> 2 -> 2 -> 1 -> 0
        //           s
        if (head == null || head.next == null) {
            return true;
        }
        LinkedList slow = head;
        LinkedList fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList newHead = slow.next;

        LinkedList reversed = reverse(newHead);
        slow = head;

        while (reversed != null && slow != null) {
            if (reversed.value != slow.value) {
                return false;
            }
            reversed = reversed.next;
            slow = slow.next;
        }

        return true;
    }

    private static LinkedList reverse(LinkedList node) {
        LinkedList prev = null;
        LinkedList curr = node;
        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
