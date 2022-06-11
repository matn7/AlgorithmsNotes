package hard;

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

    // O(N) time | O(N) space
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

    // O(N) time | O(1) space
    public static LinkedList findLoop2(LinkedList head) {
        // Write your code here.
        LinkedList first = head;
        LinkedList second = head;

        // 0 -> 1 -> 2 -> 4 -> 5 -> 6
        //                A         V
        //                9 <- 8 <- 7
        //
        // F -> X -> D + P
        // S -> 2X -> 2D + 2P
        // D -> {0-4}
        // P -> {4-7}
        // R -> {8-4} ?
        // T -> total distance
        // S -> T + P
        // T = 2D + 2P - P = 2D + P
        // R = T - P - D = D

        while (first != null && second.next != null) {
            first = first.next;
            second = second.next;
            if (second.next != null) {
                second = second.next;
            }

            if (first == second) {
                // pointers overlap
                break;
            }
        }

        // move first and second when they overlap we found node
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
