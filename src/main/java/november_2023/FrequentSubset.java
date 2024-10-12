package november_2023;

import java.util.HashMap;
import java.util.Map;

public class FrequentSubset {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(1);
        node.right = new Node(-3);
        node.right.right = new Node(12);
        node.left.right = new Node(12);
        node.right.left = new Node(-9);

        frequentSubset(node);
    }

    // O(n) time | O(n) space
    public static int frequentSubset(Node node) {
        Map<Integer, Integer> freq = new HashMap<>();
        frequentSubsetHelper(node, freq);
        int most_common = 0;
        if (!freq.containsKey(most_common)) {
            freq.put(most_common, 0);
        }
        for (Map.Entry<Integer, Integer> element : freq.entrySet()) {
            Integer k = element.getKey();
            if (freq.get(k) > freq.get(most_common)) {
                most_common = k;
            }
        }
        return most_common;
    }

    private static int frequentSubsetHelper(Node node, Map<Integer, Integer> freq) {
        if (node ==  null) {
            return 0;
        }
        int sum = node.value + frequentSubsetHelper(node.left, freq) + frequentSubsetHelper(node.right, freq);
        if (freq.containsKey(sum)) {
            freq.put(sum, freq.get(sum) + 1);
        } else {
            freq.put(sum, 1);
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
