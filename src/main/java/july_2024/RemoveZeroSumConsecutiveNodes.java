package july_2024;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveZeroSumConsecutiveNodes {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(-1);
        node.next.next.next.next = new Node(-2);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(1);

        Node node1 = removeZeroSumSublist(node);
        System.out.println(node1);
    }

    // O(n) time | O(n) space
    public static Node removeZeroSumSublist(Node node) {
        Map<Integer, Node> sumToNode = new LinkedHashMap<>();
        int sum = 0;
        Node dummy = new Node(0);
        dummy.next = node;
        Node curr = dummy;

        while (curr != null) {
            sum += curr.value;
            if (!sumToNode.containsKey(sum)) {
                sumToNode.put(sum, curr);
            } else {
                Node prev = sumToNode.get(sum);
                prev.next = curr.next;
                Stack<Integer> toRemove = new Stack<>();
                for (Map.Entry<Integer, Node> elem : sumToNode.entrySet()) {
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

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
