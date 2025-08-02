package july_2025;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveZeroSum {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        RemoveZeroSum removeZeroSum = new RemoveZeroSum();
        ListNode result = removeZeroSum.removeZeroSumSublists(head);
        System.out.println(result);
    }

    // Intuition:
    // - count created sum by nodes
    // - if seen before, this is our node, pointer manipulation
    // Approach:
    // - map<int, node>
    // - Elem to remove from map
    // Complexity:
    // - O(n) time | O(n) space
    // Code:

    // prev
    // 0 -> 1 -> 2 -> -3 -> 3 -> 1
    //      c

    // 0 ->   ->   -> -  -> 3 -> 1
    //      c

    // nodesMap = {0: <0>, 1: <1>, 3: <2>, }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        Map<Integer, ListNode> nodesMap = new LinkedHashMap<>();
        int sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (nodesMap.containsKey(sum)) {
                ListNode prev = nodesMap.get(sum);
                prev.next = curr.next;

                Stack<Integer> toRemove = new Stack<>();
                for (Map.Entry<Integer, ListNode> elem : nodesMap.entrySet()) {
                    toRemove.add(elem.getKey());
                }

                while (!toRemove.isEmpty()) {
                    int top = toRemove.pop();
                    if (top == sum) {
                        break;
                    }
                    nodesMap.remove(top);
                }


            } else {
                nodesMap.put(sum, curr);
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
