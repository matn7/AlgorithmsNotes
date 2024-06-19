package april_2024;

public class RemoveNthNode {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);

//        Node result = removeNthFromEnd(head, 2);
//        System.out.println(result);

        Node result2 = removeNthFromEnd2(head, 2);
        System.out.println(result2);
    }

    // O(n) time | O(1) space
    public static Node removeNthFromEnd(Node head, int n) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length == n) {
            return head.next;
        }
        length -= (n + 1);
        Node first = head;
        while (length > 0) {
            first = first.next;
            length--;
        }
        first.next = first.next.next;
        return head;
    }

    // O(n) time | O(1) space
    public static Node removeNthFromEnd2(Node head, int n) {
        Node ans = new Node(0);
        ans.next = head;

        Node first = ans.next;
        Node second = ans;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return ans.next;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}
