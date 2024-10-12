package udemy.faang;

public class MergeMultiLevelDoublyLinkedList {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        ListNode node13 = new ListNode(13);

        node1.prev = null;
        node1.next = node2;

        node2.prev = node1; // 2
        node2.next = node3; // 2
        node2.child = node7; // 2

        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node8.child = node10;
        node10.next = node11;
        node11.prev = node10;
        node9.prev = node8;

        node3.prev = node2; // 2
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node5.child = node12;
        node12.next = node13;
        node13.prev = node12;
        node6.prev = node5;

        ListNode head = node1;

        flatten(head);

        multiLevelMerge(head);

        System.out.println("FORWARD");
        while (head.next != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.print(head.value);
        System.out.println();
        System.out.println("BACKWARD");
        while (head.prev != null) {
            System.out.print(head.value + "->");
            head = head.prev;
        }
        System.out.print(head.value);

        System.out.println();
    }

    // O(n) time | O(d) space (worst case n space)
    public static ListNode multiLevelMerge(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr != null) {
            if (curr.child != null) {
                ListNode currRoot = curr;
                ListNode next = curr.next;
                levelMerge(curr.child, currRoot, next);
                curr = next;
            }
            curr = curr.next;
        }
        return head;
    }

    private static void levelMerge(ListNode child, ListNode root, ListNode next) {
        if (root != null) {
            root.next = child;
            child.prev = root;
            root.child = null;
        }
        ListNode curr = child;
        while (curr.next != null) {
            if (curr.child != null) {
                ListNode currRoot = curr;
                ListNode currNext = curr.next;
                levelMerge(curr.child, currRoot, currNext);
            }
            curr = curr.next;
        }
        curr.next = next;
        next.prev = curr;
    }

    static class ListNode {
        int value;
        ListNode prev;
        ListNode next;
        ListNode child;

        public ListNode(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(1) space
    public static ListNode flatten(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
            } else {
                ListNode tail = curr.child;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = curr.next;
                if (tail.next != null) {
                    tail.next.prev = tail;
                }
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            }
        }
        return head;
    }

}
