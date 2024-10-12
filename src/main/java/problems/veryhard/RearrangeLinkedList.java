package problems.veryhard;

import java.util.ArrayList;
import java.util.List;

public class RearrangeLinkedList {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(3);
        head.next = new LinkedList(0);
        head.next.next = new LinkedList(5);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(4);

        rearrangeLinkedList(head, 3);
    }

    // O(n) time | O(1) space
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        // Write your code here.
        LinkedList smallerListHead = null;
        LinkedList smallerListTail = null;
        LinkedList equalListHead = null;
        LinkedList equalListTail = null;
        LinkedList greaterListHead = null;
        LinkedList greaterListTail = null;


        LinkedList node = head;
        while (node != null) {
            if (node.value < k) {
                smallerListHead = growLinkedList(smallerListHead, smallerListTail, node).get(0);
                smallerListTail = growLinkedList(smallerListHead, smallerListTail, node).get(1);
            } else if (node.value > k) {
                greaterListHead = growLinkedList(greaterListHead, greaterListTail, node).get(0);
                greaterListTail = growLinkedList(greaterListHead, greaterListTail, node).get(1);
            } else {
                equalListHead = growLinkedList(equalListHead, equalListTail, node).get(0);
                equalListTail = growLinkedList(equalListHead, equalListTail, node).get(1);
            }
            LinkedList prevNode = node;
            node = node.next;
            prevNode.next = null;
        }

        ListInfo firstInfo = connectLinkedList(smallerListHead, smallerListTail, equalListHead, equalListTail);
        ListInfo finalInfo = connectLinkedList(firstInfo.head, firstInfo.tail, greaterListHead, greaterListTail);

        return finalInfo.head;
    }

    private static ListInfo connectLinkedList(LinkedList headOne, LinkedList tailOne, LinkedList headTwo,
                                              LinkedList tailTwo) {
        LinkedList newHead = null;
        if (headOne == null) {
            newHead = headTwo;
        } else {
            newHead = headOne;
        }

        LinkedList newTail = null;
        if (tailTwo == null) {
            newTail = tailOne;
        } else {
            newTail = tailTwo;
        }

        if (tailOne != null) {
            tailOne.next = headTwo;
        }

        return new ListInfo(newHead, newTail);
    }

    private static List<LinkedList> growLinkedList(LinkedList head, LinkedList tail, LinkedList node) {
        LinkedList newHead = head;
        LinkedList newTail = node;

        List<LinkedList> result = new ArrayList<>();

        if (newHead == null) {
            newHead = node;
        }
        if (tail != null) {
            tail.next = node;
        }

        result.add(newHead);
        result.add(newTail);

        return result;
    }

    static class ListInfo {
        public LinkedList head;
        public LinkedList tail;

        public ListInfo(LinkedList head, LinkedList tail) {
            this.head = head;
            this.tail = tail;
        }
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
