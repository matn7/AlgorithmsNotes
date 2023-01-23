package coderpro;

public class SwapEveryTwoNodes {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        SwapEveryTwoNodes swapEveryTwoNodes = new SwapEveryTwoNodes();
        swapEveryTwoNodes.swap_every_two(node);
    }

    // O(n) time | O(1) space
    public ListNode swap_every_two(ListNode node) {
        ListNode curr = node;
        while (curr != null && curr.next != null) {
            swap_values(curr, curr.next);
            curr = curr.next.next;
        }

        return node;
    }

    private void swap_values(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

}
