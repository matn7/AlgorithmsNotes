package december_2024;

import java.util.ArrayList;
import java.util.List;

public class ConstructBst {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        ConstructBst constructBst = new ConstructBst();
        TreeNode treeNode = constructBst.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        for (int num : preorder) {
            pre.add(num);
        }
        List<Integer> in = new ArrayList<>();
        for (int num : inorder) {
            in.add(num);
        }
        return helper(pre, in, 0, 0, preorder.length);
    }

    private TreeNode helper(List<Integer> preorder, List<Integer> inorder, int preStart, int inStart, int length) {
        if (length == 0) {
            return null;
        }

        // Create the root node
        TreeNode root = new TreeNode(preorder.get(preStart));

        // Find the root in the inorder list
        int mid = inStart;
        while (mid < inStart + length && inorder.get(mid) != preorder.get(preStart)) {
            mid++;
        }

        // Length of the left subtree
        int leftLength = mid - inStart;

        // Recursively build left and right subtrees
        root.left = helper(preorder, inorder, preStart + 1, inStart, leftLength);
        root.right = helper(preorder, inorder, preStart + 1 + leftLength, mid + 1, length - leftLength - 1);

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
