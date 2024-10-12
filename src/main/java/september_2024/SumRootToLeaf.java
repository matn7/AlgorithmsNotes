package september_2024;

public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);

        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        int result = sumRootToLeaf.sumNumbers(root);
        System.out.println(result);
    }

    // leetcode 129

    // O(n) time | O(n) space
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode curr, int num) {
        if (curr == null) {
            return 0;
        }
        num = num * 10 + curr.val;
        if (isLeaf(curr)) {
            return num;
        }
        return dfs(curr.left, num) + dfs(curr.right, num);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
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
