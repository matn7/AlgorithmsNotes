package october_2023;

public class MergeLinkedLists {

    public static void main(String[] args) {
        Node one = new Node(2);
        one.next = new Node(6);
        one.next.next = new Node(7);
        one.next.next.next = new Node(8);

        Node two = new Node(1);
        two.next = new Node(3);
        two.next.next = new Node(4);
        two.next.next.next = new Node(5);
        two.next.next.next.next = new Node(9);
        two.next.next.next.next.next = new Node(10);

        Node result = merge(one, two);
        System.out.println(result);
    }

    // O(m + n) time | O(1) space
    public static Node merge(Node one, Node two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }

        Node p1p = null;
        Node p1 = one;
        Node p2 = two;

        // p1p: n
        //                        *
        // p1: 2 -> 6 -> 7 -> 8
        // p2: 1 -> 3 -> 4 -> 5 -> 9 -> 10
        //                         *

        //     1 -> 2 -> 3 -> 5 -> 6 -> 7 -> 8 ->

        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p1p = p1;
                p1 = p1.next;
            } else {
                if (p1p == null) {
                    p1p = p2;
                    p2 = p2.next;
                    p1p.next = p1;
                } else {
                    p1p.next = p2;
                    p1p = p2;
                    p2 = p2.next;
                    p1p.next = p1;
                }
            }
        }
        if (p1 == null) {
            p1p.next = p2;
        }

        if (one.value < two.value) {
            return one;
        }

        return two;

    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
