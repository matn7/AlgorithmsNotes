package march_2024;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(5);
//        list1.next.next.next = new Node(9);
//        list1.next.next.next.next = new Node(19);

        Node list2 = new Node(2);
        list2.next = new Node(3);
        list2.next.next = new Node(6);
        list2.next.next.next = new Node(6);

        mergeLists(list1, list2);

    }

    // O(max(n,m)) time | O(1) space
    public static Node mergeLists(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        Node temp = new Node(0);
        Node curr = temp;
        Node p1 = list1;
        Node p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if (p1 != null) {
            curr.next = p1;
        }
        if (p2 != null) {
            curr.next = p2;
        }
//        while (p1 != null) {
//            curr.next = p1;
//            p1 = p1.next;
//            curr = curr.next;
//        }
//        while (p2 != null) {
//            curr.next = p2;
//            p2 = p2.next;
//            curr = curr.next;
//        }

        return temp.next;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
