package january_2025;

import java.util.ArrayList;
import java.util.List;

public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        for (int p : preorder) {
            pre.add(p);
        }
        List<Integer> in = new ArrayList<>();
        for (int i : inorder) {
            in.add(i);
        }
        return helper(pre.remove(0), pre, in);
    }

    private TreeNode helper(int p, List<Integer> pre, List<Integer> in) {
        TreeNode newNode = new TreeNode(p);

        List<Integer> before = new ArrayList<>();
        int idx = 0;
        for (idx = 0; idx < in.size(); idx++) {
            if (in.get(idx) != p) {
                before.add(in.get(idx));
            } else {
                break;
            }
        }
        List<Integer> after = in.subList(idx + 1, in.size());
        newNode.left = helper(pre.remove(0), pre, after);
        newNode.right = helper(pre.remove(0), pre, after);

        return newNode;
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
