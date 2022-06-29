package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class FindLoop2 {

    public static LinkedList findLoop(LinkedList head) {
        LinkedList first = head;
        LinkedList second = first.next;

        while (first != null && second.next != null && first != second) {
            first = first.next;
            second = second.next;
            if (second.next != null) {
                second = second.next;
            }
        }

        first = head;
        while (first != second.next) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

//    // O(n) time | O(n) space
//    public static LinkedList findLoop(LinkedList head) {
//        // Write your code here.
//        Map<LinkedList, Boolean> seen = new HashMap<>();
//        LinkedList curr = head;
//        while (curr != null) {
//            if (seen.containsKey(curr)) {
//                return curr;
//            }
//            seen.put(curr, Boolean.TRUE);
//            curr = curr.next;
//        }
//        return null;
//    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
