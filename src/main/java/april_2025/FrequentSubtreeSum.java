package april_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentSubtreeSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        FrequentSubtreeSum frequentSubtreeSum = new FrequentSubtreeSum();
        int[] result = frequentSubtreeSum.findFrequentTreeSum(root);
        System.out.println(result);
    }

    int maxFreq = 0;

    // O(n) time | O(n) space
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        dfs(root, freqMap);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() == maxFreq) {
                res.add(elem.getKey());
            }
        }
        return res.stream().mapToInt(a -> a).toArray();
    }

    private int dfs(TreeNode node, Map<Integer, Integer> freqMap) {
        if (node == null) {
            return 0;
        }
        int sum = node.val;
        sum += dfs(node.left, freqMap);
        sum += dfs(node.right, freqMap);
        freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, freqMap.get(sum));
        return sum;
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
