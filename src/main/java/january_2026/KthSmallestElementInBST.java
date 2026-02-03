package january_2026;

import java.util.List;

public class KthSmallestElementInBST {

    // O(n) time | O(h) space
    public int kthSmallest(TreeNode root, int k) {
        TreeInfo info = new TreeInfo(root, 0);
        findNode(root, info, k);
        return info.node.val;
    }

    private void findNode(TreeNode node, TreeInfo info, int k) {
        if (node == null) {
            return;
        }
        findNode(node.left, info, k);
        if (info.pos < k) {
            info.node = node;
            info.pos++;
            findNode(node.right, info, k);
        }
    }

    static class TreeInfo {
        TreeNode node;
        int pos;

        public TreeInfo(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }


    private void dfs(TreeNode node, List<Integer> elements) {
        if (node == null) {
            return;
        }
        dfs(node.left, elements);
        elements.add(node.val);
        dfs(node.right, elements);
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


