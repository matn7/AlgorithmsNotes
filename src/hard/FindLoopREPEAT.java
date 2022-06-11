package hard;

import java.util.HashMap;
import java.util.Map;

public class FindLoopREPEAT {

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

        LinkedList loop = findLoop(linkedList);
    }

    // O(n) time | O(1) space
    // OK - repeated 26/01/2022
    public static LinkedList findLoop(LinkedList head) {

        //                fs
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //                |         |
        //                9 <- 8 <- 7
        //
        LinkedList first = head.next;
        LinkedList second = head.next.next;

        while (first != second) {
            first = first.next;
            second = second.next.next;
        }

        first = head;

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }


    // O(n) time | O(n) space (additional map)
    public static LinkedList findLoop2(LinkedList head) {
        //                c
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //                |         |
        //                9 <- 8 <- 7
        //
        Map<LinkedList, Boolean> visited = new HashMap<>();

        // visited = {1 : TRUE, 2: TRUE, 3: TRUE, 4: TRUE, 5: TRUE, 6: TRUE, 7: TRUE, 8: TRUE, 9: TRUE}
        LinkedList current = head;
        while (current != null) {
            if (visited.containsKey(current)) {
                break;
            }
            visited.put(current, Boolean.TRUE);
            current = current.next;
        }
        return current; // 4
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
