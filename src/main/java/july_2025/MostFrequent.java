package july_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequent {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        MostFrequent mostFrequent = new MostFrequent();
        int[] result = mostFrequent.findFrequentTreeSum(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    int mostFrequent = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        dfs(root, freqMap);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() == mostFrequent) {
                result.add(elem.getKey());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode node, Map<Integer, Integer> freqMap) {
        if (node == null) {
            return 0;
        }
        int val = node.val;
        val += dfs(node.left, freqMap);
        val += dfs(node.right, freqMap);

        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        mostFrequent = Math.max(mostFrequent, freqMap.get(val));
        return val;
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
