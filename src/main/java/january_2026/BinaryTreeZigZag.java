package january_2026;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZag {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeZigZag binaryTreeZigZag = new BinaryTreeZigZag();
        List<List<Integer>> result = binaryTreeZigZag.zigzagLevelOrder(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        boolean leftToRight = false;
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<>();
        currLevel.addLast(root);

        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();

        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = currLevel.removeLast();
                level.add(currNode.val);

                if (leftToRight) {
                    if (currNode.left != null) {
                        nextLevel.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        nextLevel.addLast(currNode.right);
                    }
                } else {
                    if (currNode.right != null) {
                        nextLevel.addLast(currNode.right);
                    }
                    if (currNode.left != null) {
                        nextLevel.addLast(currNode.left);
                    }
                }
            }

            currLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
            leftToRight = !leftToRight;
            result.add(level);
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
