package november_2025;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeVerticalOrderTraversal binaryTreeVerticalOrderTraversal = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> result = binaryTreeVerticalOrderTraversal.verticalOrder(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> indexesMap = new HashMap<>();

        ArrayDeque<TreeInfo> queue = new ArrayDeque<>();
        queue.add(new TreeInfo(0, root));
        int minIdx = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            TreeInfo current = queue.removeFirst();
            TreeNode node = current.node;
            int idx = current.idx;
            minIdx = Math.min(minIdx, idx);
            indexesMap.computeIfAbsent(idx, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                queue.add(new TreeInfo(idx - 1, node.left));
            }
            if (node.right != null) {
                queue.add(new TreeInfo(idx + 1, node.right));
            }
        }

        for (Map.Entry<Integer, List<Integer>> elem : indexesMap.entrySet()) {
            result.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, List<Integer>> elem : indexesMap.entrySet()) {
            result.set(elem.getKey() + Math.abs(minIdx), elem.getValue());
        }
        return result;
    }

    static class TreeInfo {
        int idx;
        TreeNode node;

        public TreeInfo(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
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
