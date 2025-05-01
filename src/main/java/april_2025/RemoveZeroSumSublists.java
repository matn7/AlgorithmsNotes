package april_2025;

import java.util.*;

public class RemoveZeroSumSublists {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(-1);
        head.next.next.next.next = new ListNode(-2);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(1);

        RemoveZeroSumSublists removeZeroSumSublists = new RemoveZeroSumSublists();
        ListNode result = removeZeroSumSublists.removeZeroSumSublists(head);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        Map<Integer, ListNode> sumMap = new LinkedHashMap<>();

        int sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (sumMap.containsKey(sum)) {
                ListNode prev = sumMap.get(sum);
                prev.next = curr.next;
                Stack<Integer> toRemove = new Stack<>();
                for (Map.Entry<Integer, ListNode> elem : sumMap.entrySet()) {
                    toRemove.push(elem.getKey());
                }
                while (!toRemove.isEmpty()) {
                    int peek = toRemove.peek();
                    if (peek == sum) {
                        break;
                    }
                    sumMap.remove(toRemove.pop());
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
