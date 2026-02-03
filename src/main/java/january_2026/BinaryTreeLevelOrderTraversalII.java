package january_2026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> result = binaryTreeLevelOrderTraversalII.levelOrderBottom(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.removeFirst();
                level.add(current.val);
                if (current.left != null) {
                    queue.addLast(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(0, level);
        }
        return result;
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
