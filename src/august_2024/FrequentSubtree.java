package august_2024;

import java.util.HashMap;
import java.util.Map;

public class FrequentSubtree {

    public static void main(String[] args) {

        Node node = new Node(3);
        node.left = new Node(1);
        node.right = new Node(-3);

        frequentSubtree(node);

    }

    // O(n) time | O(n) space
    public static int frequentSubtree(Node node) {
        if (node == null) {
            return 0;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        inOrder(node, frequencyMap);
        int mostFrequent = 0;
        if (!frequencyMap.containsKey(mostFrequent)) {
            frequencyMap.put(mostFrequent, -1);
        }
        for (Map.Entry<Integer, Integer> element : frequencyMap.entrySet()) {
            Integer key = element.getKey();
            if (frequencyMap.get(key) > frequencyMap.get(mostFrequent)) {
                mostFrequent = key;
            }
        }

        return mostFrequent;
    }

    private static int inOrder(Node node, Map<Integer, Integer> frequencyMap) {
        if (node == null) {
            return 0;
        }
        int sum = node.value + inOrder(node.left, frequencyMap) + inOrder(node.right, frequencyMap);
        frequencyMap.put(sum, frequencyMap.getOrDefault(sum, 0) + 1);
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
