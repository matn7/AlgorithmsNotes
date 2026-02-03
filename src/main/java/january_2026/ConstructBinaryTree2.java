package january_2026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree2 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        ConstructBinaryTree2 constructBinaryTree2 = new ConstructBinaryTree2();
        TreeNode node = constructBinaryTree2.buildTree(preorder, inorder);
        System.out.println(node);
    }

    // O(n) time | O(n) space
    private int preorderIdx = 0;
    private Map<Integer, Integer> inorderIndexesMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexesMap.put(inorder[i], i);
        }

        return buildSubtree(0, inorder.length - 1, preorder);
    }

    private TreeNode buildSubtree(int left, int right, int[] preorder) {
        if (left > right) {
            return null;
        }
        int val = preorder[preorderIdx];

        int inorderIdx = inorderIndexesMap.get(val);
        TreeNode node = new TreeNode(val);
        preorderIdx++;

        node.left = buildSubtree(left, inorderIdx - 1, preorder);
        node.right = buildSubtree(inorderIdx + 1, right, preorder);
        return node;
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
