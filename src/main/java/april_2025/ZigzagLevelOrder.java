package april_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        List<List<Integer>> result = zigzagLevelOrder.zigzagLevelOrder(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currLevel.push(root);

        while (!currLevel.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = currLevel.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = currLevel.pop();
                level.add(top.val);

                if (leftToRight) {
                    if (top.left != null) {
                        nextLevel.push(top.left);
                    }
                    if (top.right != null) {
                        nextLevel.push(top.right);
                    }
                } else {
                    if (top.right != null) {
                        nextLevel.push(top.right);
                    }
                    if (top.left != null) {
                        nextLevel.push(top.left);
                    }
                }
            }
            currLevel = nextLevel;
            nextLevel = new Stack<>();
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
