package problems.hard;

import java.util.HashMap;
import java.util.Map;

public class FindLoop {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(2);
        linkedList.next.next.next = new LinkedList(3);
        linkedList.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next.next = new LinkedList(6);
        linkedList.next.next.next.next.next.next.next = new LinkedList(7);
        linkedList.next.next.next.next.next.next.next.next = new LinkedList(8);
        linkedList.next.next.next.next.next.next.next.next.next = new LinkedList(9);
        linkedList.next.next.next.next.next.next.next.next.next.next = linkedList.next.next.next.next;

        LinkedList loop = findLoop2(linkedList);
    }

    // O(n) time | O(n) space
    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        Map<LinkedList, Boolean> visitedMap = new HashMap<>();

        LinkedList current = head;

        while (current != null) {
            if (visitedMap.containsKey(current)) {
                break;
            } else {
                visitedMap.put(current, Boolean.TRUE);
            }
            current = current.next;
        }

        return current;
    }

    // O(n) time | O(1) space
    public static LinkedList findLoop2(LinkedList head) {
        // Write your code here.
        LinkedList first = head;
        LinkedList second = head;

        while (first != null && second.next != null) {
            first = first.next;
            second = second.next;
            if (second.next != null) {
                second = second.next;
            }

            if (first == second) {
                break;
            }
        }

        first = head;
        while (first != null && second != null) {
            first = first.next;
            second = second.next;
            if (first == second) {
                break;
            }
        }

        return first;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
