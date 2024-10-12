package january_2024;

import java.util.*;

public class RemoveZeroNodes {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(-1);
        node.next.next.next.next= new Node(-2);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(1);

        removeZeroNodes(node);
    }

    // O(n) time | O(n) space
    public static Node removeZeroNodes(Node node) {
        // 3 -> 1 -> 2 -> -1 -> -2 -> 4 -> 1
        //    3   4    6      5     3
        Map<Integer, Node> sumMap = new LinkedHashMap<>();
        int sum = 0;
        Node temp = new Node(0);
        temp.next = node;
        Node curr = node;
        while (curr != null) {
            sum += curr.value;
            if (sumMap.containsKey(sum)) {
                Node zeroNode = sumMap.get(sum); // (3)
                zeroNode.next = curr.next;
                for (Map.Entry<Integer, Node> element : sumMap.entrySet()) {
                    if (element.getValue() == zeroNode) {
                        break;
                    }
                    sumMap.remove(element.getKey());
                }
            } else {
                sumMap.put(sum, curr);
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
