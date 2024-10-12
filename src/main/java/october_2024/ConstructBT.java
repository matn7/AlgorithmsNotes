package october_2024;

import java.util.ArrayList;
import java.util.List;

public class ConstructBT {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBT constructBT = new ConstructBT();
        TreeNode treeNode = constructBT.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    // leetcode 105

    // O(n) time | O(n) space
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        List<Integer> preorderArr = new ArrayList<>();
        for (int j : preorder) {
            preorderArr.add(j);
        }
        List<Integer> inorderArr = new ArrayList<>();
        for (int j : inorder) {
            inorderArr.add(j);
        }

        return helper(preorderArr, inorderArr);
    }

    private TreeNode helper(List<Integer> preorder, List<Integer> inorder) {
        if(preorder.isEmpty() || inorder.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(preorder.get(0));
        int mid = inorder.indexOf(root.val);
        root.left = helper(preorder.subList(1, mid + 1), inorder.subList(0, mid));
        root.right = helper(preorder.subList(mid + 1, preorder.size()), inorder.subList(mid + 1, inorder.size()));
        return root;
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
