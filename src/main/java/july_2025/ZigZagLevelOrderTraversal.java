package july_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigZagLevelOrderTraversal zigZagLevelOrderTraversal = new ZigZagLevelOrderTraversal();
        List<List<Integer>> result = zigZagLevelOrderTraversal.zigzagLevelOrder(root);
        System.out.println(result);
    }

    // Intuition:
    // - Binary Tree - DS class TreeNode (left, right)
    // - Level order - BFS
    // - Direction LTR, RTL
    // Approach:
    // - Use collections to store level elements
    // - Use variable to determine order
    // - Check corner cases (root null)
    // Complexity:
    // - O(n) time | O(n) space
    // Code:

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean leftToRight = true;
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currLevel.add(root);

        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode elem = currLevel.pop();
                level.add(elem.val);
                if (leftToRight) {
                    if (elem.left != null) {
                        nextLevel.add(elem.left);
                    }
                    if (elem.right != null) {
                        nextLevel.add(elem.right);
                    }
                } else {
                    if (elem.right != null) {
                        nextLevel.add(elem.right);
                    }
                    if (elem.left != null) {
                        nextLevel.add(elem.left);
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
