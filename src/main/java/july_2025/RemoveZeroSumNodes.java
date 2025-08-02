package july_2025;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveZeroSumNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveZeroSumNodes removeZeroSumNodes = new RemoveZeroSumNodes();
        ListNode result = removeZeroSumNodes.removeZeroSumSublists(head);
        System.out.println(result);

    }

    // Intuition:
    // - Linked list problem - single linked list class ListNode
    // - How to detect zero subsum, map to keep track sum generated for node
    // - A way to remove, or point manipulation
    // Approach:
    // Complexity:
    // Code:

    //
    // 1 ----> 2 ---> -3 ---> 3 ---> 1
    // 1                      3

    // countsMap = {1: <1>, 3: <2>, 0: <-3>, 3: <3>}

    // O(n) time | O(n) space
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        Map<Integer, ListNode> sumsMap = new LinkedHashMap<>();
        int sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (sumsMap.containsKey(sum)) {
                ListNode prev = sumsMap.get(sum);
                prev.next = curr.next;
                Stack<Integer> toRemove = new Stack<>();
                for (Map.Entry<Integer, ListNode> elem : sumsMap.entrySet()) {
                    toRemove.push(elem.getKey());
                }

                while (!toRemove.isEmpty()) {
                    int peek = toRemove.peek();
                    if (peek == sum) {
                        break;
                    }
                    sumsMap.remove(toRemove.pop());
                }
            } else {
                sumsMap.put(sum, curr);
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
