package udemy.faang;

import java.util.*;

public class RightSideView {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.right = new BinaryTree(6);
        tree.left.left.right = new BinaryTree(7);
        tree.left.left.right.left = new BinaryTree(8);

        rightSideView(tree);
        rightSideViewDFS(tree);
        rightSideView2(tree);
    }

    // O(n) time | O(n) space
    public static List<Integer> rightSideView(BinaryTree root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            int count = 0;
            while (count < levelLength) {
                BinaryTree currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                if (count == levelLength - 1) {
                    result.add(currentNode.value);
                }
                count++;
            }
        }
        return result;
    }

    // PreOrder:  [1, 3, 6, 2, 5, 4, 7, 8]
    // InOrder:   [6, 3, 1, 5, 2, 7, 8, 4]
    // PostOrder: [6, 3, 5, 8, 7, 4, 2, 1]
    // My Solution
    // O(n) time | O(n) space
    public static List<Integer> rightSideViewDFS(BinaryTree root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int level = 0;
        rightFirstPreOrder(root, level, result);
        return result;
    }

    private static void rightFirstPreOrder(BinaryTree node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(node.value);
        }
        int newLevel = level + 1;
        rightFirstPreOrder(node.right, newLevel, result);
        rightFirstPreOrder(node.left, newLevel, result);
    }

    // O(n) time | O(n) space
    public static List<Integer> rightSideView2(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(BinaryTree node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (level >= result.size()) {
            result.add(node.value);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, result);
        }
        if (node.left != null) {
            dfs(node.left, level + 1, result);
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
