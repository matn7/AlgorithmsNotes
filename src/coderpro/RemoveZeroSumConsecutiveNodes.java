package coderpro;

import java.util.*;

public class RemoveZeroSumConsecutiveNodes {

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(-1);
        root.next.next.next.next = new ListNode(-2);
        root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(1);

        RemoveZeroSumConsecutiveNodes removeZeroSumConsecutiveNodes = new RemoveZeroSumConsecutiveNodes();
        removeZeroSumConsecutiveNodes.removeZeroSumSubList(root);
    }

    // O(n) time | O(n) space
    public ListNode removeZeroSumSubList(ListNode node) {
        Map<Integer, ListNode> sumToNode = new LinkedHashMap<>(); // ordered hash map
        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode n = dummy;
        while (n != null) {
            sum += n.val;
            if (!sumToNode.containsKey(sum)) {
                sumToNode.put(sum, n);
            } else {
                ListNode prev = sumToNode.get(sum);
                prev.next = n.next;
                Stack<Integer> toRemove = new Stack<>();
                for (Map.Entry<Integer, ListNode> elem : sumToNode.entrySet()) {
                    toRemove.add(elem.getKey());
                }
                while (!toRemove.isEmpty()) {
                    Integer peek = toRemove.peek();
                    if (peek == sum) {
                        break;
                    }
                    sumToNode.remove(toRemove.pop());
                }
                toRemove.clear();
            }
            n = n.next;
        }

        return dummy.next;
    }
}
