package march_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZag {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(13);
        root.right.left.right = new TreeNode(12);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(10);

        ZigZag zigZag = new ZigZag();
        List<List<Integer>> result = zigZag.zigzagLevelOrder(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        boolean leftRight = true;
        Stack<TreeNode> currLevel = new Stack<>();
        currLevel.push(root);
        Stack<TreeNode> nextLevel = new Stack<>();
        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = currLevel.pop();
                level.add(currNode.val);

                if (leftRight) {
                    if (currNode.left != null) {
                        nextLevel.push(currNode.left);
                    }
                    if (currNode.right != null) {
                        nextLevel.push(currNode.right);
                    }
                } else {
                    if (currNode.right != null) {
                        nextLevel.push(currNode.right);
                    }
                    if (currNode.left != null) {
                        nextLevel.push(currNode.left);
                    }
                }
            }
            currLevel = nextLevel;
            nextLevel = new Stack<>();
            leftRight = !leftRight;
            res.add(level);
        }
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
