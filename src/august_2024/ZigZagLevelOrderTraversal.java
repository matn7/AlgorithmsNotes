package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);
        node.right.left.left = new Node(13);
        node.right.left.right = new Node(12);
        node.right.right.left = new Node(11);
        node.right.right.right = new Node(10);

        zigZagLevel(node);
    }

    // O(n) time | O(n) space
    public static List<List<Integer>> zigZagLevel(Node node) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.add(node);
        while (!currentLevel.isEmpty()) {
            int size = currentLevel.size();
            List<Integer> elements = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node popped = currentLevel.pop();
                elements.add(popped.value);

                if (leftToRight) {
                    if (popped.left != null) {
                        nextLevel.add(popped.left);
                    }
                    if (popped.right != null) {
                        nextLevel.add(popped.right);
                    }
                } else {
                    if (popped.right != null) {
                        nextLevel.add(popped.right);
                    }
                    if (popped.left != null) {
                        nextLevel.add(popped.left);
                    }
                }
                if (currentLevel.size() == 0) {
                    currentLevel = nextLevel;
                    nextLevel = new Stack<>();
                    leftToRight = ! leftToRight;
                }

            }
            result.add(elements);
        }
        currentLevel.add(node);

        return result;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
