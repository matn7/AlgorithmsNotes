package january_2026;

import net.bytebuddy.build.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {

    // O(n) time | O(n) space
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] maxFreq = new int[] {0};
        dfs(root, freqMap, maxFreq);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() == maxFreq[0]) {
                result.add(elem.getKey());
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private int dfs(TreeNode node, Map<Integer, Integer> freqMap, int[] maxFreq) {
        if (node == null) {
            return 0;
        }
        int newSum = node.val;
        newSum += dfs(node.left, freqMap, maxFreq);
        newSum += dfs(node.right, freqMap, maxFreq);

        freqMap.put(newSum, freqMap.getOrDefault(newSum, 0) + 1);
        maxFreq[0] = Math.max(maxFreq[0], freqMap.get(newSum));
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
