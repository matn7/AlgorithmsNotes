package coderpro;

import java.util.HashMap;
import java.util.Map;

public class FrequentSubtreeSum {

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(1);
//        node.right = new TreeNode(-3);

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(-3);
        node.right.left = new TreeNode(0);
        node.right.left.left = new TreeNode(33);
        node.right.right = new TreeNode(0);
        node.right.right.left = new TreeNode(13);
        node.left.left = new TreeNode(2);
        node.left.left.right = new TreeNode(13);

        FrequentSubtreeSum frequentSubtreeSum = new FrequentSubtreeSum();
        int result = frequentSubtreeSum.most_freq(node);
        System.out.println(result);

    }

    // ********
    // * STAR *
    // ********

    // O(n) time | O(n) space
    public int most_freq(TreeNode root) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        helper_build_frequencies(root, frequencies);

        int most_common_sum = 0;
        if (!frequencies.containsKey(most_common_sum)) {
            frequencies.put(most_common_sum, 0);
        }
        for (Map.Entry<Integer, Integer> element : frequencies.entrySet()) {
            Integer k = element.getKey();
            if (frequencies.get(k) > frequencies.get(most_common_sum)) {
                most_common_sum = k;
            }
        }
        return most_common_sum;
    }

    private int helper_build_frequencies(TreeNode root, Map<Integer, Integer> frequencies) {
        if (root == null) {
            return 0;
        }

        int sum = root.value + helper_build_frequencies(root.left, frequencies) +
                helper_build_frequencies(root.right, frequencies);

        if (frequencies.containsKey(sum)) {
            frequencies.put(sum, frequencies.get(sum) + 1);
        } else {
            frequencies.put(sum, 1);
        }
        return sum;
    }


}
