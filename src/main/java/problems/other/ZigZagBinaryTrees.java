package problems.other;

import java.util.*;
import java.util.Queue;

public class ZigZagBinaryTrees {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        ZigZagBinaryTrees zigZagBinaryTrees = new ZigZagBinaryTrees();
        zigZagBinaryTrees.zigzag_order(node);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(n) space
    public List<Integer> zigzag_order(TreeNode tree) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> currLevel = new Stack<>();
        currLevel.add(tree);
        Stack<TreeNode> nextLevel = new Stack<>();
        boolean leftToRight = false;

        while (currLevel.size() > 0) {
            TreeNode node = currLevel.pop();
            result.add(node.value);

            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            if (!leftToRight) {
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
            }

            if (currLevel.size() == 0) {
                leftToRight = !leftToRight;
                currLevel = nextLevel;
                nextLevel = new Stack<>();
            }

        }

        return result;
    }

    // ===================
    public List<Integer> zigZag(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> result = new ArrayList<>();

        boolean queueTurn = true;
        int iter = 0;

        while (iter < 100) {
            int queueSize = queue.size();
            while (queueSize > 0) {
                TreeNode curr = queue.poll();
                System.out.print(curr.value + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                queueSize--;
            }

            while (!queue.isEmpty()) {
                stack.add(queue.poll());
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.peek().value + " ");
                result.add(stack.pop().value);
            }

            System.out.println();
            iter++;
        }

        return null;
    }

}
