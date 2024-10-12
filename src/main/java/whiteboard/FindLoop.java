package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class FindLoop {

    // O(n) time | O(n) space
    public static LinkedList findLoopNotOptimal(LinkedList head) {
        // Write your code here.
        LinkedList current = head;
        Map<LinkedList, Boolean> seen = new HashMap<>();

        while (current != null) {
            if (seen.containsKey(current)) {
                return current;
            }
            seen.put(current, Boolean.TRUE);
            current = current.next;

        }
        return null;
    }

    // O(n) time | O(1) space
    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList first = head;
        LinkedList second = head.next;

        while (first != second) {
            first = first.next;
            second = second.next.next;
        }

        first = head;

        while (first != second.next) {
            first = first.next;
            second = second.next;
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
