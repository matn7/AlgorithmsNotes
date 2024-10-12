package problems.other;

public class ReverseALinkedList {

    public static void main(String[] args) {
        ListNode2 node2 = new ListNode2(5);
        node2.next = new ListNode2(4);
        node2.next.next = new ListNode2(3);
        node2.next.next.next = new ListNode2(2);
        node2.next.next.next.next = new ListNode2(1);

        ReverseALinkedList reverseALinkedList = new ReverseALinkedList();
        ListNode2 result = reverseALinkedList.reverseLinkedList(node2);
        System.out.println();
    }

    // O(n) time | O(1) space
    public ListNode2 reverseLinkedList(ListNode2 node) {
        //  <- 5 <- 4 <- 3 <- 2 <- 1
        //                         p    c    n
        ListNode2 prev = null;
        ListNode2 curr = node;

        while (curr != null) {
            ListNode2 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}

// Define data structure, LinkedList is not really LinkedList but single node
class ListNode2 {
    int value;
    ListNode2 next;

    public ListNode2(int value) {
        this.value = value;
    }
}
