package august_2024;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RemoveZeroSumSublist {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(-1);
        node.next.next.next.next = new Node(-2);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(1);

        Node result = removeZeroSumSublist(node);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static Node removeZeroSumSublist(Node node) {

        // dummy: 0
        //
        // 3 -> 1 -> 2 -> (-1) -> (-2) -> 4 -> 1
        //                          *

        // sumMap = { 3 : {3}, 4 : {1}, 6 : {2}, 5 : {-1}}

        Node dummy = new Node(0);
        Node curr = node;
        dummy.next = curr;

        Map<Integer, Node> sumMap = new LinkedHashMap<>();
        int sum = 0;
        while (curr != null) {
            sum += curr.value; // 5 - 2 = 3
            if (sumMap.containsKey(sum)) {
                Node prev = sumMap.get(sum);
                prev.next = curr.next;
                List<Integer> toRemove = new ArrayList<>(); // [5, 6, 4]
                for (Map.Entry<Integer, Node> element : sumMap.entrySet()) {
                    if (element.getKey() == sum) { // 5 == 3
                        break;
                    }
                    toRemove.add(element.getKey());
                }
                for (Integer remove : toRemove) {
                    sumMap.remove(remove);
                }
                toRemove.clear();

            } else {
                sumMap.put(sum, curr);
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
