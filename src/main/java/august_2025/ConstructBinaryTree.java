package august_2025;

import java.util.Arrays;

public class ConstructBinaryTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode tree = constructBinaryTree.buildTree(preorder, inorder);
        System.out.println(tree);
    }

    // O(n^2) time | O(n^2) space
    int pos = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (pos == preorder.length || inorder.length == 0) {
            return null;
        }
        int nodeVal = preorder[pos];
        TreeNode newNode = new TreeNode(nodeVal);
        int idx = 0;
        while (inorder[idx] != nodeVal) {
            idx++;
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, idx);
        int[] rightIn = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

        pos++;
        newNode.left = buildTree(preorder, leftIn);
        newNode.right = buildTree(preorder, rightIn);

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
