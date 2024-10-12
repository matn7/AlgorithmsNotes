package udemy.faang;

public class MNReversal {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        reverseBetween(head, 3, 5);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int currentPosition = 1;
        ListNode currentNode = head;
        ListNode start = head;
        while (currentPosition < m) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPosition++;
        }
        ListNode newList = null;
        ListNode tail = currentNode;

        while (currentPosition >= m && currentPosition <= n) {
            ListNode next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPosition++;
        }
        start.next = newList;
        tail.next = currentNode;
        if (m > 1) {
            return head;
        }
        return newList;
    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
