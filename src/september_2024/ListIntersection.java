package september_2024;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListIntersection {

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(6);

        Node l2 = new Node(1);
        l2.next = new Node(6);
        l2.next.next = l1.next.next.next;
//        l2.next.next = new Node(8);

        ListIntersection listIntersection = new ListIntersection();
        Node intersection = listIntersection.intersection(l1, l2);
        System.out.println();
    }

    // O(n + m) time | O(1) space
    public Node intersection(Node l1, Node l2) {
        Node p1 = l1;
        Node p2 = l2;
        boolean loopdetection = false;

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            if (p1.next == null) {
                if (loopdetection) {
                    break;
                }
                loopdetection = true;
                p1 = l2;
            } else {
                p1 = p1.next;
            }
            if (p2.next == null) {
                p2 = l1;
            } else {
                p2 = p2.next;
            }
        }
        return null;
    }

    // O(n + m) time | O(n) space
    public Node intersection2(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        Set<Node> seen = new HashSet<>();
        while (l1 != null) {
            seen.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            if (seen.contains(l2)) {
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // Book
    // O(n+m) time | O(1) space
    Node findIntersection(Node list1, Node list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (result1.tail != result2.tail) {
            return null;
        }

        Node shorter = result1.size < result2.size ? list1 : list2;
        Node longer = result1.size < result2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;

    }

    class Result {
        public Node tail;
        public int size;
        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    Result getTailAndSize(Node list) {
        if (list == null) {
            return null;
        }
        int size = 1;
        Node current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    Node getKthNode(Node head, int k) {
        Node current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

}
