package july_2024;

import java.util.HashMap;
import java.util.Map;

public class FrequentSubtree {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.setLeft(new Node(1));
        node.setRight(new Node(-3));

        int result = mostFrequent(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int mostFrequent(Node root) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        buildFrequencies(root, frequencies);
        int mostCommonSum = 0;
        if (!frequencies.containsKey(mostCommonSum)) {
            frequencies.put(mostCommonSum, 0);
        }
        for (Map.Entry<Integer, Integer> element : frequencies.entrySet()) {
            Integer k = element.getKey();
            if (frequencies.get(k) > frequencies.get(mostCommonSum)) {
                mostCommonSum = k;
            }
        }
        return mostCommonSum;
    }

    private static int buildFrequencies(Node root, Map<Integer, Integer> frequencies) {
        if (root == null) {
            return 0;
        }
        int sum = root.value + buildFrequencies(root.left, frequencies) + buildFrequencies(root.right, frequencies);
        if (frequencies.containsKey(sum)) {
            frequencies.put(sum, frequencies.get(sum) + 1);
        } else {
            frequencies.put(sum, 1);
        }
        return sum;
    }

    static final class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
