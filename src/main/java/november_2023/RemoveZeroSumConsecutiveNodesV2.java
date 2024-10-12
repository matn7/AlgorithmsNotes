package november_2023;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveZeroSumConsecutiveNodesV2 {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(-1);
        node.next.next.next.next = new Node(-2);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(1);

        Node node1 = removeZeroSumConsecutive(node);
        while (node1 != null) {
            System.out.print(node1.value + " -> ");
            node1 = node1.next;
        }
    }

    // O(n) time | O(n) space
    public static Node removeZeroSumConsecutive(Node node) {
        Node temp = new Node(0);
        temp.next = node;
        Node curr = temp;

        Map<Integer, Node> sumsMap = new LinkedHashMap<>();
        int sum = 0;

        while (curr != null) {
            sum += curr.value;
            if (sumsMap.containsKey(sum)) {
                Node previousNode = sumsMap.get(sum);
                previousNode.next = curr.next;
                Stack<Integer> stack = new Stack<>();
                for (Map.Entry<Integer, Node> element : sumsMap.entrySet()) {
                    stack.push(element.getKey());
                }

                while (!stack.isEmpty()) {
                    Integer top = stack.pop();
                    if (top == sum) {
                        break;
                    }
                    sumsMap.remove(top);
                }

            } else {
                sumsMap.put(sum, curr);
            }
            curr = curr.next;
        }

        return temp.next;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
