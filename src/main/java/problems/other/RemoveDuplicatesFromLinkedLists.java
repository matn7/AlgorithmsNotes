package problems.other;

public class RemoveDuplicatesFromLinkedLists {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromLinkedLists remove = new RemoveDuplicatesFromLinkedLists();

        remove.remove_duplicates(node);

        System.out.println(node);

    }

    // O(n) time | O(1) space
    public void remove_duplicates(ListNode node) {
        ListNode curr = node;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

}
