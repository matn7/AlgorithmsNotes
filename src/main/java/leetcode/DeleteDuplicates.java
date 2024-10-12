package leetcode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            if ((prev != null && current.val == prev.val) || (current.next != null && current.val == current.next.val)) {
                
            } else {
                if (newHead == null) {
                    newHead = current;
                    newTail = newHead;
                } else {
                    newTail.next = current;
                    newTail = current;
                }
            }

            prev = current;
            current = current.next;
        }
        if (newTail != null) {
            newTail.next = null;
        }
        return newHead;
    }

}
