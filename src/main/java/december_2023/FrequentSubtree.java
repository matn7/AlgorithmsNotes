package december_2023;

import java.util.HashMap;
import java.util.Map;

public class FrequentSubtree {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(1);
        node.right = new Node(-3);
        node.right.right = new Node(12);
        node.left.right = new Node(12);
        node.right.left = new Node(-9);

        frequentSubtree(node);
    }


    // O(n) time | O(n) space
    public static int frequentSubtree(Node node) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        helper_build_frequencies(node, freqMap);

        int most_common_sum = 0;
        if (!freqMap.containsKey(most_common_sum)) {
            freqMap.put(most_common_sum, 0);
        }
        for (Map.Entry<Integer, Integer> element : freqMap.entrySet()) {
            Integer key = element.getKey();
            if (freqMap.get(key) > freqMap.get(most_common_sum)) {
                most_common_sum = key;
            }
        }

        return most_common_sum;
    }

    private static int helper_build_frequencies(Node node, Map<Integer, Integer> freqMap) {
        if (node == null) {
            return 0;
        }
        int sum = node.value + helper_build_frequencies(node.left, freqMap) +
                helper_build_frequencies(node.right, freqMap);

        if (freqMap.containsKey(sum)) {
            freqMap.put(sum, freqMap.get(sum) + 1);
        } else {
            freqMap.put(sum, 1);
        }
        return sum;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
