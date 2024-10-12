package udemy.faang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        BinaryTree tree = new BinaryTree(3);
        tree.left = new BinaryTree(6);
        tree.right = new BinaryTree(1);
        tree.left.left = new BinaryTree(9);
        tree.left.right = new BinaryTree(2);
        tree.right.right = new BinaryTree(4);
        tree.left.left.right = new BinaryTree(5);
        tree.left.left.right.left = new BinaryTree(8);

        levelOrderTraversal.levelOrderTraversal(tree);

    }

    // O(n) time | O(n) space
    public List<List<Integer>> levelOrderTraversal(BinaryTree tree) {
        if (tree == null) {
            return new ArrayList<>();
        }

        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(tree, 0));

        List<TreeInfo> treeInfoList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeInfo current = queue.poll();
            BinaryTree currentNode = current.node;
            int currentLevel = current.level;
            treeInfoList.add(current);
            if (currentNode.left != null) {
                queue.add(new TreeInfo(currentNode.left, currentLevel + 1));
            }
            if (currentNode.right != null) {
                queue.add(new TreeInfo(currentNode.right, currentLevel + 1));
            }
        }
        TreeInfo lastElement = treeInfoList.get(treeInfoList.size() - 1);
        int numOfLevels = lastElement.level;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= numOfLevels; i++) {
            result.add(new ArrayList<>());
        }
        while (!treeInfoList.isEmpty()) {
            TreeInfo topElem = treeInfoList.remove(0);
            int currLevel = topElem.level;
            BinaryTree currNode = topElem.node;
            result.get(currLevel).add(currNode.value);
        }
        return result;
    }

    static class TreeInfo {
        BinaryTree node;
        int level;

        public TreeInfo(BinaryTree node, int level) {
            this.node = node;
            this.level = level;
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
