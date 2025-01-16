package december_2024;

import java.util.ArrayList;
import java.util.List;

public class GoodNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

//        TreeNode root = new TreeNode(9);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(6);

        GoodNodes goodNodes = new GoodNodes();
        int result = goodNodes.goodNodes(root);
        System.out.println(result);
    }

    public int goodNodes(TreeNode root) {
        return dfs(root.val, root);
    }

    private int dfs(int max, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val >= max) {
            res++;
        }
        max = Math.max(max, node.val);
        res += dfs(max, node.left);
        res += dfs(max, node.right);
        return res;
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
