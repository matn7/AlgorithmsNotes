package star;

import java.util.HashMap;
import java.util.Map;

public class FrequentSubtreeSum {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(1);
        node.right = new Node(-3);
        node.right.left = new Node(0);
        node.right.left.left = new Node(33);
        node.right.right = new Node(0);
        node.right.right.left = new Node(13);
        node.left.left = new Node(2);
        node.left.left.right = new Node(13);

        FrequentSubtreeSum frequentSubtreeSum = new FrequentSubtreeSum();
        int result = frequentSubtreeSum.frequentSubtree(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int frequentSubtree(Node node) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        frequentSubtreeHelper(node, freqMap);
        return findMostFrequent(freqMap);
    }

    private int frequentSubtreeHelper(Node node, Map<Integer, Integer> freqMap) {
        if (node == null) {
            return 0;
        }

        int left = frequentSubtreeHelper(node.left, freqMap);
        int right = frequentSubtreeHelper(node.right, freqMap);
        int sum = node.val + left + right;
        updateFreqMap(sum, freqMap);
        return sum;
    }

    private void updateFreqMap(int val, Map<Integer, Integer> freqMap) {
        if (!freqMap.containsKey(val)) {
            freqMap.put(val, 1);
        } else {
            freqMap.put(val, freqMap.get(val) + 1);
        }
    }

    private int findMostFrequent(Map<Integer, Integer> freqMap) {
        int result = 0;
        int currMax = 0;

        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            int sum = elem.getKey();
            int freq = elem.getValue();
            if (freq > currMax) {
                currMax = freq;
                result = sum;
            }
        }

        return result;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
