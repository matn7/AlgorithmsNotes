package november_2023;

import java.util.HashMap;
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

        removeZeroSumConsecutiveNodes(node);
    }

    // O(n) time | O(n) space
    public static Node removeZeroSumConsecutiveNodes(Node node) {
        // [3 -> 1 -> 2 -> (-1) -> (-2) -> 4 -> 1]
        // [  3    4    6       5       3     7]
        Map<Integer, Node> sumNodes = new HashMap<>();
        Node dummy = new Node(0);
        dummy.next = node;

        Node curr = dummy;
        int sum = 0;
        while (curr != null) {
            sum += curr.value;
            if (sumNodes.containsKey(sum)) {
                Node previousNode = sumNodes.get(sum);
                previousNode.next = curr.next;
                Stack<Integer> stack = new Stack<>();
                for (Map.Entry<Integer, Node> element : sumNodes.entrySet()) {
                    stack.push(element.getKey());
                }
                while (!stack.isEmpty()) {
                    Integer peek = stack.peek();
                    if (peek == sum) {
                        break;
                    }
                    sumNodes.remove(stack.pop());
                }
                stack.clear();
            } else {
                sumNodes.put(sum, node);
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
