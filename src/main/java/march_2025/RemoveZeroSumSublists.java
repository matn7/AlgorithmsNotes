package march_2025;

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

    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> sumToNode = new LinkedHashMap<>();
        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr != null) {
            sum += curr.val;
            if (!sumToNode.containsKey(sum)) {
                sumToNode.put(sum, curr);
            } else {
                ListNode prev = sumToNode.get(sum);
                prev.next = curr.next;
                Stack<Integer> toRemove = new Stack<>();
                for (Map.Entry<Integer, ListNode> elem : sumToNode.entrySet()) {
                    toRemove.push(elem.getKey());
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
