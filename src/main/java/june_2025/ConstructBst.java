package june_2025;

import java.util.Arrays;

public class ConstructBst {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBst constructBst = new ConstructBst();
        TreeNode treeNode = constructBst.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    // O(n^2) time | O(n^2) space
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (idx == preorder.length || inorder.length == 0) {
            return null;
        }

        int nodeVal =  preorder[idx];
        TreeNode node = new TreeNode(nodeVal);
        int j = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == nodeVal) {
                break;
            }
            j++;
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, j);
        int[] rightInorder = Arrays.copyOfRange(inorder, j + 1, inorder.length);
        idx++;
        node.left = buildTree(preorder, leftInorder);
        node.right = buildTree(preorder, rightInorder);
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
