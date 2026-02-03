package january_2026;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveZeroSumSublists {

    // O(n) time | O(n) space
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        LinkedHashMap<Integer, ListNode> sumMap = new LinkedHashMap<>();
        int sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (sumMap.containsKey(sum)) {
                ListNode prev = sumMap.get(sum);
                prev.next = curr.next;

                ArrayDeque<Integer> toRemove = new ArrayDeque<>();
                for (Map.Entry<Integer, ListNode> elem : sumMap.entrySet()) {
                    toRemove.addLast(elem.getKey());
                }

                while (!toRemove.isEmpty()) {
                    int peek = toRemove.getLast();
                    if (peek == sum) {
                        break;
                    }
                    sumMap.remove(toRemove.removeLast());
                }
            } else {
                sumMap.put(sum, curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
