package july_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        MostFrequentSubtreeSum mostFrequentSubtreeSum = new MostFrequentSubtreeSum();
        int[] result = mostFrequentSubtreeSum.findFrequentTreeSum(root);
        System.out.println(result);
    }

    // Intuition:
    // - loop through map
    // - count sum -> hash map
    // - dfs
    // Approach:
    // - maxFreq variable
    // - populate counts map
    // - loop through map and append to result
    // Complexity:
    // O(n) time | O(n) space
    // Code:

    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        dfs(root, freqMap);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() == maxFreq) {
                res.add(elem.getKey());
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode node, Map<Integer, Integer> freqMap) {
        if (node == null) {
            return 0;
        }
        int newSum = node.val;
        newSum += dfs(node.left, freqMap);
        newSum += dfs(node.right, freqMap);
        freqMap.put(newSum, freqMap.getOrDefault(newSum, 0) + 1);
        maxFreq = Math.max(maxFreq, freqMap.get(newSum));
        return newSum;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
