package march_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentTreeSum {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(-3);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        FrequentTreeSum frequentTreeSum = new FrequentTreeSum();
        int[] result = frequentTreeSum.findFrequentTreeSum(root);
        System.out.println(result);
    }

    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        dfs(root, freqMap);
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() == maxFreq) {
                resultList.add(elem.getKey());
            }
        }
        return resultList.stream().mapToInt(i -> i).toArray();
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
