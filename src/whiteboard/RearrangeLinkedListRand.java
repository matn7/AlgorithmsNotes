package whiteboard;

public class RearrangeLinkedListRand {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(3);
        head.next = new LinkedList(0);
        head.next.next = new LinkedList(5);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(4);

        rearrangeLinkedList(head, 3);
    }

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        // Write your code here.
        LinkedList smaller = null;
        LinkedList equals = null;
        LinkedList greater = null;
        LinkedList curr = head;
        while (curr != null) {
            if (curr.value < k) {
                smaller = expandList(smaller, curr);
            } else if (curr.value == k) {
                equals = expandList(equals, curr);
            } else {
                greater = expandList(greater, curr);
            }
            curr = curr.next;
        }
        LinkedList firstHalf = merge(smaller, equals);
        LinkedList result = merge(firstHalf, greater);
        return result;
    }

    private static LinkedList merge(LinkedList first, LinkedList second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        LinkedList head = first;
        while (head.next != null) {
            head = head.next;
        }
        head.next = second;
        return first;
    }

    private static LinkedList expandList(LinkedList list, LinkedList node) {
        if (list == null) {
            list = new LinkedList(node.value);
            return list;
        }
        LinkedList curr = list;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new LinkedList(node.value);
        return list;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

}
