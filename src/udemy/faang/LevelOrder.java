package udemy.faang;

import educative.topkelements.FrequencySort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(3);
        tree.left = new BinaryTree(6);
        tree.right = new BinaryTree(1);
        tree.left.left = new BinaryTree(9);
        tree.left.right = new BinaryTree(2);
        tree.right.right = new BinaryTree(4);
        tree.left.left.right = new BinaryTree(5);
        tree.left.left.right.left = new BinaryTree(8);

        levelOrder(tree);

    }

    // O(n) time | O(n) space (n for result, and (n/2) for queue as max size of queue is n/2 for last level*)
    public static List<List<Integer>> levelOrder(BinaryTree root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int count = 0;
            List<Integer> currentLevelValue = new ArrayList<>();
            while (count < length) {
                BinaryTree currentNode = queue.poll();
                currentLevelValue.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                count++;
            }
            result.add(currentLevelValue);
        }
        return result;
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
